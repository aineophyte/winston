package com.aineophyte.propagation.examples.baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Lineup implements BaseballStatsHolder
{
	String teamName;
	BaseballStats gameStats;
	List<Player> current;
	Map<String, Player> removed;
	
	Lineup(String teamName)
	{
		this.teamName = teamName;
		this.gameStats = new BaseballStats();
	}
	
	Player get(int lineupSpot, String lastName)
	{
		if (current == null)
		{
			// Could do this in the constructor.
			current = new ArrayList<>();
			return add(0, lastName);
		}
		
		int listIndex = lineupSpot - 1;
				
		Player player = (listIndex < current.size()) ? current.get(listIndex) : null;
		
		if (player != null) {
			if (player.getLastName().equals(lastName)) {
				return player;
			}

			if (removed == null) {
				removed = new HashMap<>();
			}
			current.remove(listIndex);
			removed.put(player.getLastName(), player);			
		}
		
        return add(listIndex, lastName);
	}
	
	private Player add(int listIndex, String lastName)
	{
		Player player = new Player(lastName).withParent(this);
		current.add(listIndex, player);
		return player;
	}
	
	public BaseballStats getStats()
	{
		return gameStats;
	}
	
	String getTeamName()
	{
		return teamName;
	}
}
