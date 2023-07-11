package com.aineophyte.connectfour.logic;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.TurnStatus;

public class TurnOrderCheck
{
	public TurnStatus verify(GameBoard board, boolean player2)
	{
		int currentMoveCount = board.getSlotsCount();
		
		if (isWrongTurn(currentMoveCount, player2)) {
			return TurnStatus.OUT_OF_TURN;
		}
		
		return TurnStatus.UNRECOGNIZED;
	}
	
	private boolean isWrongTurn(int numberOfTurns, boolean player2)
	{
		boolean odd = ((numberOfTurns % 2) == 1);
		
		return (odd && !player2) || (!odd && player2);
	}
}
