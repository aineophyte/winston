package com.aineophyte.connectfour.logic.autoplay;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.api.ConnectFourSlotInfo;

/**
 * This is just a simplistic auto play mode where it take
 * the middle vertical slot if its still possible to win
 * vertically in that slot; otherwise it tries one column from
 * the middle and continues to move away from the middle.  Once
 * vertical wins are not possible, the move will just rotate away
 * from the middle and then go back to the middle based on the player's
 * previous move.
 * 
 * @author krasr
 */
public class FavorMiddlePlayStrategy extends BasePlayStrategy
{
	private Boolean[][] boardGrid;
	
	@Override
	ConnectFourSlotInfo getCalculatedSlot(Boolean[][] boardGrid)
	{
        this.boardGrid = boardGrid;
        
        ConnectFourSlotInfo slotInfo = new ConnectFourSlotInfo();
		
		// Take the middle if a column run of 4 is still possible,
        // otherwise work out from the middle, making the same
        // check in each column.
        if (isPotentialWin(4)) {
        	slotInfo.setSlot(4);
        	return slotInfo;
        }

        if (isPotentialWin(3)) {
        	slotInfo.setSlot(3);
        	return slotInfo;
        }
        
        if (isPotentialWin(5)) {
        	slotInfo.setSlot(5);
        	return slotInfo;
        }
        
        if (isPotentialWin(2)) {
        	slotInfo.setSlot(2);
        	return slotInfo;
        }
        
        if (isPotentialWin(6)) {
        	slotInfo.setSlot(6);
        	return slotInfo;
        }
        
        if (isPotentialWin(1)) {
        	slotInfo.setSlot(1);
        	return slotInfo;
        }
        
        if (isPotentialWin(7)) {
        	slotInfo.setSlot(7);
        	return slotInfo;
        }
		
		// Work away and back to the middle based on the previous move
        int lastSlotMove = getLastSlot(board);
        int nextChoice = getNextChoice(lastSlotMove);
        
        for (int i = 1; i <= 7; i++) {
        	if (isSlotAvailable(nextChoice)) {
        		slotInfo.setSlot(nextChoice);
        		return slotInfo;
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
	
	static int getNextChoice(int xCoord) {
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
