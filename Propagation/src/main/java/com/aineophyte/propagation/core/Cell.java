package com.aineophyte.propagation.core;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Based on Cells from Software Design and Flexibility by Hanson and Sussman
 * and the <a href="https://github.com/namin/propagators/blob/master/doc/programmer-guide.rst">Programming with Propagators</a>
 * guide by Radul.
 * 
 * This is bare bones at the moment with support for only setting and propagating content to experiment with some
 * simple math examples.  There has been no consideration for relations, neighbors and strongest.  It does check
 * for contradictions if enabled for the cell.
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
    private CellStates state;
    private boolean checkContradiction;
    
    private PropertyChangeSupport support;
    
    public Cell()
    {
    	support = new PropertyChangeSupport(this);
    	state = CellStates.NOTHING;
    }
    
    // Name is optional at the moment.  It will be part of the property name
    // when events are fired.
    public Cell<T> withName(String name)
    {
    	this.name = name;
    	return this;
    }
    
    public Cell<T> withCheckContradiction(boolean checkContradiction)
    {
    	this.checkContradiction = checkContradiction;
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
    	
    	if (state.isNothing()) {
    		this.content = content;
    		state = CellStates.SET;
    	} else if (state.isSet()) {
        	if ((oldValue == null) && (content == null)) {
        		return;
        	}
        	if (oldValue != null) {
        		// Not crazy about this.  Might be better to create a NumberCell
        		// class that extends Cell<Number> and make that the type used
        		// by the numeric propagators.
        		if ((oldValue instanceof Number) &&
        				(content instanceof Number)) {
        			if (((Number) oldValue).doubleValue() == ((Number) content).doubleValue()) {
        				return;
        			}
        				
        		} else if (oldValue.equals(content)) {
        			return;
        		}
        	}
        	this.content = merge(oldValue, content);
    	}
    	
    	if (state.isContradiction()) {
    		handleContradiction(oldValue, content);
    	}

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
    
    /**
     * Override this method, if you want the cell implementation
     * to deal with merging differing content values.  This is
     * where you would deal with merging a range and keeping track
     * of strongest.
     * 
     * @param previousValue
     * @param newValue
     * @return
     */
    protected T merge(T previousValue, T newValue)
    {
    	if (!checkContradiction) {
    		return newValue;
    	}
    	
    	state = CellStates.CONTRADICTION;
    	return previousValue;
    }
    
    /**
     * When contradictions are enabled and merge() hasn't been
     * overridden, this will throw a default exception when
     * dealing with contradicting values.  Override if you want a
     * different behavior.
     * 
     * @param oldValue
     * @param newValue
     */
    protected void handleContradiction(T oldValue, T newValue)
    {
    	throw new CellContradictionException(String.format("Default handler detected contradiction oldValue: %s newValue: %s",
    			oldValue, newValue));
    }
}
