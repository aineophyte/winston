package com.aineophyte.connectfour.api;

import com.aineophyte.connectfour.DeleteResult;
import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;

/**
 * Common interface to use for the client and server
 * to have a consistent API for testing at either level
 * with the same test data.
 * 
 * @author krasr
 */
public interface ConnectFour
{
	GameInfo startGame(GameInfo request);
	
	GameBoard getBoard(GameInfo request);

	TurnResult executeTurn(TurnInfo request);
	
	DeleteResult deleteGame(GameInfo request);
}
