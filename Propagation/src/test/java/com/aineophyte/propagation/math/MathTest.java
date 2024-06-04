package com.aineophyte.propagation.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.aineophyte.propagation.core.Cell;
import com.aineophyte.propagation.core.CellContradictionException;
import com.aineophyte.propagation.core.ConstrainedProductPropagator;
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
		Cell<Number> input = new Cell<Number>().withCheckContradiction(true);
		Cell<Number> squareRoot = new Cell<>();
		new SquareRootPropagator(squareRoot, input);
		
		Cell<Number> product = new Cell<Number>().withCheckContradiction(true);
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
		Cell<Number> input1 = new Cell<Number>().withCheckContradiction(true);
		Cell<Number> input2 = new Cell<Number>().withCheckContradiction(true);
		Cell<Number> input3 = new Cell<Number>().withCheckContradiction(true);
		
		Cell<Number> sum = new Cell<>();
		SumPropagator sumPropagator = new SumPropagator(sum, input1, input2, input3);
		
		Cell<Number> avg = new Cell<>();
		new QuotientPropagator(avg, sum, new NumberConstant(sumPropagator.getInputCount()));
		
		input1.setContent(11);
		input2.setContent(12);
		input3.setContent(13);
		
		assertEquals(12.0, avg.getContent().doubleValue(), 0.000000000000001, "Incorrect average");
		
		assertThrows(CellContradictionException.class, () -> input1.setContent(null),
				"cell content already set");
		
		assertEquals(12.0, avg.getContent().doubleValue(), 0.000000000000001, "Incorrect average");
	}
	
	@Test
	public void testConstrainedProduct()
	{
		Cell<Number> x = new Cell<Number>().withCheckContradiction(true);
		Cell<Number> y = new Cell<Number>().withCheckContradiction(true);
		Cell<Number> product = new Cell<Number>().withCheckContradiction(true);
		
		new ConstrainedProductPropagator(product, x, y);
		
		y.setContent(10);
		assertNull(x.getContent(), "x should be null");
		assertEquals(10.0, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertNull(product.getContent(), "product should be null");
		
		product.setContent(30);
		assertEquals(3.0, x.getContent().doubleValue(), 0.0001, "Incorrect x");
		assertEquals(10.0, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertEquals(30.0, product.getContent().doubleValue(), 0.0001, "Incorrect product");		
		
		assertThrows(CellContradictionException.class, () -> x.setContent(4),
				"cell content already set");
		
		assertThrows(CellContradictionException.class, () -> y.setContent(20),
				"cell content already set");
		
		assertThrows(CellContradictionException.class, () -> product.setContent(100),
				"cell content already set");
	}
	
	@Test
	public void testConstrainedProductAllowContradictions()
	{
		Cell<Number> x = new Cell<>();
		Cell<Number> y = new Cell<>();
		Cell<Number> product = new Cell<>();
		
		new ConstrainedProductPropagator(product, x, y);
		
		y.setContent(10);
		assertNull(x.getContent(), "x should be null");
		assertEquals(10.0, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertNull(product.getContent(), "product should be null");
		
		product.setContent(30);
		assertEquals(3.0, x.getContent().doubleValue(), 0.0001, "Incorrect x");
		assertEquals(10.0, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertEquals(30.0, product.getContent().doubleValue(), 0.0001, "Incorrect product");		
		
		x.setContent(4);		
		assertEquals(4.0, x.getContent().doubleValue(), 0.0001, "Incorrect x");
		assertEquals(10.0, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertEquals(40.0, product.getContent().doubleValue(), 0.0001, "Incorrect product");
		
		y.setContent(20);				
		assertEquals(4.0, x.getContent().doubleValue(), 0.0001, "Incorrect x");
		assertEquals(20.0, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertEquals(80.0, product.getContent().doubleValue(), 0.0001, "Incorrect product");
		
		x.setContent(10);		
		assertEquals(10.0, x.getContent().doubleValue(), 0.0001, "Incorrect x");
		assertEquals(20.0, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertEquals(200.0, product.getContent().doubleValue(), 0.0001, "Incorrect product");
		
		product.setContent(100);
		assertEquals(10.0, x.getContent().doubleValue(), 0.0001, "Incorrect x");
		assertEquals(10.0, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertEquals(100.0, product.getContent().doubleValue(), 0.0001, "Incorrect product");
		
		product.setContent(225);
		assertEquals(10.0, x.getContent().doubleValue(), 0.0001, "Incorrect x");
		assertEquals(22.5, y.getContent().doubleValue(), 0.0001, "Incorrect y");
		assertEquals(225.0, product.getContent().doubleValue(), 0.0001, "Incorrect product");
	}
}
