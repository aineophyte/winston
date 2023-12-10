package com.aineophyte.propagation.core;

import java.beans.PropertyChangeEvent;

/**
 * Get around the fact that the java property change framework is older
 * than generic type support.
 * 
 * Based on Garret Wilson's code from 2007 found on developer.com
 * 
 * @see <a href="https://www.developer.com/author/garret-wilson/">Garret Wilson</a>
 *
 * @author Scott Krasovec
 * 
 * @param <T>
 */
public class TypedPropertyChangeEvent<T> extends PropertyChangeEvent
{
	private static final long serialVersionUID = 20231118L;

	public TypedPropertyChangeEvent(Object source, String propertyName, T oldValue, T newValue) {
		super(source, propertyName, oldValue, newValue);
	}
	
	@SuppressWarnings("unchecked")
	public TypedPropertyChangeEvent(final PropertyChangeEvent evt)
	{
		super(evt.getSource(), evt.getPropertyName(), (T) evt.getOldValue(), (T) evt.getNewValue());
	}
	
	@SuppressWarnings("unchecked")
	public T getOldValue()
	{
		return (T) super.getOldValue();
	}
	
	@SuppressWarnings("unchecked")
	public T getNewValue()
	{
		return (T) super.getNewValue();
	}
}
