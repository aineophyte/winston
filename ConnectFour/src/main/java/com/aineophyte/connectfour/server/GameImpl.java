package com.aineophyte.connectfour.server;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aineophyte.connectfour.DeleteResult;
import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.PlayerInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;
import com.aineophyte.connectfour.TurnStatus;
import com.aineophyte.connectfour.api.ConnectFour;
import com.aineophyte.connectfour.api.ConnectFourPlayStrategy;
import com.aineophyte.connectfour.dao.DataAccessFactory;
import com.aineophyte.connectfour.logic.MoveEvaluator;
import com.aineophyte.connectfour.logic.MoveResult;
import com.aineophyte.connectfour.logic.TurnOrderCheck;
import com.aineophyte.connectfour.logic.autoplay.PlayStrategyFactory;

class GameImpl implements ConnectFour {

	private static final Logger logger = LoggerFactory.getLogger(GameImpl.class);
	
	@Override
	public GameInfo startGame(GameInfo request)
	{
	    if (logger.isDebugEnabled()) {
	    	logger.debug("start initiateGame");
	    }

	    try {
			PlayerInfo player1 = request.getPlayer1();
			PlayerInfo player2 = request.getPlayer2();
			// need to validate the players including the auto mode
			// strategies
			UUID gameId = UUID.randomUUID();
			
			DataAccessFactory.getDataAccess().insertNewGame(gameId, player1, player2);
			
			GameInfo info = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).setGameId(gameId.toString()).build();
			return info;		    	
	    } finally {
		    if (logger.isDebugEnabled()) {
		    	logger.debug("end initiateGame");
		    }		    	
	    }
	}

	@Override
	public GameBoard getBoard(GameInfo request)
	{
		UUID gameId = UUID.fromString(request.getGameId());
		return fetchBoard(gameId);
	}

	@Override
	public TurnResult executeTurn(TurnInfo request)
	{
	    if (logger.isDebugEnabled()) {
	    	logger.debug("start nextTurn for game: " + request.getGameId());
	    }
	    
	    try {
	    	 
	    	UUID gameId = UUID.fromString(request.getGameId());
	    	
	    	// need the board info to see if the turn info makes sense
	    	GameBoard board = fetchBoard(gameId);
	    	
	    	TurnStatus status = new TurnOrderCheck().verify(board, request.getPlayer2());
	    	
	    	if (status == TurnStatus.OUT_OF_TURN) {
	    		return TurnResult.newBuilder().setStatus(status).build();
	    	}
	    	
	    	// need the game info to see if anyone is auto play
	    	GameInfo gameInfo = DataAccessFactory.getDataAccess().fetchGameInfo(gameId);
	    	
	    	String playerMode = request.getPlayer2() ? gameInfo.getPlayer2().getMode() :
	    		gameInfo.getPlayer1().getMode();
	    	
	    	ConnectFourPlayStrategy playerStrategy = PlayStrategyFactory.get(playerMode);
	    	
	    	int xCoord = (playerStrategy == null) ? request.getXCoord() : playerStrategy.getSlot(board);
	    					    	
	    	MoveEvaluator evaluator = new MoveEvaluator(board, xCoord, request.getPlayer2()).withLoggingEnabled(true);
	    	status = evaluator.preCheck();
	    	
	    	if (status == TurnStatus.UNRECOGNIZED) {					
				MoveResult result = evaluator.evaluate();
				status = result.getStatus();
				if ((status == TurnStatus.VALID) || (status == TurnStatus.WINNER) || (status == TurnStatus.DRAW)) {
					GameSlot slot = result.getSlot();
					DataAccessFactory.getDataAccess().insertGamePiece(gameId, slot);
					return TurnResult.newBuilder().setStatus(status).setMoveNumber(slot.getPiece().getMoveNumber()).build();
				}		    		
	    	}
			
			return TurnResult.newBuilder().setStatus(status).build();
	    	
	    } finally {
		    if (logger.isDebugEnabled()) {
		    	logger.debug("end nextTurn for game: " + request.getGameId());
		    }		    	
	    }
	}

	@Override
	public DeleteResult deleteGame(GameInfo request)
	{
		UUID gameId = UUID.fromString(request.getGameId());
	    if (logger.isDebugEnabled()) {
	    	logger.debug("start delete for game: " + gameId);
	    }
		try {
			DataAccessFactory.getDataAccess().delete(gameId);
			return DeleteResult.newBuilder().setGameId(gameId.toString()).build();
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("end delete for game: " + gameId);					
			}
		}
	}
	
	private GameBoard fetchBoard(UUID gameId)
	{
	    if (logger.isDebugEnabled()) {
	    	logger.debug("start fetchBoard for game: " + gameId);
	    }
		try {
			return DataAccessFactory.getDataAccess().fetchBoard(gameId);				
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("end fetchBoard for game: " + gameId);					
			}
		}
	}

}
