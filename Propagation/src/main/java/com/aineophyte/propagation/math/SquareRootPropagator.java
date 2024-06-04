package com.aineophyte.propagation.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aineophyte.propagation.core.BasePropagator;
import com.aineophyte.propagation.core.Cell;
import com.aineophyte.propagation.core.NumberConstant;
import com.aineophyte.propagation.core.QuotientPropagator;
import com.aineophyte.propagation.core.SumPropagator;
import com.aineophyte.propagation.core.TypedPropertyChangeEvent;

public class SquareRootPropagator extends BasePropagator<Number>
{
	Cell<Number> squareRoot;
	Cell<Number> input;
	
	public SquareRootPropagator(Cell<Number> squareRoot, Cell<Number> input)
	{
    	this.squareRoot = squareRoot;
    	this.input = input;
    	
		input.addPropertyChangeListener(this);
	}
	
	@Override
	protected void handleContentPropertyChange(TypedPropertyChangeEvent<Number> evt)
	{
		Number result = (input.getContent() != null) ?
				HeronStepPropagator.squareRoot(input.getContent().doubleValue()) : null;
		
		squareRoot.setContent(result);
	}
	
	private static class HeronStepPropagator
	{
		private static final Logger logger = LoggerFactory.getLogger(HeronStepPropagator.class);
		
	    private HeronStepPropagator(Cell<Number> x, Cell<Number> guess, Cell<Number> betterGuess)
	    {
			Cell<Number> xDivG = new Cell<Number>().withName("xDivG");
			Cell<Number> gPlusXDivG = new Cell<Number>().withName("gPlusXDivG");
			NumberConstant two = new NumberConstant(2);
			new QuotientPropagator(xDivG, x, guess);
			new SumPropagator(gPlusXDivG, guess, xDivG);
			new QuotientPropagator(betterGuess, gPlusXDivG, two);
	    }
	    
	    static double squareRoot(double n)
	    {
	    	double answer;
	    	
	    	if (n == 0.0) {
	    		answer = n;
	    	} else if (n < 0.0) {
	    		answer = Double.NaN;
	    	} else {
	    		answer = 0;
	    		
	    		Cell<Number> x = new Cell<Number>().withName("x").withCheckContradiction(true);
	    		Cell<Number> guess = new Cell<Number>().withName("guess");
	    		Cell<Number> betterGuess = new Cell<Number>().withName("betterGuess");
	    		new HeronStepPropagator(x, guess, betterGuess);

	    		double currentGuess = 1;
	            boolean done = false;
	    		while (!done) {
	    			x.setContent(n);
	    		    guess.setContent(currentGuess);
	    		    answer = betterGuess.getContent().doubleValue();
	    		    if (Double.isNaN(answer) || Double.isInfinite(answer) ||
	    		    		Math.abs(answer - currentGuess) < 0.000000000000001) {
	    		    	done = true;
	    		    } else {
	    		    	currentGuess = answer;
	    		    	if (logger.isDebugEnabled()) {
	    		    	    logger.debug("better guess " + answer);
	    		    	}
	    		    }
	    		}
	    	} 	

	    	if (logger.isDebugEnabled()) {
	    	    logger.debug("answer " + answer);
	    	}
			return answer;
	    }
	}
}
