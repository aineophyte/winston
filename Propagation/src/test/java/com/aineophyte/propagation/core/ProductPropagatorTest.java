package com.aineophyte.propagation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductPropagatorTest
{
	@Test
	public void testProductPropagator()
	{
		Cell<Number> cell1 = new Cell<>();
		Cell<Number> cell2 = new Cell<>();
		Cell<Number> cell3 = new Cell<>();
		Cell<Number> product = new Cell<>();
		
		new ProductPropagator(
				product, cell1, cell2, cell3);
		cell1.setContent(5.0);
		assertEquals(5.0, product.getContent(), "Wrong product");
		cell2.setContent(7.0);
		assertEquals(35.0, product.getContent(), "Wrong product");
		cell2.setContent(9.0);
		assertEquals(45.0, product.getContent(), "Wrong product");
		cell1.setContent(-3.0);
		assertEquals(-27.0, product.getContent(), "Wrong product");
		cell3.setContent(-9.0);
		assertEquals(243.0, product.getContent(), "Wrong product");
	}
}
