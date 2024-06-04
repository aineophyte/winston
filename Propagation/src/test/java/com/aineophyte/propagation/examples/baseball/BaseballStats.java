package com.aineophyte.propagation.examples.baseball;

import com.aineophyte.propagation.core.Cell;
import com.aineophyte.propagation.core.NumberConstant;
import com.aineophyte.propagation.core.ProductPropagator;
import com.aineophyte.propagation.core.QuotientPropagator;
import com.aineophyte.propagation.core.SumPropagator;

public class BaseballStats
{
	private static final NumberConstant BASES_PER_DOUBLE = new NumberConstant(2);
	private static final NumberConstant BASES_PER_TRIPLE = new NumberConstant(3);
	private static final NumberConstant BASES_PER_HOMERUN = new NumberConstant(4);
	
	// This would expand to breakdown of singles, doubles, etc.
	Cell<Number> atBats;
	Cell<Number> hits;
	Cell<Number> average;
	Cell<Number> singles;
	Cell<Number> doubles;
	Cell<Number> triples;
	Cell<Number> homeruns;
	Cell<Number> plateAppearances;
	Cell<Number> reachedBases;
	Cell<Number> walks;
	Cell<Number> hitByPitches;
	Cell<Number> sacrificeFlies;
	Cell<Number> onBasePercentage;
	Cell<Number> totalBases;
	Cell<Number> slugging;
	Cell<Number> ops;
	
	BaseballStats()
	{
		atBats = new Cell<>();
		hits = new Cell<>();
		average = new Cell<>();
		
		singles = new Cell<>();
		doubles = new Cell<>();
		triples = new Cell<>();
		homeruns = new Cell<>();
		
		new SumPropagator(hits, singles, doubles, triples, homeruns);
		
		plateAppearances = new Cell<>();
		reachedBases = new Cell<>();
		walks = new Cell<>();
		hitByPitches = new Cell<>();
		sacrificeFlies = new Cell<>();
		
		new SumPropagator(plateAppearances, atBats, walks, hitByPitches, sacrificeFlies);
		new SumPropagator(reachedBases, hits, walks, hitByPitches);
		
		onBasePercentage = new Cell<>();
		
		totalBases = new Cell<>();
		slugging = new Cell<>();
		Cell<Number> doubleBases = new Cell<>();
		new ProductPropagator(doubleBases, BASES_PER_DOUBLE, doubles);
		Cell<Number> tripleBases = new Cell<>();
		new ProductPropagator(tripleBases, BASES_PER_TRIPLE, triples);
		Cell<Number> homerunBases = new Cell<>();
		new ProductPropagator(homerunBases, BASES_PER_HOMERUN, homeruns);
		new SumPropagator(totalBases, singles, doubleBases, tripleBases, homerunBases);
		new QuotientPropagator(average, hits, atBats);
		new QuotientPropagator(onBasePercentage, reachedBases, plateAppearances);
		new QuotientPropagator(slugging, totalBases, atBats);
		ops = new Cell<>();
		new SumPropagator(ops, onBasePercentage, slugging);
		// Initialize hits to 0 so we'll get a 0 average to start.
		singles.setContent(0);
	}
	
	void add(HittingOutcome outcome)
	{
		if (outcome.isAtBat())
		{
			increment(atBats);
			
			if (outcome.isHit())
			{
				if (outcome == HittingOutcome.Single) {
					increment(singles);
				} else if (outcome == HittingOutcome.Double) {
					increment(doubles);
				} else if (outcome == HittingOutcome.Triple) {
					increment(triples);
				} else {
					increment(homeruns);
				}
			}
		} else if (outcome.isPlateAppearance()) {
			if (outcome == HittingOutcome.Walk) {
				increment(walks);
			} else if (outcome == HittingOutcome.HitByPitch) {
				increment(hitByPitches);
			} else {
				increment(sacrificeFlies);
			}
		}
	}
	
	void increment(Cell<Number> stat)
	{
		Number current = stat.getContent();
		if (current == null) {
			stat.setContent(1);
		} else {
			stat.setContent(current.intValue() + 1);
		}
	}
	
	Cell<Number> getAtBats()
	{
		return atBats;
	}
	
	Cell<Number> getHits()
	{
		return hits;
	}
	
	Cell<Number> getTotalBases()
	{
		return totalBases;
	}
	
	Cell<Number> getAverage()
	{
		return average;
	}
	
	Cell<Number> getOnBasePercentage()
	{
		return onBasePercentage;
	}
	
	Cell<Number> getSlugging()
	{
		return slugging;
	}
	
	Cell<Number> getOps()
	{
		return ops;
	}
}
