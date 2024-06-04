/**
 * 
 */
package com.aineophyte.propagation.examples.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author krasr
 *
 */
public class BoxScoreTest

{
	@Test
	public void testLineup()
	{
		// First time thru the lineup.
		// First inning.
		Lineup lineup = new Lineup("Team One");
		Player jeter = lineup.get(1, "Jeter");
		jeter.add(HittingOutcome.Single);
		Player williams = lineup.get(2, "Williams");
		williams.add(HittingOutcome.Out);
		Player mays = lineup.get(3, "Mays");
		mays.add(HittingOutcome.Homerun);
		Player ruth = lineup.get(4, "Ruth");
		ruth.add(HittingOutcome.Walk);
		Player schmidt = lineup.get(5, "Schmidt");
		schmidt.add(HittingOutcome.Out);
		Player yaz = lineup.get(6, "Yaz");
		yaz.add(HittingOutcome.Strikeout);
		// Second inning.
		Player bench = lineup.get(7, "Bench");
		bench.add(HittingOutcome.Out);
		Player evans = lineup.get(8, "Evans");
		evans.add(HittingOutcome.Walk);
		Player morgan = lineup.get(9, "Morgan");
		morgan.add(HittingOutcome.Out);
		// Second time thru the lineup
		// Use get again to check behavior.  A real
		// application would probably be interactively
		// starting over each inning from a lineup
		// object read in from current game data
		// from a data store.
		jeter = lineup.get(1, "Jeter");
		jeter.add(HittingOutcome.Strikeout);
		// Third inning.
		williams = lineup.get(2, "Williams");
		williams.add(HittingOutcome.Double);
		mays = lineup.get(3, "Mays");
		mays.add(HittingOutcome.Single);
		ruth = lineup.get(4, "Ruth");
		ruth.add(HittingOutcome.Homerun);
		schmidt = lineup.get(5, "Schmidt");
		schmidt.add(HittingOutcome.Strikeout);
		// Jackson pinch hitting for Yaz.
		Player jackson = lineup.get(6, "Jackson");
		jackson.add(HittingOutcome.Strikeout);
		bench = lineup.get(7, "Bench");
		bench.add(HittingOutcome.Triple);
		evans = lineup.get(8, "Evans");
		evans.add(HittingOutcome.Out);
		
		verifyAverage(0.5, jeter);
		verifyOnBasePercentage(0.5, jeter);
		verifySlugging(0.5, jeter);
		verifyOps(1.0, jeter);

		verifyAverage(0.5, williams);
		verifyOnBasePercentage(0.5, williams);
		verifySlugging(1.0, williams);
		verifyOps(1.5, williams);

		verifyAverage(1.0, mays);
		verifyOnBasePercentage(1.0, mays);
		verifySlugging(2.5, mays);
		verifyOps(3.5, mays);
		
		verifyAverage(1.0, ruth);
		verifyOnBasePercentage(1.0, ruth);
		verifySlugging(4.0, ruth);
		verifyOps(5.0, ruth);
		
		verifyAverage(0.0, schmidt);
		verifyOnBasePercentage(0.0, schmidt);
		verifySlugging(0.0, schmidt);
		verifyOps(0.0, schmidt);
		
		verifyAverage(0.0, yaz);
		verifyOnBasePercentage(0.0, yaz);
		verifySlugging(0.0, yaz);
		verifyOps(0.0, yaz);
		
		verifyAverage(0.0, jackson);
		verifyOnBasePercentage(0.0, jackson);
		verifySlugging(0.0, jackson);
		verifyOps(0.0, jackson);
		
		verifyAverage(0.5, bench);
		verifyOnBasePercentage(0.5, bench);
		verifySlugging(1.5, bench);
		verifyOps(2.0, bench);
		
		verifyAverage(0.0, evans);
		verifyOnBasePercentage(0.5, evans);
		verifySlugging(0.0, evans);
		verifyOps(0.5, evans);
		
		verifyAverage(0.0, morgan);
		verifyOnBasePercentage(0.0, morgan);
		verifySlugging(0.0, morgan);
		verifyOps(0.0, morgan);
		
		assertEquals(6.0/15.0, lineup.getStats().getAverage().getContent().doubleValue(), 0.0001,
				"Wrong average for " + lineup.getTeamName());
		
		assertEquals(8.0/17.0, lineup.getStats().getOnBasePercentage().getContent().doubleValue(), 0.0001,
				"Wrong on base percentage for " + lineup.getTeamName());
		
		assertEquals(15.0/15.0, lineup.getStats().getSlugging().getContent().doubleValue(), 0.0001,
				"Wrong slugging for " + lineup.getTeamName());
		
		assertEquals(8.0/17.0 + 15.0/15.0, lineup.getStats().getOps().getContent().doubleValue(), 0.0001,
				"Wrong ops for " + lineup.getTeamName());
	}
	
	private void verifyAverage(double expected, Player player)
	{
		assertEquals(expected, player.getStats().getAverage().getContent().doubleValue(), 0.0001,
				"Wrong average for " + player.getLastName());		
	}
	
	private void verifyOnBasePercentage(double expected, Player player)
	{
		assertEquals(expected, player.getStats().getOnBasePercentage().getContent().doubleValue(), 0.0001,
				"Wrong on base percentage for " + player.getLastName());		
	}
	
	private void verifySlugging(double expected, Player player)
	{
		assertEquals(expected, player.getStats().getSlugging().getContent().doubleValue(), 0.0001,
				"Wrong slugging for " + player.getLastName());		
	}
	
	private void verifyOps(double expected, Player player)
	{
		assertEquals(expected, player.getStats().getOps().getContent().doubleValue(), 0.0001,
				"Wrong ops for " + player.getLastName());		
	}
}

