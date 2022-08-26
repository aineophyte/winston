package com.skai.idtree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.skai.idtree.FeatureTest.FeatureResultCount;
import com.skai.util.Tree;
import com.skai.util.Tree.Node;

public class IdentificationTree
{
	private static final Logger LOGGER = LogManager.getLogger();
	
	private final String resultFeature;
	private final Map<Long, String> entitiesForTest;
	private final SortedMap<String, Map<Long, String>> inputFeatures = new TreeMap<>();
	private Tree<FeatureTest> featuresToUse;
	
	public IdentificationTree(String resultFeature, Map<Long, String> entitiesForTest,
			Map<String, Map<Long, String>> inputFeatures)
	{
		this.resultFeature = resultFeature;
		this.entitiesForTest = entitiesForTest;
		this.inputFeatures.putAll(inputFeatures);
	}
	
	public void buildTreeFromSampleData()
	{
		buildTreeFromSampleData(entitiesForTest, inputFeatures, null, null);
	}
	
	public Tree<FeatureTest> getFeaturesToUse()
	{
		return featuresToUse;
	}
	
	public Collection<Rule> buildRules()
	{
		Collection<Rule> finalRules = new ArrayList<>();
		Rule rule = new Rule(resultFeature);
		Node<FeatureTest> node = featuresToUse.getRoot();
		buildRules(finalRules, rule, node);	
		return finalRules;
	}
	
	private void buildRules(Collection<Rule> finalRules, Rule workingRule, Node<FeatureTest> currentNode)
	{
		Collection<Rule> workingRules = new ArrayList<>();
		FeatureTest test = currentNode.getData();
		Map<String, FeatureResultCount> results = test.getFeatureResults();
		for (Entry<String,FeatureResultCount> result: results.entrySet()) {	
			Rule rule = workingRule.copy();
			rule.addCriteria(test.getFeature(), result.getKey());
			FeatureResultCount resultCount = result.getValue();
			if (resultCount.isHomogeneous()) {
				rule.setResultValue(resultCount.getYesCount() > 0 ? "Y" : "N");
				finalRules.add(rule);
			} else {
				workingRules.add(rule);
			}
		}
		
		// TODO, is this logic bullet proof?
		// come up with a test scenario that might break it.
		List<Node<FeatureTest>> children = currentNode.getChildren();
		int i = 0;
		for (Rule rule : workingRules) {
			if (i < children.size()) {
				buildRules(finalRules, rule, children.get(i++));
			} else {
				rule.setResultValue("?");
				finalRules.add(rule);
			}
		}	
	}
	
	private void buildTreeFromSampleData(Map<Long, String> entities, SortedMap<String, Map<Long, String>> features, Node<FeatureTest> currentNode, String parentFeatureValue)
	{
		if (entities.isEmpty() || features.isEmpty()) {
			return;
		}
		
		FeatureTest winner = null;
		for (Entry<String,Map<Long,String>> feature : features.entrySet()) {
			FeatureTest featureTest = new FeatureTest(feature.getKey(), feature.getValue(), entities);
			
			if (currentNode != null) {
				featureTest.setParentFeature(currentNode.getData().getFeature());
				featureTest.setParentFeatureValue(parentFeatureValue);
			}
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(featureTest);
			}
			
			if (winner == null) {
				winner = featureTest;
			} else if (featureTest.getAverageDisorder() < winner.getAverageDisorder()) {
				winner = featureTest;
			}
		}
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Winner: " + winner);
		}

        Node<FeatureTest> baseNode;
        if (currentNode == null) {
        	featuresToUse = new Tree<FeatureTest>(winner);
        	baseNode = featuresToUse.getRoot();
        } else {
        	baseNode = currentNode.addChild(winner);
        }

        features.remove(winner.getFeature());
        Map<String, Map<Long, String>> entitiesInDoubt = winner.getEntitiesInDoubt();
        for (Entry<String, Map<Long, String>> entry : entitiesInDoubt.entrySet()) {
        	SortedMap<String, Map<Long, String>> remainingFeatures = new TreeMap<>();
        	remainingFeatures.putAll(features);
        	buildTreeFromSampleData(entry.getValue(), remainingFeatures, baseNode, entry.getKey());
        }
	}
}
