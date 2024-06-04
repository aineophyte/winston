package com.aineophyte.propagation.examples.baseball;

enum HittingOutcome
{
	Out(false, true, true),
	Single(true, true, true),
	Double(true, true, true),
	Triple(true, true, true),
	Homerun(true, true, true),
	Walk(false, false, true),
	HitByPitch(false, false, true),
	SacrificeBunt(false, false, false),
	SacrificeFly(false, false, true),
	Strikeout(false, true, true),
	Error(false, true, true);
	
	private final boolean hit;
	private final boolean atBat;
	private final boolean plateAppearance;
	
	HittingOutcome(boolean hit, boolean atBat, boolean plateAppearance)
	{
		this.hit = hit;
		this.atBat = atBat;
		this.plateAppearance = plateAppearance;
	}
	
	boolean isAtBat()
	{
		return atBat;
	}
	
	boolean isPlateAppearance()
	{
		return plateAppearance;
	}
	
	boolean isHit()
	{
		return hit;
	}
}
