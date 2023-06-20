package com.aineophyte.connectfour.dao;

import java.util.UUID;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.PlayerInfo;

public interface DataAccess
{
	void insertNewGame(UUID gameId, PlayerInfo player1, PlayerInfo player2);
	
	GameBoard fetchBoard(UUID gameId);
	
	void insertGamePiece(UUID gameId, GameSlot slot);
}
