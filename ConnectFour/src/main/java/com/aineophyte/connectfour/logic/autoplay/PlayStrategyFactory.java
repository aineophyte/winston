package com.aineophyte.connectfour.logic.autoplay;

import com.aineophyte.connectfour.api.ConnectFourPlayStrategy;

public class PlayStrategyFactory
{
    public static ConnectFourPlayStrategy get(String mode)
    {
    	if ("FAVOR_MIDDLE".equals(mode)) {
    		return new FavorMiddlePlayStrategy();
    	}
    	
    	return null;
    }
}
