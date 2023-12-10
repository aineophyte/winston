package com.aineophyte.propagation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ConstantTest
{
	@Test
	public void testStringConstant()
	{
		Constant<String> hello = new Constant<>("Hello");
		assertEquals("Hello", hello.getContent(), "Incorrect content");
		assertThrows(IllegalArgumentException.class, () -> hello.setContent("Good bye"),
				"hello should be immutable");
	}
	
	@Test
	public void testNullStringConstant()
	{
		Constant<String> null_constant = new Constant<>(null);
		assertNull(null_constant.getContent(), "Incorrect content");
	}
	
	@Test
	public void testNullNumberConstant()
	{
		assertThrows(IllegalArgumentException.class, () -> new NumberConstant(null),
				"a null number constant should not work");
	}
	
	@Test
	public void testNumberConstant()
	{
		NumberConstant two = new NumberConstant(2);
		assertEquals(2, two.getContent(), "Incorrect content");		
		assertThrows(IllegalArgumentException.class, () -> two.setContent(3),
				"two should be immutable");
	}
}
