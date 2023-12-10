package com.aineophyte.propagation.core;

public class NumberConstant extends Constant<Number>
{
    // null does not make sense for a numeric constant
	public NumberConstant(Number value)
	{
		super(value);
		if (value == null) {
		    throw new IllegalArgumentException("a number constant requires a non-null value");
		}
	}
}
