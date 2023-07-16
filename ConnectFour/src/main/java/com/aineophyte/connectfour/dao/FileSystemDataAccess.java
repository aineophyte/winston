package com.aineophyte.connectfour.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.UUID;

import com.aineophyte.connectfour.GameBoard;
import com.aineophyte.connectfour.GameBoard.Builder;
import com.aineophyte.connectfour.GameInfo;
import com.aineophyte.connectfour.GameSlot;
import com.aineophyte.connectfour.PlayerInfo;

public class FileSystemDataAccess implements DataAccess {
	private static final String FILE_SYSTEM_PATH =
			System.getProperty("com.aineophyte.connectfour.dao.FileSystemDataAccess", "C:\\Users\\connectfour\\"); // System.getProperty("java.io.tmpdir")
	private static final String GAME_INFO_FILE_NAME = "connectfour.game_info";
	private static final String BOARD_INFO_FILE_NAME = "connectfour.board_info";

	@Override
	public void close() throws Exception
	{
	}

	@Override
	public void insertNewGame(UUID gameId, PlayerInfo player1, PlayerInfo player2)
	{
		String gameIdString = gameId.toString();
		GameInfo gameInfo = GameInfo.newBuilder().setGameId(gameIdString)
				.setPlayer1(player1).setPlayer2(player2).build();
		Path gamePath = FileSystems.getDefault().getPath(FILE_SYSTEM_PATH, gameIdString);
		try {
		    Files.createDirectory(gamePath);
		    try (OutputStream os = Files.newOutputStream(FileSystems.getDefault().getPath(FILE_SYSTEM_PATH, gameIdString, GAME_INFO_FILE_NAME), StandardOpenOption.CREATE_NEW)) {
			   gameInfo.writeTo(os);
		    }
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public GameBoard fetchBoard(UUID gameId)
	{
		return fetchBoardInfo(gameId.toString());
	}

	@Override
	public void insertGamePiece(UUID gameId, GameSlot slot)
	{
		String gameIdString = gameId.toString();
		GameBoard existingBoard = fetchBoardInfo(gameIdString);
		Builder builder = GameBoard.newBuilder(existingBoard);
		builder.addSlots(slot);
		GameBoard updatedBoard = builder.build();

		try {
		    try (OutputStream os = Files.newOutputStream(FileSystems.getDefault().getPath(FILE_SYSTEM_PATH, gameIdString, BOARD_INFO_FILE_NAME), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
		    	updatedBoard.writeTo(os);
			}			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(UUID gameId)
	{
		String gameIdString = gameId.toString();
		Path gamePath = FileSystems.getDefault().getPath(FILE_SYSTEM_PATH, gameIdString);
		try {
			deletePath(gamePath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public GameInfo fetchGameInfo(UUID gameId)
	{
		String gameIdString = gameId.toString();
		try {
		    try (InputStream is = Files.newInputStream(FileSystems.getDefault().getPath(FILE_SYSTEM_PATH, gameIdString, GAME_INFO_FILE_NAME), StandardOpenOption.READ)) {
		    	GameInfo gameInfo = GameInfo.parseFrom(is);
		    	return gameInfo;
		    }
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void deletePath(Path start) throws IOException
	{
	    Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
	        @Override
	        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
	            throws IOException
	        {
	            Files.delete(file);
	            return FileVisitResult.CONTINUE;
	        }
	        @Override
	        public FileVisitResult postVisitDirectory(Path dir, IOException e)
	            throws IOException
	        {
	            if (e == null) {
	                Files.delete(dir);
	                return FileVisitResult.CONTINUE;
	            } else {
	                // directory iteration failed
	                throw e;
	            }
	        }
	    });		
	}
	
	private GameBoard fetchBoardInfo(String gameIdString)
	{
		try {
			Path boardPath = FileSystems.getDefault().getPath(FILE_SYSTEM_PATH, gameIdString, BOARD_INFO_FILE_NAME);
			if (!Files.exists(boardPath)) {
				return GameBoard.newBuilder().build();
			}
			
		    try (InputStream is = Files.newInputStream(boardPath, StandardOpenOption.READ)) {
		    	GameBoard board = GameBoard.parseFrom(is);
		    	return board;
		    }
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
