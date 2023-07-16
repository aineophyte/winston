package com.aineophyte.connectfour.api;

import com.aineophyte.connectfour.ConnectFourGrpc;
import com.aineophyte.connectfour.ConnectFourGrpc.ConnectFourBlockingStub;
import com.aineophyte.connectfour.ConnectFourGrpc.ConnectFourStub;
import com.aineophyte.connectfour.DeleteResult;
import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;

import io.grpc.Channel;

public class ConnectFourClient implements ConnectFour
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
	  
	  public DeleteResult deleteGame(GameInfo request)
	  {
		  return blockingStub.deleteGame(request);
	  }
}
