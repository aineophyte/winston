package com.aineophyte.propagation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SumPropagatorTest
{
	@Test
	public void testSumPropagator()
	{
		Cell<Number> cell1 = new Cell<>();
		Cell<Number> cell2 = new Cell<>();
		Cell<Number> cell3 = new Cell<>();
		Cell<Number> sum = new Cell<>();
		
		new SumPropagator(sum, cell1, cell2, cell3);
		cell1.setContent(5);
		assertEquals(5.0, sum.getContent().doubleValue(), 0.01, "Wrong sum");
		assertEquals(5, sum.getContent().intValue(), "Wrong sum");
		cell2.setContent(7.5);
		assertEquals(12.5, sum.getContent().doubleValue(), 0.01, "Wrong sum");
		assertEquals(12, sum.getContent().intValue(), "Wrong sum");
		cell2.setContent(9);
		assertEquals(14.0, sum.getContent().doubleValue(), 0.01, "Wrong sum");
		cell1.setContent(-3.6);
		assertEquals(5.4, sum.getContent().doubleValue(), 0.01, "Wrong sum");
		cell3.setContent(-9);
		assertEquals(-3.6, sum.getContent().doubleValue(), 0.01, "Wrong sum");
		assertEquals(-3, sum.getContent().intValue(), "Wrong sum");
	}
}
