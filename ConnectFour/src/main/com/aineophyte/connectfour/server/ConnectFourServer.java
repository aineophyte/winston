package com.aineophyte.connectfour.server;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import com.aineophyte.connectfour.dao.DataAccessFactory;
import com.aineophyte.connectfour.ConnectFourGrpc;
import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.GamePiece;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.PlayerInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;
import com.aineophyte.connectfour.TurnStatus;

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
		
		private GameBoard fetchBoard(UUID gameId)
		{
			return DataAccessFactory.getDataAccess().fetchBoard(gameId);
		}
		
		private GameInfo initiateGame(GameInfo request)
		{
			PlayerInfo player1 = request.getPlayer1();
			PlayerInfo player2 = request.getPlayer2();
			// need to validate the players
			UUID gameId = UUID.randomUUID();
			
			DataAccessFactory.getDataAccess().insertNewGame(gameId, player1, player2);
			
			GameInfo info = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).setGameId(gameId.toString()).build();
			return info;
		}
		
		private TurnResult nextTurn(TurnInfo request)
		{
			TurnStatus status;
			
			int xCoord = request.getXCoord();
			
			if ((xCoord < 1) || (xCoord > 7)) {
				status = TurnStatus.INVALID;
			} else {
				UUID gameId = UUID.fromString(request.getGameId());
				GameBoard board = fetchBoard(gameId);
				if (isWrongTurn(board.getSlotsCount(), request.getPlayer2())) {
					status = TurnStatus.OUT_OF_TURN;
				} else {
					// Count number of game pieces already in the column and see
					// if there is space for this one
					int piecesCount = 0;
					for (GameSlot slot : board.getSlotsList()) {
						if (slot.getXCoord() == xCoord) {
							piecesCount++;
						}
					}
					
					if (piecesCount == 6) {
						status = TurnStatus.SLOT_OCCUPIED;
					} else {
						// TODO determine is winner instead of valid
						GamePiece piece = GamePiece.newBuilder().setPlayer2(request.getPlayer2()).build();
						GameSlot slot = GameSlot.newBuilder().setXCoord(xCoord).setYCoord(piecesCount + 1)
								.setPiece(piece).build();
						DataAccessFactory.getDataAccess().insertGamePiece(gameId, slot);
						status = TurnStatus.VALID;
					}
				}
			}
			
			return TurnResult.newBuilder().setStatus(status).build();
		}
		
		private boolean isWrongTurn(int numberOfTurns, boolean isPlayer2)
		{
			boolean odd = ((numberOfTurns % 2) == 1);
			
			return (odd && !isPlayer2) || (!odd && isPlayer2);
		}
	}
}