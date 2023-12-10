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
public abstract class BaseTypedPropertyChangeListener<T> implements TypedPropertyChangeListener<T>
{
	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		 propertyChange(getGenericPropertyChangeEvent(evt));		
	}
	
	@SuppressWarnings("unchecked")
	private TypedPropertyChangeEvent<T> getGenericPropertyChangeEvent(PropertyChangeEvent evt)
	{
        if (evt instanceof TypedPropertyChangeEvent)
        {
        	return (TypedPropertyChangeEvent<T>) evt;
        }
        
        return new TypedPropertyChangeEvent<T>(evt);
    }
}
