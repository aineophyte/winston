package com.aineophyte.connectfour.logic;

import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.TurnStatus;

public class MoveResult
{
    private final GameSlot slot;
    private final TurnStatus status;
    
    MoveResult(TurnStatus status, GameSlot slot)
    {
    	this.status = status;
    	this.slot = slot;
    }

	public GameSlot getSlot()
	{
		return slot;
	}

	public TurnStatus getStatus()
	{
		return status;
	}
}
