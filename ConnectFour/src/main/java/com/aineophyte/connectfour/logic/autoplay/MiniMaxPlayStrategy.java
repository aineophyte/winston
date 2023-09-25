
package com.aineophyte.connectfour.logic.autoplay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aineophyte.connectfour.api.ConnectFourSlotInfo;
import com.aineophyte.connectfour.logic.BoardEvaluator;
import com.aineophyte.connectfour.util.Tree;
import com.aineophyte.connectfour.util.Tree.Node;

public class MiniMaxPlayStrategy extends BasePlayStrategy
{
	private static final Logger logger = LoggerFactory.getLogger(MiniMaxPlayStrategy.class);
	
	private boolean player2;
	boolean favorMiddle = false;
	int depth = 7;
	
	MiniMaxPlayStrategy withFavorMiddle(boolean favorMiddle)
	{
		this.favorMiddle = favorMiddle;
		return this;
	}
	
	/**
	 * Default depth is 7.  It doesn't make sense to use an even number.
	 * From testing, 7 levels uses 2G of memory and takes less than 1 second
	 * to build out the game tree. 8 levels jumped to 4G and 7 seconds.
	 * 9 levels caused my 8G desktop to freeze.
	 * 
	 * @param depth
	 * @return
	 */
	MiniMaxPlayStrategy withDepth(int depth)
	{
		this.depth = depth;
		return this;
	}

	@Override
	ConnectFourSlotInfo getCalculatedSlot(Boolean[][] boardGrid)
	{
		AlphaBetaNodeInfo info = new AlphaBetaNodeInfo(boardGrid, 0, true);
		Tree<AlphaBetaNodeInfo> gameTree = new Tree<>(info);
	    if (logger.isDebugEnabled()) {
	    	logger.debug(String.format("start buildGameTree: max memory %d: total memory %d: free memory %d",
	    			Runtime.getRuntime().maxMemory(), Runtime.getRuntime().totalMemory(), Runtime.getRuntime().freeMemory()));
	    }
	    Tracker tracker = new Tracker();
		int autoMoveSlot = buildGameTree(gameTree.getRoot(), 1, player2, favorMiddle ? 4 : 1, tracker).slot;
	    if (logger.isDebugEnabled()) {
	    	logger.debug(String.format("end buildGameTree: max memory %d: total memory %d: free memory %d",
	    			Runtime.getRuntime().maxMemory(), Runtime.getRuntime().totalMemory(), Runtime.getRuntime().freeMemory()));
	    	
	    	logger.debug(String.format("auto play move is slot %d from %d evaluations", autoMoveSlot, tracker.getEvalCount()));
	    }
	    
	    ConnectFourSlotInfo slotInfo = new ConnectFourSlotInfo();
	    slotInfo.setSlot(autoMoveSlot);
	    slotInfo.setEvaluations(tracker.getEvalCount());
		return slotInfo;
	}
	
