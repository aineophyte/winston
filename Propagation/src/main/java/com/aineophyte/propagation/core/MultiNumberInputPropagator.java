package com.aineophyte.propagation.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Base class to handle Number operations where the output cell is a function on a series
 * of input cells like a sum or product.
 * 
 * @author Scott Krasovec
 */
abstract class MultiNumberInputPropagator extends BasePropagator<Number>
{
	Cell<Number> output;
	
	Collection<Cell<Number>> input;
	private boolean modified;
	
	abstract Number operation(Number x, Number y);
	
	@SafeVarargs
	public MultiNumberInputPropagator(Cell<Number> output, Cell<Number> ...cells)
	{
    	this.output = output;
    	int i = 0;
    	for (Cell<Number> c : cells) {
    		c.addPropertyChangeListener(this);
    		i++;
    	}
    	
    	if (i < 1) {
    		throw new IllegalArgumentException(this.getClass().getName() + " requires at least one input cell.");
    	}
    	
    	input = Arrays.asList(cells);
    	modified = false;
    	
    	// TODO should we do this or should we assume that there will be at least one
    	// input that isn't a constant and the output is only relevant if at least one
    	// property change event is handled?
		// handleContentPropertyChange(null);
	}

	@Override
	protected void handleContentPropertyChange(TypedPropertyChangeEvent<Number> evt)
	{
		Number result = null;
		
		// The result will be based on the input cells that are set unless
		// requireAllInputs is true.
		for (Cell<Number> c : input) {
			Number content = c.getContent();
			if (content == null) {
				if (requireAllInputs) {
					return;
				}
				continue;
			}
			
			if (result == null) {
				result = content;
			} else {
				result = operation(result, content);
			}
		}
		
		output.setContent(result);
	}
	
	public int getInputCount()
	{
		return input.size();
	}
	
	public void addInput(Cell<Number> newInput)
	{
		if (!modified) {
			input = new ArrayList<>(input);
		}
		
		newInput.addPropertyChangeListener(this);
		input.add(newInput);
	}
}
