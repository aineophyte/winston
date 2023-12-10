package com.aineophyte.propagation.core;

/**
 * Base propagator that will currently handle content change events.
 * 
 * @author Scott Krasovec
 *
 * @param <T>
 */
public abstract class BasePropagator<T> extends BaseTypedPropertyChangeListener<T>
{
    protected abstract void handleContentPropertyChange(TypedPropertyChangeEvent<T> evt);
    
	@Override
	public void propertyChange(TypedPropertyChangeEvent<T> evt)
	{
		String propertyName = evt.getPropertyName();
		
		if ((propertyName != null) && propertyName.startsWith(Cell.CONTENT_PROPERTY_NAME)) {
			handleContentPropertyChange(evt);
		}
	}
}
