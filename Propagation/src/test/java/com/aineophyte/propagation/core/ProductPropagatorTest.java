package com.aineophyte.propagation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProductPropagatorTest
{
	@Test
	public void testProductPropagator()
	{
		Cell<Number> cell1 = new Cell<Number>().withCheckContradiction(true);
		Cell<Number> cell2 = new Cell<Number>().withCheckContradiction(true);
		Cell<Number> cell3 = new Cell<Number>().withCheckContradiction(true);
		Cell<Number> product = new Cell<>();
		
		new ProductPropagator(
				product, cell1, cell2, cell3);
		cell1.setContent(5.0);
		assertEquals(5.0, product.getContent(), "Wrong product");
		cell2.setContent(7.0);
		assertEquals(35.0, product.getContent(), "Wrong product");
		assertThrows(CellContradictionException.class, () -> cell2.setContent(9),
				"cell2 content already set");
		assertEquals(35.0, product.getContent(), "Wrong product");
		assertThrows(CellContradictionException.class, () -> cell1.setContent(-3.0),
				"cell3 content already set");
		assertEquals(35.0, product.getContent(), "Wrong product");
		cell3.setContent(-9.0);
		assertEquals(-315.0, product.getContent(), "Wrong product");
	}
}
