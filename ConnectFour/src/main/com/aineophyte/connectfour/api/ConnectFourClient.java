package com.aineophyte.connectfour.api;

import com.aineophyte.connectfour.ConnectFourGrpc;
import com.aineophyte.connectfour.ConnectFourGrpc.ConnectFourBlockingStub;
import com.aineophyte.connectfour.ConnectFourGrpc.ConnectFourStub;
import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.PlayerInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

public class ConnectFourClient
{
	  private final ConnectFourBlockingStub blockingStub;
	  private final ConnectFourStub asyncStub;

	  /** Construct client for accessing ConnectFour server using the existing channel. */
	  public ConnectFourClient(Channel channel)
	  {
		  blockingStub = ConnectFourGrpc.newBlockingStub(channel);
		  asyncStub = ConnectFourGrpc.newStub(channel);
	  }
	  
	  public GameBoard getBoard(GameInfo request)
	  {
		  return blockingStub.getBoard(request);
	  }
	  
	  public GameInfo startGame(GameInfo request)
	  {
		  return blockingStub.startGame(request);
	  }
	  
	  public TurnResult executeTurn(TurnInfo request)
	  {
		  return blockingStub.executeTurn(request);
	  }
	  

	  public static void main(String[] args) throws InterruptedException
	  {
		  String target = "localhost:8980";
		  
		  ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
		  ConnectFourClient client = new ConnectFourClient(channel);
		  
		  PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		  PlayerInfo player2 = PlayerInfo.newBuilder().setName("Joshua").setAutoPlay(true).build();
		  GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		  GameInfo response = client.startGame(gameInfo);		  
		  System.out.println(response);
		  GameBoard board = client.getBoard(response);
		  System.out.println(board);
		  
		  TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		  TurnResult result1 = client.executeTurn(turn1);
		  
		  TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(true).build();
		  TurnResult result2 = client.executeTurn(turn2);
		  
		  TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		  TurnResult result3 = client.executeTurn(turn3);
		  
		  board = client.getBoard(response);
		  System.out.println(board);
	  }
}
