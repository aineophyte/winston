package com.aineophyte.propagation.core;

/**
 * Based on the p:/ propagator from Software Design and Flexibility by Hanson and Sussman
 * and the <a href="https://github.com/namin/propagators/blob/master/doc/programmer-guide.rst">Programming with Propagators</a>
 * guide by Radul.
 * 
 * Computes the quotient of the two input cells that are set.  The caller is free to set the content
 * of the Number input cells to a mix of integer and or float/double but the math with all be done as double.
 * 
 * @author Scott Krasovec
 */
public class QuotientPropagator extends BasePropagator<Number>
{
	Cell<Number> output;
	Cell<Number> numerator;
	Cell<Number> denominator;
	
	public QuotientPropagator(Cell<Number> output, Cell<Number> numerator, Cell<Number> denominator)
	{
    	this.output = output;
    	this.numerator = numerator;
    	this.denominator = denominator;
    	
		numerator.addPropertyChangeListener(this);
		denominator.addPropertyChangeListener(this);
		
    	// TODO should we do this or should we assume that there will be at least one
    	// input that isn't a constant and the output is only relevant if at least one
    	// property change event is handled?
		// handleContentPropertyChange(null);
	}

	@Override
	protected void handleContentPropertyChange(TypedPropertyChangeEvent<Number> evt)
	{
		Number result = null;
		
		Number denominatorContent = denominator.getContent();
		
		// The result will be based on the input cells that are set.
		if (denominatorContent == null) {
			result = numerator.getContent();
		} else {
		    Number numeratorContent = numerator.getContent();
		    if (numeratorContent == null) {
		    	// if only the denominator is set, return it's
		    	// reciprocal
		    	result = 1 / denominatorContent.doubleValue();
		    } else {
		    	result = numeratorContent.doubleValue() / denominatorContent.doubleValue();
		    }
		}
		
		output.setContent(result);
	}
}
