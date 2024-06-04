package com.aineophyte.propagation.core;

public enum CellStates
{
    NOTHING, SET, CONTRADICTION;
    
    boolean isNothing()
    {
    	return this == NOTHING;
    }
    
    boolean isSet()
    {
    	return this == SET;
    }
    
    boolean isContradiction()
    {
    	return this == CONTRADICTION;
    }
}
