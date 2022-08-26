package com.skai.idtree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.skai.idtree.FeatureTest.FeatureResultCount;
import com.skai.idtree.dao.IdentificationTreeDAO;
import com.skai.util.Tree;
import com.skai.util.Tree.Node;

public class WinstonChapterTwentyOne
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static long testId = -1;
	private static boolean testTree = false;
	private static boolean verbose = false;
	private static Map<String,String> testTreeFeatures = new HashMap<>();
	
    public static void main(String[] args)
    {
        String connectionUrl = System.getProperty("connectionUrl");
        String dbUser = System.getProperty("dbUser");
        String dbPassword = System.getProperty("dbPassword");
        
        parseArgs(args);
        
    	try (Connection connection = DriverManager.getConnection(connectionUrl, dbUser, dbPassword)) {
    		IdentificationTreeDAO dao = new IdentificationTreeDAO();
    		Map<Long, String> entitiesForTest = dao.getEntitiesForTest(connection, testId);
    		
    		if (LOGGER.isDebugEnabled()) {
    			LOGGER.debug(entitiesForTest);
    		}
    		
    		Map<String, Map<Long, String>> inputFeatures = dao.getInputFeaturesForTest(connection, testId, entitiesForTest.keySet());
    		
    		if (LOGGER.isDebugEnabled()) {
    			LOGGER.debug(inputFeatures);
    		}

    		String resultFeature = dao.getResultFeatureForTest(connection, testId);
    		IdentificationTree idTree = new IdentificationTree(resultFeature, entitiesForTest, inputFeatures);
    		idTree.buildTreeFromSampleData();
    		Collection<Rule> rules = idTree.buildRules();
    		LOGGER.info("Total rules: " + rules.size());
    		for (Rule rule : rules) {
    			if (verbose) {
    				if (rule.isPositiveResult()) {
    					LOGGER.info(rule);
        				Map<Long, String> entities = dao.getEntitiesWithFeatures(connection, rule.getTreeFeatures());
        				System.out.println("Entities that match:");
        				for (String entityName : getSortedEntityNames(entities)) {
        					System.out.println(entityName);
        				}
        				System.out.println("\n");
    				}   				
    			} else {
    			    LOGGER.info(rule);
    			}
    		}
    		
    		if (testTree) {
    			try (Scanner sc = new Scanner(System.in)) {
        			Tree<FeatureTest> tree = idTree.getFeaturesToUse();
        			Node<FeatureTest> currentNode = tree.getRoot();
    				testTree(sc, resultFeature, currentNode);
    			}
    			
    			if (verbose) {
    				Map<Long, String> entities = dao.getEntitiesWithFeatures(connection, testTreeFeatures);
    				System.out.println("\nEntities that match:");
    				for (String entityName : getSortedEntityNames(entities)) {
    					System.out.println(entityName);
    				}
    			}
    		}
    	} catch (Exception ex) {
    		LOGGER.error(ex);
    	}
    }
    
    // Luckily works because of naming pattern
    private static Collection<String> getSortedEntityNames(Map<Long, String> entities)
    {
    	List<String> entityNames = new ArrayList<>(entities.values());
    	Collections.sort(entityNames);
    	return entityNames;
    }
    
    private static void testTree(Scanner sc, String resultFeature, Node<FeatureTest> currentNode)
    {
		FeatureTest test = currentNode.getData();
		System.out.print("Enter " + test.getFeature() + ": ");
		String featureValue = sc.next();
		
		testTreeFeatures.put(test.getFeature(), featureValue);
		
		FeatureResultCount counts = test.getFeatureResults().get(featureValue);
		if (counts == null) {
			System.out.println(resultFeature + " is ?, this combo was never tested with sample data.");
			return;			
		}
		
		if (counts.isHomogeneous()) {
			System.out.println(resultFeature + " is " + (counts.getYesCount() > 0 ? "Y" : "N"));
			return;
		} else {
			List<Node<FeatureTest>> children = currentNode.getChildren();
			if (children.isEmpty()) {
				System.out.println(resultFeature + " is ?");
				return;
			}
			for (Node<FeatureTest> node : children) {
				FeatureTest nextTest = node.getData();
				if (nextTest.getParentFeatureValue().equals(featureValue)) {
					testTree(sc, resultFeature, node);
				}
			}
		}   	
    }
    
    private static void parseArgs(String[] args)
    {
    	int i = 0;
    	while (i < args.length) {
    		String arg = args[i];
    		if ("--bt".equals(arg) || "--buildTree".equals(arg)) {
    			i++;
    			if (i < args.length) {
    				testId = Long.parseLong(args[i]);
                    i++;
    			} else {
    				throw new IllegalArgumentException("missing test id");
    			}
    		} else if ("--tt".equals(arg) || "--testTree".equals(arg)) {
    			testTree = true;
    			i++;   			
    		} else if ("--v".equals(arg) || "--verbose".equals(arg)) {
    			verbose = true;
    			i++;
    		} else {
    			throw new IllegalArgumentException(arg + "is not a valid argument");
    		}
    	}
    	
    	if (testId == -1) {
    		throw new IllegalArgumentException("Usage --bt or --buildTree [testId] --t or --testTree --v or --verbose");
    	}
    }
}
