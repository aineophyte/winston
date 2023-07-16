package com.aineophyte.connectfour.server;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import com.aineophyte.connectfour.dao.DataAccessFactory;
import com.aineophyte.connectfour.ConnectFourGrpc;
import com.aineophyte.connectfour.DeleteResult;
import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;

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
		@Override
		public void getBoard(GameInfo request, StreamObserver<GameBoard> responseObserver)
		{
			responseObserver.onNext(new GameImpl().getBoard(request));
			responseObserver.onCompleted();
		}
		
		@Override
		public void startGame(GameInfo request, StreamObserver<GameInfo> responseObserver)
		{
			responseObserver.onNext(new GameImpl().startGame(request));
			responseObserver.onCompleted();
		}
		
		@Override
	    public void executeTurn(TurnInfo request, StreamObserver<TurnResult> responseObserver)
		{
			responseObserver.onNext(new GameImpl().executeTurn(request));
			responseObserver.onCompleted();
		}
		
		@Override
	    public void deleteGame(GameInfo request, StreamObserver<DeleteResult> responseObserver)
		{
			responseObserver.onNext(new GameImpl().deleteGame(request));
			responseObserver.onCompleted();
		}
	}
}