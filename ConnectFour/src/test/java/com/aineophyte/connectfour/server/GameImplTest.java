package com.aineophyte.connectfour.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.PlayerInfo;
import com.aineophyte.connectfour.TurnInfo;
import com.aineophyte.connectfour.TurnResult;
import com.aineophyte.connectfour.TurnStatus;
import com.aineophyte.connectfour.api.ConnectFour;

public class GameImplTest
{
	protected static ConnectFour client;
	private GameInfo currentGame = null;
	
	protected void initClient()
	{
		client = new GameImpl();	
	}
	
	@BeforeEach
	private void beforeTest()
	{
		initClient();
	}
	
	@AfterEach
	private void afterTest()
	{
		if (currentGame != null) {
			client.deleteGame(currentGame);
			currentGame = null;
		}
	}
	
	private GameInfo startGame(GameInfo gameInfo)
	{
		currentGame = client.startGame(gameInfo);
		return currentGame;
	}
	
	@Test
	public void testPlayerOneColumnWinner()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Joshua").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);		  
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.WINNER, result7.getStatus(), "Unexpected turn result");
	}
	
	@Test
	public void testPlayerOneRowWinner()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Atom").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.WINNER, result9.getStatus(), "Unexpected turn result");
	}
	
	@Test
	public void testPlayerOneDiagonalUpWinner()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Johnny5").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);		  
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.VALID, result9.getStatus(), "Unexpected turn result");
		
		TurnInfo turn10 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(true).build();
		TurnResult result10 = client.executeTurn(turn10);
		assertEquals(TurnStatus.VALID, result10.getStatus(), "Unexpected turn result");
		
		TurnInfo turn11 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result11 = client.executeTurn(turn11);
		assertEquals(TurnStatus.VALID, result11.getStatus(), "Unexpected turn result");
		
		TurnInfo turn12 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(true).build();
		TurnResult result12 = client.executeTurn(turn12);
		assertEquals(TurnStatus.VALID, result12.getStatus(), "Unexpected turn result");
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");
		
		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.VALID, result17.getStatus(), "Unexpected turn result");
		
		TurnInfo turn18 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(true).build();
		TurnResult result18 = client.executeTurn(turn18);
		assertEquals(TurnStatus.VALID, result18.getStatus(), "Unexpected turn result");
		
		TurnInfo turn19 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result19 = client.executeTurn(turn19);
		assertEquals(TurnStatus.VALID, result19.getStatus(), "Unexpected turn result");
		
		TurnInfo turn20 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		TurnResult result20 = client.executeTurn(turn20);
		assertEquals(TurnStatus.VALID, result20.getStatus(), "Unexpected turn result");
		
		TurnInfo turn21 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result21 = client.executeTurn(turn21);
		assertEquals(TurnStatus.WINNER, result21.getStatus(), "Unexpected turn result");
	}
	
	@Test
	public void testPlayerOneDiagonalDownWinner()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Ultron").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);		  
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.VALID, result9.getStatus(), "Unexpected turn result");
		
		TurnInfo turn10 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(true).build();
		TurnResult result10 = client.executeTurn(turn10);
		assertEquals(TurnStatus.VALID, result10.getStatus(), "Unexpected turn result");
		
		TurnInfo turn11 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result11 = client.executeTurn(turn11);
		assertEquals(TurnStatus.VALID, result11.getStatus(), "Unexpected turn result");
		
		TurnInfo turn12 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(true).build();
		TurnResult result12 = client.executeTurn(turn12);
		assertEquals(TurnStatus.VALID, result12.getStatus(), "Unexpected turn result");
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");
		
		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.VALID, result17.getStatus(), "Unexpected turn result");
		
		TurnInfo turn18 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(true).build();
		TurnResult result18 = client.executeTurn(turn18);
		assertEquals(TurnStatus.VALID, result18.getStatus(), "Unexpected turn result");
		
		TurnInfo turn19 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(7).setPlayer2(false).build();
		TurnResult result19 = client.executeTurn(turn19);
		assertEquals(TurnStatus.VALID, result19.getStatus(), "Unexpected turn result");
		
		TurnInfo turn20 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(true).build();
		TurnResult result20 = client.executeTurn(turn20);
		assertEquals(TurnStatus.VALID, result20.getStatus(), "Unexpected turn result");
		
		TurnInfo turn21 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result21 = client.executeTurn(turn21);
		assertEquals(TurnStatus.VALID, result21.getStatus(), "Unexpected turn result");
		
		TurnInfo turn22 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		TurnResult result22 = client.executeTurn(turn22);
		assertEquals(TurnStatus.VALID, result22.getStatus(), "Unexpected turn result");
		
		TurnInfo turn23 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result23 = client.executeTurn(turn23);
		assertEquals(TurnStatus.VALID, result23.getStatus(), "Unexpected turn result");
		
		TurnInfo turn24 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(1).setPlayer2(true).build();
		TurnResult result24 = client.executeTurn(turn24);
		assertEquals(TurnStatus.VALID, result24.getStatus(), "Unexpected turn result");
		
		TurnInfo turn25 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(false).build();
		TurnResult result25 = client.executeTurn(turn25);
		assertEquals(TurnStatus.WINNER, result25.getStatus(), "Unexpected turn result");
	}
	
	@Test
	public void testMoveErrors()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Sonny").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);	  
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.OUT_OF_TURN, result2.getStatus(), "Unexpected turn result");

		turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(0).setPlayer2(true).build();
		result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.INVALID, result2.getStatus(), "Unexpected turn result");
		
		turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(8).setPlayer2(true).build();
		result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.INVALID, result2.getStatus(), "Unexpected turn result");
		
		turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.OUT_OF_TURN, result3.getStatus(), "Unexpected turn result");
		
		turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");
		
		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.SLOT_OCCUPIED, result7.getStatus(), "Unexpected turn result");
	}
	
	@Test
	public void testPlayerTwoFavorMiddleWinner()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Ultron").setMode("FAVOR_MIDDLE").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);		  
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.VALID, result9.getStatus(), "Unexpected turn result");
		
		TurnInfo turn10 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result10 = client.executeTurn(turn10);
		assertEquals(TurnStatus.VALID, result10.getStatus(), "Unexpected turn result");
		
		TurnInfo turn11 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result11 = client.executeTurn(turn11);
		assertEquals(TurnStatus.VALID, result11.getStatus(), "Unexpected turn result");
		
		TurnInfo turn12 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result12 = client.executeTurn(turn12);
		assertEquals(TurnStatus.VALID, result12.getStatus(), "Unexpected turn result");
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");
		
		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.VALID, result17.getStatus(), "Unexpected turn result");
		
		TurnInfo turn18 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result18 = client.executeTurn(turn18);
		assertEquals(TurnStatus.VALID, result18.getStatus(), "Unexpected turn result");
		
		TurnInfo turn19 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(6).setPlayer2(false).build();
		TurnResult result19 = client.executeTurn(turn19);
		assertEquals(TurnStatus.VALID, result19.getStatus(), "Unexpected turn result");
		
		TurnInfo turn20 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result20 = client.executeTurn(turn20);
		assertEquals(TurnStatus.WINNER, result20.getStatus(), "Unexpected turn result");
		
		GameBoard board = client.getBoard(response);
		System.out.println(board);
	}
}
