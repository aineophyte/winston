package com.aineophyte.propagation.core;

/**
 * Based on the p:* propagator from Software Design and Flexibility by Hanson and Sussman
 * and the <a href="https://github.com/namin/propagators/blob/master/doc/programmer-guide.rst">Programming with Propagators</a>
 * guide by Radul.
 * 
 * Computes the product of the input cells that are set.  The caller is free to set the content
 * of the Number input cells to a mix of integer and or float/double but the math with all be done as double.
 * 
 * @author Scott Krasovec
 */
public class ProductPropagator extends MultiNumberInputPropagator
{
	@SafeVarargs
	public ProductPropagator(Cell<Number> output, Cell<Number> ...cells)
	{
		super(output, cells);
	}


	@Override
	Number operation(Number x, Number y)
	{
		return x.doubleValue() * y.doubleValue();
	}
}
