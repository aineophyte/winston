package com.skai.idtree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Rule
{
	private final Collection<Criteria> criterias = new ArrayList<>();
	private final String resultFeature;
	private String resultValue;
	
	public Rule(String resultFeature)
	{
		Objects.requireNonNull(resultFeature, "resultFeature required");
		this.resultFeature = resultFeature;
	}
	
	public Rule copy()
	{
		Rule copy = new Rule(this.resultFeature);
		for (Criteria criteria : this.criterias) {
			copy.add(criteria);
		}
		
		return copy;
	}
	
	public void setResultValue(String resultValue)
	{
		this.resultValue = resultValue;
	}
	
	public boolean isPositiveResult()
	{
		return "Y".equals(resultValue);
	}
	
	public Map<String,String> getTreeFeatures()
	{
		Map<String,String> treeFeatures = new HashMap<>();
		for (Criteria criteria : this.criterias) {
			treeFeatures.put(criteria.feature, criteria.value);
		}
		treeFeatures.put(resultFeature, resultValue);
		return treeFeatures;
	}
	
	public void addCriteria(String feature, String value)
	{
		Objects.requireNonNull(feature, "feature required");
		Objects.requireNonNull(value, "value required");
		criterias.add(new Criteria(feature, value));
	}
	
	private void add(Criteria criteria)
	{
		criterias.add(criteria);
	}
	
	public boolean equals(Object o)
	{
		if (o == null) {
			return false;
		}
		
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof Rule)) {
			return false;
		}
		
		Rule r = (Rule) o;
		
		if (!this.resultFeature.equals(r.resultFeature)) {
			return false;
		}
		
		if (this.resultValue != null) {
			if (!this.resultValue.equals(r.resultValue)) {
				return false;
			}
		} else if (r.resultValue != null) {
			return false;
		}
		
		if (this.criterias.size() != r.criterias.size()) {
			return false;
		}
		
		Iterator<Criteria> itr1 = this.criterias.iterator();
		Iterator<Criteria> itr2 = r.criterias.iterator();
		
		while (itr1.hasNext()) {
			Criteria c1 = itr1.next();
			Criteria c2 = itr2.next();
			if (!c1.feature.equals(c2.feature)) {
				return false;
			}
			
			if (!c1.value.equals(c2.value)) {
				return false;
			}
		}
		
		return true;	
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder("If ");
		int i = 0;
		for (Criteria criteria : criterias) {
			if (i > 0) {
				builder.append("and ");
			}
			builder.append(criteria.feature);
			builder.append(" is ");
			builder.append(criteria.value);
			builder.append("\n");
			i++;
		}
		
		builder.append("then ");
		builder.append(resultFeature);
		builder.append(" is ");
		builder.append(resultValue);
		builder.append("\n");
        return builder.toString();
	}

	private static class Criteria
	{
		private final String feature;
		private final String value;
		
		Criteria(String feature, String value)
		{
			this.feature = feature;
			this.value = value;
		}
	}
}
