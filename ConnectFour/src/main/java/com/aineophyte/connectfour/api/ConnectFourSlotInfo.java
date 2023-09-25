package com.aineophyte.connectfour.api;

public class ConnectFourSlotInfo
{
	private int slot;
	private int evaluations;
	
	public int getSlot()
	{
		return slot;
	}
	
	public void setSlot(int slot)
	{
		this.slot = slot;
	}
	
	/**
	 * For an auto player, the number of static evaluations that
	 * were executed to determine the move into this slot.
	 * 
	 * @return number of evaluations
	 */
	public int getEvaluations()
	{
		return evaluations;
	}
	
	public void setEvaluations(int evaluations)
	{
		this.evaluations = evaluations;
	}		
}
