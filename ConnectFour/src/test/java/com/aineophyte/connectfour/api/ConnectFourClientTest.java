package com.aineophyte.connectfour.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.PlayerInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;
import com.aineophyte.connectfour.TurnStatus;
import com.aineophyte.connectfour.server.GameImplTest;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

/**
 * Really integration tests that rely on a running server.
 */
public class ConnectFourClientTest extends GameImplTest
{
	protected void initClient()
	{
		if (client == null) {
			String target = "localhost:8980";
			ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
			client = new ConnectFourClient(channel);			
		}		
	}
	
	@Test
	public void testAsyncNextTurn() throws InterruptedException
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Joshua").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);		  
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnCallback callback = new TurnCallback();
		((ConnectFourClient)client).executeTurnAsync(turn1, callback);
		
		checkResult(TurnStatus.VALID, callback);
	}
	
	private void checkResult(TurnStatus expected, TurnCallback callback)
	{
		while (!callback.done) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
		TurnResult result = callback.result;
		assertNotNull(result, "Expected a non-null turn result");
		assertEquals(expected, result.getStatus(), "Unexpected turn result");
		
	}
	
	class TurnCallback implements StreamObserver<TurnResult>
	{
		boolean done = false;
		TurnResult result = null;
		
		@Override
		public void onNext(TurnResult value)
		{
		    System.out.println("Received result: " + value);
		    result = value;
		}

		@Override
		public void onError(Throwable cause)
		{
			System.out.println("Received error: " + cause.getMessage());
			done = true;
		}

		@Override
		public void onCompleted()
		{
			System.out.println("Turn result stream completed");
			done = true;
		}
	}
}
