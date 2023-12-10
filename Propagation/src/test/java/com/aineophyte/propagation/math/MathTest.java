package com.aineophyte.propagation.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.aineophyte.propagation.core.Cell;
import com.aineophyte.propagation.core.NumberConstant;
import com.aineophyte.propagation.core.ProductPropagator;
import com.aineophyte.propagation.core.QuotientPropagator;
import com.aineophyte.propagation.core.SumPropagator;

public class MathTest
{
	@Test
	public void testSquareRoot()
	{
		Cell<Number> input = new Cell<>();
		Cell<Number> squareRoot = new Cell<>();
		new SquareRootPropagator(squareRoot, input);
		
		input.setContent(2);
        assertEquals(Math.sqrt(2), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of 2");
        
		input.setContent(8);
        assertEquals(Math.sqrt(8), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of 8");
        
		input.setContent(507);
        assertEquals(Math.sqrt(507), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of 507");
        
        input.setContent(4571620);
        assertEquals(Math.sqrt(4571620), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of 4571620");
        
        input.setContent(0);
        assertEquals(Math.sqrt(0), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of 0");

        input.setContent(-0);
        assertEquals(Math.sqrt(-0), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of -0");

        input.setContent(Double.NaN);
        assertEquals(Math.sqrt(Double.NaN), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of NaN");

        input.setContent(Double.POSITIVE_INFINITY);
        assertEquals(Math.sqrt(Double.POSITIVE_INFINITY), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of positive infinity");

        input.setContent(-774);
        assertEquals(Math.sqrt(-774), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of -774");
        
        input.setContent(1E+4);
        assertEquals(Math.sqrt(10000), squareRoot.getContent().doubleValue(), 0.000000000000001, "Incorrect square root of 1E+4");

	}
	
	@Test
	public void testMultiFunction()
	{
		// X * sqrt(X) / Y
		Cell<Number> input = new Cell<>();
		Cell<Number> squareRoot = new Cell<>();
		new SquareRootPropagator(squareRoot, input);
		
		Cell<Number> product = new Cell<>();
		new ProductPropagator(product, input, squareRoot);
		
		Cell<Number> result = new Cell<>();
		Cell<Number> divisor = new Cell<>();
		
		new QuotientPropagator(result, product, divisor);
		
		input.setContent(7);
		divisor.setContent(15);
		
		assertEquals(7*Math.sqrt(7)/15, result.getContent().doubleValue(), 0.000000000000001, "Incorrect result");
	}
	
	@Test
	public void testAverage()
	{
		Cell<Number> input1 = new Cell<>();
		Cell<Number> input2 = new Cell<>();
		Cell<Number> input3 = new Cell<>();
		
		Cell<Number> sum = new Cell<>();
		SumPropagator sumPropagator = new SumPropagator(sum, input1, input2, input3);
		
		Cell<Number> avg = new Cell<>();
		new QuotientPropagator(avg, sum, new NumberConstant(sumPropagator.getInputCount()));
		
		input1.setContent(11);
		input2.setContent(12);
		input3.setContent(13);
		
		assertEquals(12.0, avg.getContent().doubleValue(), 0.000000000000001, "Incorrect average");
		
		input1.setContent(null);
		assertEquals(25.0/3, avg.getContent().doubleValue(), 0.000000000000001, "Incorrect average");
	}
}
