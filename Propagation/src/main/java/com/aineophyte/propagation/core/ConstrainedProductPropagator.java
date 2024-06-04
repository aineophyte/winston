package com.aineophyte.propagation.core;

/**
 * Based on the c:* propagator from Software Design and Flexibility by Hanson and Sussman
 * and the <a href="https://github.com/namin/propagators/blob/master/doc/programmer-guide.rst">Programming with Propagators</a>
 * guide by Radul.
 * 
 * Computes the product of the 2 number input cells that are set but with constraints such that
 * the product also acts as an input and as long as 2 of the 3 parameters are set, the other value
 * will be computed.  The caller is free to set the content of the Number input cells to a mix of
 * integer and or float/double but the math with all be done as double.
 * 
 * @author Scott Krasovec
 */
public class ConstrainedProductPropagator
{
	public ConstrainedProductPropagator(Cell<Number> product, Cell<Number> number1, Cell<Number> number2)
	{
		new ProductPropagator(product, number1, number2).withRequireAllInputs(true);
		new QuotientPropagator(number2, product, number1).withRequireAllInputs(true);
		new QuotientPropagator(number1, product, number2).withRequireAllInputs(true);
	}
}
