package com.aineophyte.connectfour.dao;

import java.util.Date;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GamePiece;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.PlayerInfo;
import com.aineophyte.connectfour.GameBoard.Builder;

public class CassandraDataAccess implements DataAccess
{
	// make these a properties
	private static final String DB_HOST = "127.0.0.1";
	private static final int DB_PORT = 9042;
	
	private static final String INSERT_NEW_GAME =
			"insert into connectfour.game_info (game_id, player_one_name, player_one_auto, player_two_name, player_two_auto, create_time) " + 
	        "values (?, ?, ?, ?, ?, ?)";
	
	private static final String GET_GAME_BOARD =
			"select slot_dimension_x, slot_dimension_y, player_two from connectfour.board_info " +
	        "where game_id = ?";
	
	private static final String INSERT_GAME_PIECE =
			"insert into connectfour.board_info (game_id, slot_dimension_x, slot_dimension_y, player_two) " + 
	        "values (?, ?, ?, ?)";

	@Override
	public void insertNewGame(UUID gameId, PlayerInfo player1, PlayerInfo player2)
	{
		try (Cluster cluster = Cluster.builder().addContactPoint(DB_HOST).withPort(DB_PORT).build();
			 Session session = cluster.connect("connectfour");) {	
		    PreparedStatement prepared = session.prepare(INSERT_NEW_GAME);
		    Date now = new Date(System.currentTimeMillis());
		    BoundStatement bound = prepared.bind(gameId, player1.getName(), player1.getAutoPlay(), player2.getName(), player2.getAutoPlay(), now);
		    session.execute(bound);
		}
	}

	@Override
	public GameBoard fetchBoard(UUID gameId)
	{
		try (Cluster cluster = Cluster.builder().addContactPoint(DB_HOST).withPort(DB_PORT).build();
		     Session session = cluster.connect("connectfour");) {
			PreparedStatement prepared = session.prepare(GET_GAME_BOARD);
			BoundStatement bound = prepared.bind(gameId);
			ResultSet rs = session.execute(bound);
			
			Builder builder = GameBoard.newBuilder();
			for (Row rowN : rs) {
			    GamePiece piece = GamePiece.newBuilder().setPlayer2(rowN.getBool(2)).build();
			    GameSlot slot = GameSlot.newBuilder().setXCoord(rowN.getInt(0)).setYCoord(rowN.getInt(1)).setPiece(piece).build();
			    builder.addSlots(slot);
			}
			
			return builder.build();			
		}
	}
	
	@Override
	public void insertGamePiece(UUID gameId, GameSlot slot)
	{
		try (Cluster cluster = Cluster.builder().addContactPoint(DB_HOST).withPort(DB_PORT).build();
			 Session session = cluster.connect("connectfour");) {
		    PreparedStatement prepared = session.prepare(INSERT_GAME_PIECE);
		    BoundStatement bound = prepared.bind(gameId, slot.getXCoord(), slot.getYCoord(), slot.getPiece().getPlayer2());
		    session.execute(bound);
		}		
	}
}
