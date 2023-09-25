
package com.aineophyte.connectfour.logic.autoplay;

/**
 * Not implemented yet.  It will currently just do the same
 * thing as MiniMax.
 * 
 * Needs to do Alpha/Beta pruning as each node is processed up
 * from the bottom to eliminate unneeded static evaluations and
 * board expansions.
 * 
 * @author krasr
 *
 */
public class AlphaBetaPlayStrategy extends MiniMaxPlayStrategy
{
	AlphaBetaPlayStrategy withFavorMiddle(boolean favorMiddle)
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
	AlphaBetaPlayStrategy withDepth(int depth)
	{
		this.depth = depth;
		return this;
	}
}