	private AlphaBetaNodeInfo buildGameTree(Node<AlphaBetaNodeInfo> gameTreeNode, int level, boolean player2, int startSlot, Tracker tracker)
	{
		if (level > depth) {
			return null;
		}
		
		boolean opponent = ((level % 2) == 0);
		
		Boolean[][] boardGrid = gameTreeNode.getData().getBoardGrid();
		
		AlphaBetaNodeInfo levelNodeInfo = null;
		
		int x = startSlot;
		for (int i = 1; i <= 7; i++) {
		    int slotRow = 0;
			for (int y = 1; y <= 6; y++) {
				if (boardGrid[x-1][y-1] == null) {
					slotRow = y;
					break;
				}
			}
			
			if (slotRow > 0) {
				Boolean[][] clone = BoardEvaluator.getClone(boardGrid);
				clone[x-1][slotRow-1] = player2;
				AlphaBetaNodeInfo childInfo = new AlphaBetaNodeInfo(clone, x, opponent);
				Node<AlphaBetaNodeInfo> childNode = gameTreeNode.addChild(childInfo);
				
				AlphaBetaNodeInfo buildNodeInfo = buildGameTree(childNode, level + 1, !player2, opponent ? startSlot : favorMiddle ? FavorMiddlePlayStrategy.getNextChoice(startSlot) : startSlot, tracker);

				int childScore = (buildNodeInfo != null) ? buildNodeInfo.score : 0;
				
				if (buildNodeInfo != null) {
					if (levelNodeInfo == null) {
						levelNodeInfo = buildNodeInfo;
					} else if (!opponent && (childScore > levelNodeInfo.score)) {
						levelNodeInfo = buildNodeInfo;
					} else if (opponent && (childScore < levelNodeInfo.score)) {
						levelNodeInfo = buildNodeInfo;
					}
				}
				
				BoardEvaluator evaluator = new BoardEvaluator(clone, x, slotRow, player2);
				int score = 0;
				if (evaluator.isWinner()) {
					if (opponent) {
						childInfo.setScore(-1);
						return childInfo;
					}
					score = 16;
				} else if (!opponent) {
					
					if (childScore > -1) {
						
						if ((level == depth) && evaluator.isPossibleWinnerForNextPlayer()) {
							// don't move into a loss, if it's going to be a loss
							// use a score of -1.
							score = -1;
						} else {
							// TODO this is the static evaluation for the player's current
							// move.  It probably needs its own method or class.  It is
							// currently very simplistic and looks at how many of the 4
							// directions the player can still get a run of 4 pieces from this
							// board location.  It doesn't account for open spaces below
							// where those runs occur for horizontal and the 2 diagonal
							// directions.
							int rowRun = evaluator.getRowRun();
							int columnRun = evaluator.getColumnRun();
							int diagonalUpRun = evaluator.getDiagonalRun(true);
							int diagonalDownRun = evaluator.getDiagonalRun(false);
							
							int zeroCounts = 0;
							int twoCounts = 0;
							int threeCounts = 0;
							if (rowRun == 0) {
								zeroCounts++;
							} else if (rowRun == 2) {
								twoCounts++;
							} else if (rowRun == 3) {
								threeCounts++;
							}
							
							score += rowRun;
							
							if (columnRun == 0) {
								zeroCounts++;
							} else if (columnRun == 2) {
								twoCounts++;
							} else if (columnRun == 3) {
								threeCounts++;
							}
							
							score += columnRun;
							
							if (diagonalUpRun == 0) {
								zeroCounts++;
							} else if (diagonalUpRun == 2) {
								twoCounts++;
							} else if (diagonalUpRun == 3) {
								threeCounts++;
							}
							
							score += diagonalUpRun;
							
							if (diagonalDownRun == 0) {
								zeroCounts++;
							} else if (diagonalDownRun == 2) {
								twoCounts++;
							} else if (diagonalDownRun == 3) {
								threeCounts++;
							}
							
							score += diagonalDownRun;
							
							if (threeCounts > 1) {
								score+=2;
							}
							
							if (twoCounts > 1) {
								score++;
							}
							
							if (zeroCounts > 1) {
								score--;
							}
							
							if (score < 0) {
								score = 0;
							}							
						}
					} else {
						score = -1;
					}

				}

				if (!opponent) {
					tracker.incrementEvalCount();
					
					childInfo.setScore(score);
					
					if (levelNodeInfo == null) {
						levelNodeInfo = childInfo;
					} else if (childInfo.score > levelNodeInfo.score) {
						levelNodeInfo = childInfo;
					}						
				}
			}
			
			x = favorMiddle ? FavorMiddlePlayStrategy.getNextChoice(x) : i + 1;
		}
	    
		return levelNodeInfo;
	}
	
	private static class Tracker
	{
		private int evalCount = 0;
		
		void incrementEvalCount()
		{
			evalCount++;
		}
		
		int getEvalCount()
		{
			return evalCount;
		}
	}
	
	private static class AlphaBetaNodeInfo
	{
		private final Boolean[][] boardGrid;
		private final int slot;
		private final boolean opponent;
		private int score;
		
		AlphaBetaNodeInfo(Boolean[][] boardGrid, int slot, boolean opponent)
		{
			this.boardGrid = boardGrid;
			this.slot = slot;
			this.opponent = opponent;
		}
		
		Boolean[][] getBoardGrid()
		{
			return boardGrid;		
		}
		
		void setScore(int score)
		{
			this.score = score;
		}
	}
}
