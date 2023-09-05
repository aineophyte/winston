package com.aineophyte.connectfour.logic;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GamePiece;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.TurnStatus;

public class MoveEvaluator extends BoardEvaluator
{	
	private final GameBoard board;
	
	public MoveEvaluator(GameBoard board, int xCoord, boolean player2)
	{
		super(new Boolean[7][6], xCoord, 0, player2);
		this.board = board;
		for (GameSlot slot : board.getSlotsList()) {			
			boardGrid[slot.getXCoord() - 1][slot.getYCoord() - 1] = slot.getPiece().getPlayer2();
		}
	}
	
	public MoveEvaluator withLoggingEnabled(boolean enabled)
	{
		this.loggingEnabled = enabled;
		return this;
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
			if (isWinner()) {
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
		
	public Boolean[][] getBoardGrid()
	{
		return boardGrid;
	}
}
