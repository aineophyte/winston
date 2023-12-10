package com.aineophyte.propagation.core;

/**
 * Immutable subclass of Cell to represent a constant value.
 * 
 * @author Scott Krasovec
 *
 * @param <T>
 */
public class Constant<T> extends Cell<T>
{
	// Allowing null as the content for the base class
	public Constant(T value)
	{
		super();
		this.content = value;
	}
	
	@Override
	public void setContent(T content)
	{
		throw new IllegalArgumentException(String.format("constant object with value %s is immutable", content));
	}
}
