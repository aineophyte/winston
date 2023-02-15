package com.skai.idtree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Testing update to GitHub on 2/15/2023
 * 
 * @author Scott Krasovec
 *
 */
public class FeatureTest
{
	private final String feature;
	private final SortedMap<String, FeatureResultCount> featureResults = new TreeMap<>();
	private final SortedMap<String, Map<Long, String>> entitiesInDoubt = new TreeMap<>();
	private double avgDisorder;
	private String parentFeature;
	private String parentFeatureValue;
	
	public FeatureTest(String feature, Map<Long, String> featureMap, Map<Long, String> entitiesForTest)
	{
		this.feature = feature;
		init(featureMap, entitiesForTest);
	}
	
	private void init(Map<Long, String> featureMap, Map<Long, String> entitiesForTest)
	{
		for (Entry<Long, String> entry : featureMap.entrySet()) {
			String result = entitiesForTest.get(entry.getKey());
			if (result == null) {
				// Could be null after the first pass of the caller
				// since we are only working on a subset of the entities.
				continue;
			}
			FeatureResultCount resultCount = featureResults.get(entry.getValue());
			if (resultCount == null) {
				resultCount = new FeatureResultCount();
				featureResults.put(entry.getValue(), resultCount);
			}
			
			resultCount.incrementCount(result);
		}
		
		for (Entry<Long, String> entry : featureMap.entrySet()) {
			FeatureResultCount current = featureResults.get(entry.getValue());
			if (current == null) {
				// Could be null after the first pass of the caller
				// since we are only working on a subset of the entities.
				continue;
			}
			if (!current.isHomogeneous()) {
				Long entityId = entry.getKey();
				String result = entitiesForTest.get(entityId);
				if (result == null) {
					// Could be null after the first pass of the caller
					// since we are only working on a subset of the entities.
					continue;
				}
				Map<Long, String> doubt = entitiesInDoubt.get(entry.getValue());
				if (doubt == null) {
					doubt = new HashMap<>();
					entitiesInDoubt.put(entry.getValue(), doubt);
				}
				doubt.put(entityId, result);
			}
		}
		
		int totalSamples = entitiesForTest.size();
		for (FeatureResultCount resultCount : featureResults.values()) {
            avgDisorder += resultCount.getAverageDisorder(totalSamples);
		}
	}
	
	public void setParentFeature(String parentFeature)
	{
		this.parentFeature = parentFeature;
	}
	
	public String getParentFeatureValue()
	{
		return parentFeatureValue;
	}
	
	public void setParentFeatureValue(String parentFeatureValue)
	{
		this.parentFeatureValue = parentFeatureValue;
	}
	
	public String getFeature()
	{
		return feature;
	}
	
	public SortedMap<String, FeatureResultCount> getFeatureResults()
	{
		return featureResults;
	}
	
	public SortedMap<String, Map<Long,String>> getEntitiesInDoubt()
	{
		return entitiesInDoubt;
	}
	
	public double getAverageDisorder()
	{
		return avgDisorder;
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder("Feature: ");
		builder.append(feature);
		builder.append(", disorder: ");
		builder.append(avgDisorder);
		builder.append(", results: ");
		builder.append(featureResults);
		builder.append(", doubt: ");
		builder.append(entitiesInDoubt);
		if (parentFeature != null) {
			builder.append(", parent feature: ");
			builder.append(parentFeature);
			builder.append(" = ");
			builder.append(parentFeatureValue);
		}
		return builder.toString();
	}
	
	static class FeatureResultCount
	{
		private int yesCount;
		private int noCount;
		
		void incrementCount(String value)
		{
			if ("Y".equals(value)) {
			    yesCount++;
			} else {
				noCount++;
			}
		}
		
		int getYesCount()
		{
			return yesCount;
		}
		
		int getNoCount()
		{
			return noCount;
		}
		
		boolean isHomogeneous()
		{
			return (yesCount == 0) || (noCount == 0);
		}
		
		double getAverageDisorder(int samples)
		{
			// This feature's contribution to average disorder from
			// pages 429 - 431 of Winston's book.
			if (isHomogeneous()) {
				return 0.0;
			}
			
			double count = yesCount + noCount;
			double yesRatio = yesCount / count;
			double noRatio = noCount / count;
			double disorder = (-yesRatio * Math.log(yesRatio) / Math.log(2)) +
					(-noRatio * Math.log(noRatio) / Math.log(2));
			double avgDisorder = disorder * (yesCount + noCount) / samples;
			return avgDisorder;
		}
		
		public String toString()
		{
			StringBuilder builder = new StringBuilder("ResultCount: yes count: ");
			builder.append(yesCount);
			builder.append(", noCount: ");
			builder.append(noCount);
			return builder.toString();			
		}
	}
}
