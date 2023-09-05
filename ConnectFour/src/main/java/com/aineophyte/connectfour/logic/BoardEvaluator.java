package com.aineophyte.connectfour.logic;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardEvaluator
{
	private static final Logger logger = LoggerFactory.getLogger(BoardEvaluator.class);
	
	final Boolean[][] boardGrid;
	int xCoord;
	int yCoord;
	boolean player2;
	boolean loggingEnabled = false;
	
	public BoardEvaluator(Boolean[][] boardGrid, int xCoord, int yCoord, boolean player2)
	{
		this.boardGrid = boardGrid;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.player2 = player2;
	}
	
	public boolean isPossibleWinnerForNextPlayer()
	{
		int origX = xCoord;
		int origY = yCoord;		
		boardGrid[xCoord-1][yCoord-1] = player2;
		player2 = !player2;

        yCoord = 0;
        
        boolean possibleWin = false;
        
		for (int x = 1; x <= 7; x++) {				
			xCoord = x;
			int y = 1;
			while (y <= 6) {
				Boolean occupiedPlayer2 = boardGrid[xCoord -1][y - 1];
				if (occupiedPlayer2 == null) {
					yCoord = y;
					break;
				}
				y++;
			}
			
			if ((yCoord > 0) && isWinner()) {
				possibleWin = true;
				break;
			}
			
			yCoord = 0;
		}

		xCoord = origX;
		yCoord = origY;		
		boardGrid[xCoord-1][yCoord-1] = null;
		player2 = !player2;
		
		return possibleWin;
	}

	public boolean isWinner()
	{
		return isRowWinner() || isColumnWinner() ||
				isDiagonalWinnerUp() || isDiagonalWinnerDown();
	}
	
	public int getPossibleWinSlotsNextMove()
	{
		int possibleWinSlots = 0;
        yCoord = 0;
        
		for (int x = 1; x <= 7; x++) {				
			xCoord = x;
			int y = 1;
			while (y <= 6) {
				Boolean occupiedPlayer2 = boardGrid[xCoord -1][y - 1];
				if (occupiedPlayer2 == null) {
					yCoord = y;
					break;
				}
				y++;
			}
			
			if ((yCoord > 0) && isWinner()) {
				possibleWinSlots++;
			}
			
			yCoord = 0;
		}
	
		return possibleWinSlots;		
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
				if (loggingEnabled && logger.isDebugEnabled()) {
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
				if (loggingEnabled && logger.isDebugEnabled()) {
					logger.debug(String.format("Player %s is winner in row %d", player2 ? "Two" : "One", yCoord));
				}
				return true;
			}			
		}
        
		return false;
	}
	
	public int getRowRun()
	{
		int playerRun = 1;
		int possibleRun = 1;
		
		boolean incrementPlayerRun = true;
		
		for (int x = xCoord - 1; x > 0; x--) {
			Boolean occupiedWithPlayer2 = boardGrid[x - 1][yCoord - 1];			
			boolean isOccupied = occupiedWithPlayer2 != null;
			if (isOccupied && (occupiedWithPlayer2 != player2)) {
				break;
			}
			
			possibleRun++;
			
			if (isOccupied) {
				if (incrementPlayerRun) {
			        playerRun++;
				}
			} else {
				incrementPlayerRun = false;
			}
		}
		
		incrementPlayerRun = true;
		
		for (int x = xCoord + 1; x < 8; x++) {
			Boolean occupiedWithPlayer2 = boardGrid[x - 1][yCoord - 1];
			boolean isOccupied = occupiedWithPlayer2 != null;
			if (isOccupied && (occupiedWithPlayer2 != player2)) {
				break;
			}
			
			possibleRun++;
			
			if (isOccupied) {
				if (incrementPlayerRun) {
			        playerRun++;
				}
			} else {
				incrementPlayerRun = false;	
			}
		}
        
		return (possibleRun >= 4) ? playerRun : 0;
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
			if (occupiedWithPlayer2 != player2) {
				break;
			}
			playerRun++;
			if (playerRun == 4) {
				if (loggingEnabled && logger.isDebugEnabled()) {
					logger.debug(String.format("Player %s is winner in column %d", player2 ? "Two" : "One", xCoord));
				}
				return true;
			}
		}
        
		return false;
	}
	
	public int getColumnRun()
	{
		int playerRun = 1;
		
		for (int y = yCoord - 1; y > 0; y--) {
			Boolean occupiedWithPlayer2 = boardGrid[xCoord - 1][y - 1];
			if (occupiedWithPlayer2 != player2) {
				break;
			}
			playerRun++;
		}
		
		int possibleRun = playerRun + (7 - yCoord);
        
		return (possibleRun >= 4) ? playerRun : 0;
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
	
	public int getDiagonalRun(boolean up)
	{
		int playerRun = 1;
		int possibleRun = 1;
		
		boolean incrementPlayerRun = true;
		
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
			boolean isOccupied = occupiedWithPlayer2 != null;
			if (isOccupied && (occupiedWithPlayer2 != player2)) {
				break;
			}
			
			possibleRun++;
			
			if (isOccupied) {
				if (incrementPlayerRun) {
			        playerRun++;
				}
			} else {
				incrementPlayerRun = false;
			}
		}
		
		incrementPlayerRun = true;
		
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
			boolean isOccupied = occupiedWithPlayer2 != null;
			if (isOccupied && (occupiedWithPlayer2 != player2)) {
				break;
			}
			
			possibleRun++;
			
			if (isOccupied) {
				if (incrementPlayerRun) {
			        playerRun++;
				}
			} else {
				incrementPlayerRun = false;
			}
		}
        
		return (possibleRun >= 4) ? playerRun : 0;
	}

	private boolean isDiagonalWinnerUp()
	{
		boolean winner = isDiagonalWinner(true);
		
		if (winner && loggingEnabled && logger.isDebugEnabled()) {
			logger.debug(String.format("Player %s is diagonal up winner", player2 ? "Two" : "One"));
		}
		
		return winner;
	}
	
	private boolean isDiagonalWinnerDown()
	{
		boolean winner = isDiagonalWinner(false);
		
		if (winner && loggingEnabled && logger.isDebugEnabled()) {
			logger.debug(String.format("Player %s is diagonal down winner", player2 ? "Two" : "One"));
		}
		
		return winner;
	}
	
	public static Boolean[][] getClone(Boolean[][] boardGrid)
	{
		return Arrays.stream(boardGrid).map(Boolean[]::clone).toArray(Boolean[][]::new);
	}
}
