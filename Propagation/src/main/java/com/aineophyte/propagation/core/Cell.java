package com.aineophyte.propagation.core;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Based on Cells from Software Design and Flexibility by Hanson and Sussman
 * and the <a href="https://github.com/namin/propagators/blob/master/doc/programmer-guide.rst">Programming with Propagators</a>
 * guide by Radul.
 * 
 * This is bare bones at the moment with support for only setting and propagating content to experiment with some
 * simple math examples.  There has been no consideration for relations, neighbors, constraints and strongest.
 * 
 * @author Scott Krasovec
 *
 * @param <T>
 */
public class Cell<T>
{
	static final String CONTENT_PROPERTY_NAME = "content";
	
    protected T content;
    private String name;
    
    private PropertyChangeSupport support;
    
    public Cell()
    {
    	support = new PropertyChangeSupport(this);
    }
    
    // Name is optional at the moment.  It will be part of the property name
    // when events are fired.
    public Cell<T> withName(String name)
    {
    	this.name = name;
    	return this;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public T getContent()
    {
    	return content;
    }
    
    public void setContent(T content)
    {
    	T oldValue = this.content;
    	this.content = content;
        support.firePropertyChange(new TypedPropertyChangeEvent<>(this, CONTENT_PROPERTY_NAME + "_" + name, oldValue, content));
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl)
    {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl)
    {
        support.removePropertyChangeListener(pcl);
    }
}
