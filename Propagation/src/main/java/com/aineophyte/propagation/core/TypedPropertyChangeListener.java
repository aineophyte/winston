package com.aineophyte.propagation.core;

import java.beans.PropertyChangeListener;

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
public interface TypedPropertyChangeListener<T> extends PropertyChangeListener
{
	void propertyChange(TypedPropertyChangeEvent<T> evt);
}
