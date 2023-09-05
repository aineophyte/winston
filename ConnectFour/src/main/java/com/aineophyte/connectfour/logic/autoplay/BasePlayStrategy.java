package com.aineophyte.connectfour.logic.autoplay;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.TurnStatus;
import com.aineophyte.connectfour.api.ConnectFourPlayStrategy;
import com.aineophyte.connectfour.logic.MoveEvaluator;
import com.aineophyte.connectfour.logic.MoveResult;

abstract class BasePlayStrategy implements ConnectFourPlayStrategy
{
	boolean player2;
	GameBoard board;
	
	abstract int getCalculatedSlot(Boolean[][] boardGrid);
	
	@Override
	public int getSlot(GameBoard board)
	{
		this.board = board;
		int moveCount = board.getSlotsCount();
		player2 = ((moveCount % 2) == 1);
		
		MoveEvaluator evaluator = new MoveEvaluator(board, 0, player2);
		if (moveCount >= 5) {
			// see if the there is a winning move
			for (int x = 1; x <= 7; x++) {
				evaluator.setXCoord(x);
				
				MoveResult result = evaluator.evaluate();
				if (result.getStatus() == TurnStatus.WINNER) {
					return x;
				}
			}
			// see if the other player has a winning move
			// on its next turn, in which case block it.
			evaluator.setPlayer2(!player2);
			for (int x = 1; x <= 7; x++) {				
				evaluator.setXCoord(x);
				
				MoveResult result = evaluator.evaluate();
				if (result.getStatus() == TurnStatus.WINNER) {
					return x;
				}
			}
		}
		
		return getCalculatedSlot(evaluator.getBoardGrid());
	}
}
