package com.aineophyte.connectfour.logic.autoplay;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.TurnStatus;
import com.aineophyte.connectfour.api.ConnectFourPlayStrategy;
import com.aineophyte.connectfour.api.ConnectFourSlotInfo;
import com.aineophyte.connectfour.logic.MoveEvaluator;
import com.aineophyte.connectfour.logic.MoveResult;

/**
 * Before calculating the next auto move, the base strategy will
 * check for a winning move on the current board or a block of an
 * opponent's winning move.
 * 
 * @author krasr
 */
abstract class BasePlayStrategy implements ConnectFourPlayStrategy
{
	boolean player2;
	GameBoard board;
	
	abstract ConnectFourSlotInfo getCalculatedSlot(Boolean[][] boardGrid);
	
	@Override
	public ConnectFourSlotInfo getSlot(GameBoard board)
	{
		this.board = board;
		int moveCount = board.getSlotsCount();
		player2 = ((moveCount % 2) == 1);
		
		MoveEvaluator evaluator = new MoveEvaluator(board, 0, player2);
		// No need to check for a winner until player1 is making their
		// 4th move or player2 is making their 3rd move.
		if (moveCount >= (player2 ? 5 : 6)) {
			// see if the there is a winning move
			for (int x = 1; x <= 7; x++) {
				evaluator.setXCoord(x);
				
				MoveResult result = evaluator.evaluate();
				if (result.getStatus() == TurnStatus.WINNER) {
					ConnectFourSlotInfo slotInfo = new ConnectFourSlotInfo();
					slotInfo.setSlot(x);
					return slotInfo;
				}
			}
			// see if the other player has a winning move
			// on its next turn, in which case block it.
			evaluator.setPlayer2(!player2);
			for (int x = 1; x <= 7; x++) {				
				evaluator.setXCoord(x);
				
				MoveResult result = evaluator.evaluate();
				if (result.getStatus() == TurnStatus.WINNER) {
					ConnectFourSlotInfo slotInfo = new ConnectFourSlotInfo();
					slotInfo.setSlot(x);
					return slotInfo;
				}
			}
		}
		
		return getCalculatedSlot(evaluator.getBoardGrid());
	}
}
