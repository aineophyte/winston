package com.aineophyte.connectfour.server;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import com.aineophyte.connectfour.dao.DataAccessFactory;
import com.aineophyte.connectfour.logic.MoveEvaluator;
import com.aineophyte.connectfour.logic.MoveResult;
import com.aineophyte.connectfour.logic.TurnOrderCheck;
import com.aineophyte.connectfour.logic.autoplay.PlayStrategyFactory;
import com.aineophyte.connectfour.ConnectFourGrpc;
import com.aineophyte.connectfour.DeleteResult;
import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.PlayerInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;
import com.aineophyte.connectfour.TurnStatus;
import com.aineophyte.connectfour.api.ConnectFourPlayStrategy;

public class ConnectFourServer
{
	private final int port;
	private final Server server;

	public ConnectFourServer(int port) throws IOException
	{
		this.port = port;
		this.server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create()).addService(new ConnectFourService()).build();
	}

	/** Start serving requests. */
	public void start() throws IOException
	{
	    server.start();
	    // logger.info("Server started, listening on " + port);
	    Runtime.getRuntime().addShutdownHook(new Thread() {
	    	@Override
	    	public void run()
	    	{
	    	    // Use stderr here since the logger may have been reset by its JVM shutdown hook.
		        System.err.println("*** shutting down gRPC server since JVM is shutting down");
		        try {
		        	ConnectFourServer.this.stop();
		        } catch (InterruptedException e) {
		            e.printStackTrace(System.err);
		        }
		        try {
		        	DataAccessFactory.getDataAccess().close();
		        } catch (Exception e) {
		        	e.printStackTrace(System.err);
		        }
		        System.err.println("*** server shut down");
	        }
	    });
	}
	
	/** Stop serving requests and shutdown resources. */
	public void stop() throws InterruptedException
	{
	    if (server != null) {
	    	server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
	    }   
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException
	{
	    if (server != null) {
	    	server.awaitTermination();
	    }
	}

	/**
	 * Main method.  This comment makes the linter happy.
	 */
	public static void main(String[] args) throws Exception
	{
		ConnectFourServer server = new ConnectFourServer(8980);
	    server.start();
	    server.blockUntilShutdown();
	}
	
	private static class ConnectFourService extends ConnectFourGrpc.ConnectFourImplBase
	{
		private static final Logger logger = LoggerFactory.getLogger(ConnectFourService.class);
		
		@Override
		public void getBoard(GameInfo request, StreamObserver<GameBoard> responseObserver)
		{
			UUID gameId = UUID.fromString(request.getGameId());
			responseObserver.onNext(fetchBoard(gameId));
			responseObserver.onCompleted();
		}
		
		@Override
		public void startGame(GameInfo request, StreamObserver<GameInfo> responseObserver)
		{
			responseObserver.onNext(initiateGame(request));
			responseObserver.onCompleted();
		}
		
		@Override
	    public void executeTurn(TurnInfo request, StreamObserver<TurnResult> responseObserver)
		{
			responseObserver.onNext(nextTurn(request));
			responseObserver.onCompleted();
		}
		
		@Override
	    public void deleteGame(GameInfo request, StreamObserver<DeleteResult> responseObserver)
		{
			UUID gameId = UUID.fromString(request.getGameId());
			responseObserver.onNext(delete(gameId));
			responseObserver.onCompleted();
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
		
		private GameInfo initiateGame(GameInfo request)
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
		
		private TurnResult nextTurn(TurnInfo request)
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
		    					    	
		    	MoveEvaluator evaluator = new MoveEvaluator(board, xCoord, request.getPlayer2());
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
		
		private DeleteResult delete(UUID gameId)
		{
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
	}
}