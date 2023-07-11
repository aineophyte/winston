package com.aineophyte.connectfour.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GamePiece;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.TurnStatus;

public class MoveEvaluator
{
	private static final Logger logger = LoggerFactory.getLogger(MoveEvaluator.class);
	
	private final Boolean[][] boardGrid = new Boolean[7][6];
	private final GameBoard board;
	private int xCoord;
	private int yCoord = 0;
	private boolean player2;
	
	public MoveEvaluator(GameBoard board, int xCoord, boolean player2)
	{
		this.board = board;
		this.xCoord = xCoord;
		this.player2 = player2;
		for (GameSlot slot : board.getSlotsList()) {			
			boardGrid[slot.getXCoord() - 1][slot.getYCoord() - 1] = slot.getPiece().getPlayer2();
		}
	}
	
	public void setXCoord(int xCoord)
	{
		this.xCoord = xCoord;
	}
	
	public void setPlayer2(boolean player2)
	{
		this.player2 = player2;
	}
	
	public TurnStatus preCheck()
	{
		// TODO if the game logic ever supports a different size board
		// the MoveEvaluator will need to know the size.
		if ((xCoord < 1) || (xCoord > 7)) {
			return TurnStatus.INVALID;
		}
		
		return TurnStatus.UNRECOGNIZED;
	}
		
	public MoveResult evaluate()
	{
        TurnStatus status;
        GameSlot moveSlot = null;
        yCoord = 0;

        int moveCount = board.getSlotsCount();
        
		for (GameSlot slot : board.getSlotsList()) {
			if (slot.getXCoord() == xCoord) {
				yCoord++;
			}
		}
		
		if (yCoord == 6) {
			status = TurnStatus.SLOT_OCCUPIED;
		} else {
			yCoord++;
			int moveNumber = moveCount + 1;
			if (isRowWinner() || isColumnWinner() ||
					isDiagonalWinnerUp() || isDiagonalWinnerDown()) {
				status = TurnStatus.WINNER;
			} else if (moveNumber == 42) {
				status = TurnStatus.DRAW;
			} else {
				status = TurnStatus.VALID;
			}
			GamePiece piece = GamePiece.newBuilder().setPlayer2(player2).setMoveNumber(moveNumber).build();
			moveSlot = GameSlot.newBuilder().setXCoord(xCoord).setYCoord(yCoord)
					.setPiece(piece).build();				
		}
		
		return new MoveResult(status, moveSlot);		
	}
	
	private boolean isRowWinner()
	{
		int playerRun = 1;
		
		// go backward up to 3 columns until an empty or opposite player is found
		for (int x = xCoord - 1; x > 0; x--) {
			Boolean occupiedWithPlayer2 = boardGrid[x - 1][yCoord - 1];
			if ((occupiedWithPlayer2 == null) || (occupiedWithPlayer2 != player2)) {
				break;
			}
			playerRun++;
			if (playerRun == 4) {
				if (logger.isDebugEnabled()) {
					logger.debug(String.format("Player %s is winner in row %d", player2 ? "Two" : "One", yCoord));
				}
				return true;
			}
		}
		
		// go forward until there is a run of 4 or an empty or opposite player is found
		for (int x = xCoord + 1; x < 8; x++) {
			Boolean occupiedWithPlayer2 = boardGrid[x - 1][yCoord - 1];
			if ((occupiedWithPlayer2 == null) || (occupiedWithPlayer2 != player2)) {
				break;
			}
			playerRun++;
			if (playerRun == 4) {
				if (logger.isDebugEnabled()) {
					logger.debug(String.format("Player %s is winner in row %d", player2 ? "Two" : "One", yCoord));
				}
				return true;
			}			
		}
        
		return false;
	}
	
	private boolean isColumnWinner()
	{
		if (yCoord < 4) {
			return false;
		}
		
		int playerRun = 1;
		
		// go backward up to 3 rows until an empty or opposite player is found
		for (int y = yCoord - 1; y > 0; y--) {
			Boolean occupiedWithPlayer2 = boardGrid[xCoord - 1][y - 1];
			if ((occupiedWithPlayer2 == null) || (occupiedWithPlayer2 != player2)) {
				break;
			}
			playerRun++;
			if (playerRun == 4) {
				if (logger.isDebugEnabled()) {
					logger.debug(String.format("Player %s is winner in column %d", player2 ? "Two" : "One", xCoord));
				}
				return true;
			}
		}
        
		return false;
	}
	
	private boolean isDiagonalWinner(boolean up)
	{
		int playerRun = 1;
		
		// go backward/down-up up to 3 columns/rows until an empty or opposite player is found
		int y = yCoord;
		for (int x = xCoord - 1; x > 0; x--) {
			if (up) {
				if (--y < 1) {
					break;
				}
			} else if (++y > 6) {
				break;
			}
			
			Boolean occupiedWithPlayer2 = boardGrid[x - 1][y - 1];
			if ((occupiedWithPlayer2 == null) || (occupiedWithPlayer2 != player2)) {
				break;
			}
			playerRun++;
			if (playerRun == 4) {
				return true;
			}
		}
		
		// go forward/up-down until there is a run of 4 or an empty or opposite player is found
		y = yCoord;
		for (int x = xCoord + 1; x < 8; x++) {
			if (up) {
				if (++y > 6) {
					break;
				}
			} else if (--y < 1) {
				break;
			}
			
			Boolean occupiedWithPlayer2 = boardGrid[x - 1][y - 1];
			if ((occupiedWithPlayer2 == null) || (occupiedWithPlayer2 != player2)) {
				break;
			}
			playerRun++;
			if (playerRun == 4) {
				return true;
			}
		}
        
		return false;
	}

	private boolean isDiagonalWinnerUp()
	{
		boolean winner = isDiagonalWinner(true);
		
		if (winner && logger.isDebugEnabled()) {
			logger.debug(String.format("Player %s is diagonal up winner", player2 ? "Two" : "One"));
		}
		
		return winner;
	}
	
	private boolean isDiagonalWinnerDown()
	{
		boolean winner = isDiagonalWinner(false);
		
		if (winner && logger.isDebugEnabled()) {
			logger.debug(String.format("Player %s is diagonal down winner", player2 ? "Two" : "One"));
		}
		
		return winner;
	}
	
	public Boolean[][] getBoardGrid()
	{
		return boardGrid;
	}
}
