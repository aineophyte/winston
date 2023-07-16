package com.aineophyte.connectfour.logic.autoplay;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.TurnStatus;
import com.aineophyte.connectfour.api.ConnectFourPlayStrategy;
import com.aineophyte.connectfour.logic.MoveEvaluator;
import com.aineophyte.connectfour.logic.MoveResult;

public class FavorMiddlePlayStrategy implements ConnectFourPlayStrategy
{
	private boolean player2;
	private Boolean[][] boardGrid;
	
	@Override
	public int getSlot(GameBoard board)
	{
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
		
        boardGrid = evaluator.getBoardGrid();
		
		// Take the middle if a column run of 4 is still possible,
        // otherwise work out from the middle, making the same
        // check in each column.
        if (isPotentialWin(4)) {
        	return 4;
        }

        if (isPotentialWin(3)) {
        	return 3;
        }
        
        if (isPotentialWin(5)) {
        	return 5;
        }
        
        if (isPotentialWin(2)) {
        	return 2;
        }
        
        if (isPotentialWin(6)) {
        	return 6;
        }
        
        if (isPotentialWin(1)) {
        	return 1;
        }
        
        if (isPotentialWin(7)) {
        	return 7;
        }
		
		// Work away and back to the middle based on the previous move
        int lastSlotMove = getLastSlot(board);
        int nextChoice = getNextChoice(lastSlotMove);
        
        for (int i = 1; i <= 7; i++) {
        	if (isSlotAvailable(nextChoice)) {
        		return nextChoice;
        	}
        	
        	nextChoice = getNextChoice(nextChoice);
        }
		
        throw new IllegalStateException("FavorMiddlePlayStrategy::getSlot should always find an empty slot with proper use.");
	}
	
	private boolean isPotentialWin(int xCoord)
	{
		int playerRun = 0;
		int y = 1;
		while (y <= 6) {
			Boolean occupiedPlayer2 = boardGrid[xCoord -1][y - 1];
			if (occupiedPlayer2 == null) {
				y--;
				break;
			}
			
			if (player2 == occupiedPlayer2) {
				playerRun++;
			} else {
				playerRun = 0;
			}
			
			y++;
		}
		
		return (playerRun + (6 - y)) > 3;
	}
	
	private int getLastSlot(GameBoard board)
	{
		int lastMove = board.getSlotsCount() - 1;
		for (GameSlot slot : board.getSlotsList()) {
			if (slot.getPiece().getMoveNumber() == lastMove) {
				return slot.getXCoord();
			}
		}
		
		throw new IllegalStateException("FavorMiddlePlayStrategy::getLastSlot should always find a previous move.");
	}
	
	private boolean isSlotAvailable(int xCoord)
	{
		int y = 1;
		while (y <= 6) {
			Boolean occupiedPlayer2 = boardGrid[xCoord -1][y - 1];
			if (occupiedPlayer2 == null) {
				return true;
			}
			y++;
		}
		
		return false;
	}
	
	private int getNextChoice(int xCoord) {
		switch (xCoord) {
		    case 4:
		    	return 3;
		    case 3:
		    	return 5;
		    case 5:
		        return 2;
		    case 2:
		    	return 6;
		    case 6:
		    	return 1;
		    case 1:
		    	return 7;
		    case 7:
		    default:
		    	return 4;
		}
	}
}