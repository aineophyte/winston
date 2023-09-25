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
	
	protected GameInfo startGame(GameInfo gameInfo)
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
			
	@Test
	public void testPlayerTwoMiniMaxFavorMiddle()
	{
		testPlayerTwoMiniMaxFavorMiddleBase("MINI_MAX_FAVOR_MIDDLE");
	}
	
	@Test
	public void testPlayerTwoAlphaBetaFavorMiddle()
	{
		// This test should yield same results as
		// MINI_MAX_FAVOR_MIDDLE even after we implement the
		// Alpha/Beta pruning but with fewer evaluations.
		testPlayerTwoMiniMaxFavorMiddleBase("ALPHA_BETA_FAVOR_MIDDLE");
	}

	private void testPlayerTwoMiniMaxFavorMiddleBase(String mode)
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Atom").setMode(mode).build();
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
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(1).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");
		
		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(1).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.WINNER, result17.getStatus(), "Unexpected turn result");
		
		GameBoard board = client.getBoard(response);
		System.out.println(board);
	}
	
	
	
	@Test
	public void testPlayerTwoMiniMax()
	{
		testPlayerTwoMiniMaxBase("MINI_MAX");
	}
	
	@Test
	public void testPlayerTwoAlphaBeta()
	{
		// This test should yield same results as
		// MINI_MAX even after we implement the
		// Alpha/Beta pruning but with fewer evaluations
		testPlayerTwoMiniMaxBase("ALPHA_BETA");
	}
	
	private void testPlayerTwoMiniMaxBase(String mode)
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Atom").setMode(mode).build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);	
		
		int player2Evals = 0;
		
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");
		player2Evals += result2.getEvaluations();

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");
		player2Evals += result4.getEvaluations();
		
		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");
		player2Evals += result6.getEvaluations();

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(3).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		player2Evals += result8.getEvaluations();
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.VALID, result9.getStatus(), "Unexpected turn result");
		
		TurnInfo turn10 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result10 = client.executeTurn(turn10);
		assertEquals(TurnStatus.VALID, result10.getStatus(), "Unexpected turn result");
		player2Evals += result10.getEvaluations();
		
		TurnInfo turn11 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(5).setPlayer2(false).build();
		TurnResult result11 = client.executeTurn(turn11);
		assertEquals(TurnStatus.VALID, result11.getStatus(), "Unexpected turn result");
		
		TurnInfo turn12 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result12 = client.executeTurn(turn12);
		assertEquals(TurnStatus.VALID, result12.getStatus(), "Unexpected turn result");
		player2Evals += result12.getEvaluations();
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(1).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");
		player2Evals += result14.getEvaluations();

		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(4).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		player2Evals += result16.getEvaluations();
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(2).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.VALID, result17.getStatus(), "Unexpected turn result");
		
		TurnInfo turn18 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result18 = client.executeTurn(turn18);
		assertEquals(TurnStatus.WINNER, result18.getStatus(), "Unexpected turn result");
		player2Evals += result18.getEvaluations();

		GameBoard board = client.getBoard(response);
		System.out.println(board);
		System.out.println("Player 2 evaluations = " + player2Evals);
	}
	
	@Test
	public void testDualingMiniMaxFavorMiddle()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").setMode("MINI_MAX_FAVOR_MIDDLE").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Atom").setMode("MINI_MAX_FAVOR_MIDDLE").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);	
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.VALID, result9.getStatus(), "Unexpected turn result");
		
		TurnInfo turn10 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result10 = client.executeTurn(turn10);
		assertEquals(TurnStatus.VALID, result10.getStatus(), "Unexpected turn result");
		
		TurnInfo turn11 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result11 = client.executeTurn(turn11);
		assertEquals(TurnStatus.VALID, result11.getStatus(), "Unexpected turn result");
		
		TurnInfo turn12 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result12 = client.executeTurn(turn12);
		assertEquals(TurnStatus.VALID, result12.getStatus(), "Unexpected turn result");
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");

		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.VALID, result17.getStatus(), "Unexpected turn result");
		
		TurnInfo turn18 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result18 = client.executeTurn(turn18);
		assertEquals(TurnStatus.VALID, result18.getStatus(), "Unexpected turn result");
		
		TurnInfo turn19 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result19 = client.executeTurn(turn19);
		assertEquals(TurnStatus.VALID, result19.getStatus(), "Unexpected turn result");
		
		TurnInfo turn20 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result20 = client.executeTurn(turn20);
		assertEquals(TurnStatus.VALID, result20.getStatus(), "Unexpected turn result");
		
		TurnInfo turn21 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result21 = client.executeTurn(turn21);
		assertEquals(TurnStatus.VALID, result21.getStatus(), "Unexpected turn result");
		
		TurnInfo turn22 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result22 = client.executeTurn(turn22);
		assertEquals(TurnStatus.VALID, result22.getStatus(), "Unexpected turn result");
		
		TurnInfo turn23 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result23 = client.executeTurn(turn23);
		assertEquals(TurnStatus.VALID, result23.getStatus(), "Unexpected turn result");
		
		TurnInfo turn24 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result24 = client.executeTurn(turn24);
		assertEquals(TurnStatus.VALID, result24.getStatus(), "Unexpected turn result");
		
		TurnInfo turn25 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result25 = client.executeTurn(turn25);
		assertEquals(TurnStatus.VALID, result25.getStatus(), "Unexpected turn result");
		
		TurnInfo turn26 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result26 = client.executeTurn(turn26);
		assertEquals(TurnStatus.WINNER, result26.getStatus(), "Unexpected turn result");
		
		GameBoard board = client.getBoard(response);
		System.out.println(board);
	}
	
	@Test
	public void testDualingMiniMax()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").setMode("MINI_MAX").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Atom").setMode("MINI_MAX").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);	
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.VALID, result9.getStatus(), "Unexpected turn result");
		
		TurnInfo turn10 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result10 = client.executeTurn(turn10);
		assertEquals(TurnStatus.VALID, result10.getStatus(), "Unexpected turn result");
		
		TurnInfo turn11 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result11 = client.executeTurn(turn11);
		assertEquals(TurnStatus.VALID, result11.getStatus(), "Unexpected turn result");
		
		TurnInfo turn12 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result12 = client.executeTurn(turn12);
		assertEquals(TurnStatus.VALID, result12.getStatus(), "Unexpected turn result");
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");

		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.VALID, result17.getStatus(), "Unexpected turn result");
		
		TurnInfo turn18 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result18 = client.executeTurn(turn18);
		assertEquals(TurnStatus.VALID, result18.getStatus(), "Unexpected turn result");
		
		TurnInfo turn19 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result19 = client.executeTurn(turn19);
		assertEquals(TurnStatus.VALID, result19.getStatus(), "Unexpected turn result");
		
		TurnInfo turn20 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result20 = client.executeTurn(turn20);
		assertEquals(TurnStatus.VALID, result20.getStatus(), "Unexpected turn result");
		
		TurnInfo turn21 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result21 = client.executeTurn(turn21);
		assertEquals(TurnStatus.VALID, result21.getStatus(), "Unexpected turn result");
		
		TurnInfo turn22 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result22 = client.executeTurn(turn22);
		assertEquals(TurnStatus.VALID, result22.getStatus(), "Unexpected turn result");
		
		TurnInfo turn23 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result23 = client.executeTurn(turn23);
		assertEquals(TurnStatus.WINNER, result23.getStatus(), "Unexpected turn result");
		
		GameBoard board = client.getBoard(response);
		System.out.println(board);
	}
	
	@Test
	public void testDualingMiniMaxPlayerOneFavorMiddle()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").setMode("MINI_MAX_FAVOR_MIDDLE").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Atom").setMode("MINI_MAX").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);	
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.VALID, result9.getStatus(), "Unexpected turn result");
		
		TurnInfo turn10 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result10 = client.executeTurn(turn10);
		assertEquals(TurnStatus.VALID, result10.getStatus(), "Unexpected turn result");
		
		TurnInfo turn11 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result11 = client.executeTurn(turn11);
		assertEquals(TurnStatus.VALID, result11.getStatus(), "Unexpected turn result");
		
		TurnInfo turn12 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result12 = client.executeTurn(turn12);
		assertEquals(TurnStatus.VALID, result12.getStatus(), "Unexpected turn result");
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");

		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.VALID, result17.getStatus(), "Unexpected turn result");
		
		TurnInfo turn18 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result18 = client.executeTurn(turn18);
		assertEquals(TurnStatus.VALID, result18.getStatus(), "Unexpected turn result");
		
		TurnInfo turn19 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result19 = client.executeTurn(turn19);
		assertEquals(TurnStatus.WINNER, result19.getStatus(), "Unexpected turn result");
		
		GameBoard board = client.getBoard(response);
		System.out.println(board);
	}
	
	@Test
	public void testDualingMiniMaxPlayerTwoFavorMiddle()
	{
		PlayerInfo player1 = PlayerInfo.newBuilder().setName("Scott").setMode("MINI_MAX").build();
		PlayerInfo player2 = PlayerInfo.newBuilder().setName("Atom").setMode("MINI_MAX_FAVOR_MIDDLE").build();
		GameInfo gameInfo = GameInfo.newBuilder().setPlayer1(player1).setPlayer2(player2).build();
		GameInfo response = startGame(gameInfo);	
		  
		TurnInfo turn1 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result1 = client.executeTurn(turn1);
		assertEquals(TurnStatus.VALID, result1.getStatus(), "Unexpected turn result");

		TurnInfo turn2 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result2 = client.executeTurn(turn2);
		assertEquals(TurnStatus.VALID, result2.getStatus(), "Unexpected turn result");

		TurnInfo turn3 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result3 = client.executeTurn(turn3);
		assertEquals(TurnStatus.VALID, result3.getStatus(), "Unexpected turn result");

		TurnInfo turn4 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result4 = client.executeTurn(turn4);
		assertEquals(TurnStatus.VALID, result4.getStatus(), "Unexpected turn result");

		TurnInfo turn5 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result5 = client.executeTurn(turn5);
		assertEquals(TurnStatus.VALID, result5.getStatus(), "Unexpected turn result");

		TurnInfo turn6 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result6 = client.executeTurn(turn6);
		assertEquals(TurnStatus.VALID, result6.getStatus(), "Unexpected turn result");

		TurnInfo turn7 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result7 = client.executeTurn(turn7);
		assertEquals(TurnStatus.VALID, result7.getStatus(), "Unexpected turn result");
		
		TurnInfo turn8 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result8 = client.executeTurn(turn8);
		assertEquals(TurnStatus.VALID, result8.getStatus(), "Unexpected turn result");
		
		TurnInfo turn9 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result9 = client.executeTurn(turn9);
		assertEquals(TurnStatus.VALID, result9.getStatus(), "Unexpected turn result");
		
		TurnInfo turn10 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result10 = client.executeTurn(turn10);
		assertEquals(TurnStatus.VALID, result10.getStatus(), "Unexpected turn result");
		
		TurnInfo turn11 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result11 = client.executeTurn(turn11);
		assertEquals(TurnStatus.VALID, result11.getStatus(), "Unexpected turn result");
		
		TurnInfo turn12 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result12 = client.executeTurn(turn12);
		assertEquals(TurnStatus.VALID, result12.getStatus(), "Unexpected turn result");
		
		TurnInfo turn13 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result13 = client.executeTurn(turn13);
		assertEquals(TurnStatus.VALID, result13.getStatus(), "Unexpected turn result");
		
		TurnInfo turn14 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result14 = client.executeTurn(turn14);
		assertEquals(TurnStatus.VALID, result14.getStatus(), "Unexpected turn result");

		TurnInfo turn15 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result15 = client.executeTurn(turn15);
		assertEquals(TurnStatus.VALID, result15.getStatus(), "Unexpected turn result");
		
		TurnInfo turn16 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result16 = client.executeTurn(turn16);
		assertEquals(TurnStatus.VALID, result16.getStatus(), "Unexpected turn result");
		
		TurnInfo turn17 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result17 = client.executeTurn(turn17);
		assertEquals(TurnStatus.VALID, result17.getStatus(), "Unexpected turn result");
		
		TurnInfo turn18 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result18 = client.executeTurn(turn18);
		assertEquals(TurnStatus.VALID, result18.getStatus(), "Unexpected turn result");
		
		TurnInfo turn19 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result19 = client.executeTurn(turn19);
		assertEquals(TurnStatus.VALID, result19.getStatus(), "Unexpected turn result");
		
		TurnInfo turn20 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result20 = client.executeTurn(turn20);
		assertEquals(TurnStatus.VALID, result20.getStatus(), "Unexpected turn result");
		
		TurnInfo turn21 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result21 = client.executeTurn(turn21);
		assertEquals(TurnStatus.VALID, result21.getStatus(), "Unexpected turn result");
		
		TurnInfo turn22 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result22 = client.executeTurn(turn22);
		assertEquals(TurnStatus.VALID, result22.getStatus(), "Unexpected turn result");
		
		TurnInfo turn23 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result23 = client.executeTurn(turn23);
		assertEquals(TurnStatus.VALID, result23.getStatus(), "Unexpected turn result");
		
		TurnInfo turn24 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result24 = client.executeTurn(turn24);
		assertEquals(TurnStatus.VALID, result24.getStatus(), "Unexpected turn result");
		
		TurnInfo turn25 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result25 = client.executeTurn(turn25);
		assertEquals(TurnStatus.VALID, result25.getStatus(), "Unexpected turn result");
		
		TurnInfo turn26 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result26 = client.executeTurn(turn26);
		assertEquals(TurnStatus.VALID, result26.getStatus(), "Unexpected turn result");
		
		TurnInfo turn27 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result27 = client.executeTurn(turn27);
		assertEquals(TurnStatus.VALID, result27.getStatus(), "Unexpected turn result");
		
		TurnInfo turn28 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result28 = client.executeTurn(turn28);
		assertEquals(TurnStatus.VALID, result28.getStatus(), "Unexpected turn result");

		TurnInfo turn29 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result29 = client.executeTurn(turn29);
		assertEquals(TurnStatus.VALID, result29.getStatus(), "Unexpected turn result");
		
		TurnInfo turn30 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result30 = client.executeTurn(turn30);
		assertEquals(TurnStatus.VALID, result30.getStatus(), "Unexpected turn result");
		
		TurnInfo turn31 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result31 = client.executeTurn(turn31);
		assertEquals(TurnStatus.VALID, result31.getStatus(), "Unexpected turn result");
		
		TurnInfo turn32 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result32 = client.executeTurn(turn32);
		assertEquals(TurnStatus.VALID, result32.getStatus(), "Unexpected turn result");
		
		TurnInfo turn33 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result33 = client.executeTurn(turn33);
		assertEquals(TurnStatus.VALID, result33.getStatus(), "Unexpected turn result");
		
		TurnInfo turn34 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result34 = client.executeTurn(turn34);
		assertEquals(TurnStatus.VALID, result34.getStatus(), "Unexpected turn result");
		
		TurnInfo turn35 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result35 = client.executeTurn(turn35);
		assertEquals(TurnStatus.VALID, result35.getStatus(), "Unexpected turn result");
		
		TurnInfo turn36 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result36 = client.executeTurn(turn36);
		assertEquals(TurnStatus.VALID, result36.getStatus(), "Unexpected turn result");
		
		TurnInfo turn37 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result37 = client.executeTurn(turn37);
		assertEquals(TurnStatus.VALID, result37.getStatus(), "Unexpected turn result");
		
		TurnInfo turn38 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result38 = client.executeTurn(turn38);
		assertEquals(TurnStatus.VALID, result38.getStatus(), "Unexpected turn result");
		
		TurnInfo turn39 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result39 = client.executeTurn(turn39);
		assertEquals(TurnStatus.VALID, result39.getStatus(), "Unexpected turn result");
		
		TurnInfo turn40 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result40 = client.executeTurn(turn40);
		assertEquals(TurnStatus.VALID, result40.getStatus(), "Unexpected turn result");
		
		TurnInfo turn41 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(false).build();
		TurnResult result41 = client.executeTurn(turn41);
		assertEquals(TurnStatus.VALID, result41.getStatus(), "Unexpected turn result");
		
		TurnInfo turn42 = TurnInfo.newBuilder().setGameId(response.getGameId()).setXCoord(-1).setPlayer2(true).build();
		TurnResult result42 = client.executeTurn(turn42);
		assertEquals(TurnStatus.DRAW, result42.getStatus(), "Unexpected turn result");
		
		GameBoard board = client.getBoard(response);
		System.out.println(board);
	}
}
