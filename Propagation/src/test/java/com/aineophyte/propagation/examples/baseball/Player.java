package com.aineophyte.propagation.examples.baseball;

import java.util.Optional;

class Player implements BaseballStatsHolder
{
	// For the test example, this a last name, obviously we'd need more
	// for a real implementation.
	String lastName;
	// For a real implementation, we'd probably have a season stats and
	// game stats member variable.
	BaseballStats gameStats;
	
	Optional<BaseballStatsHolder> parent = Optional.empty();
	
	Player(String lastName)
	{
		this.lastName = lastName;
		gameStats = new BaseballStats();
	}
	
	Player withParent(BaseballStatsHolder parent)
	{
		this.parent = Optional.ofNullable(parent);
		return this;
	}
	
	void add(HittingOutcome outcome)
	{
		gameStats.add(outcome);
		if (parent.isPresent()) {
		    parent.get().getStats().add(outcome);
		}
	}
	
	public BaseballStats getStats()
	{
		return gameStats;
	}
	
	String getLastName()
	{
		return lastName;
	}
}
