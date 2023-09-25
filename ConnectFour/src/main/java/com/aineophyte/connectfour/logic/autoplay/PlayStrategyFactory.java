package com.aineophyte.connectfour.logic.autoplay;

import com.aineophyte.connectfour.api.ConnectFourPlayStrategy;

public class PlayStrategyFactory
{
    public static ConnectFourPlayStrategy get(String mode)
    {
    	if ("FAVOR_MIDDLE".equals(mode)) {
    		return new FavorMiddlePlayStrategy();
    	}
    	
    	if ("MINI_MAX_FAVOR_MIDDLE".equals(mode)) {
    		return new MiniMaxPlayStrategy().withFavorMiddle(true);
    	}
    	
    	if ("ALPHA_BETA_FAVOR_MIDDLE".equals(mode)) {
    		return new AlphaBetaPlayStrategy().withFavorMiddle(true);
    	}
    	
    	if ("MINI_MAX".equals(mode)) {
    		return new MiniMaxPlayStrategy();
    	}
    	
    	if ("ALPHA_BETA".equals(mode)) {
    		return new AlphaBetaPlayStrategy();
    	}
    	
    	return null;
    }
}
