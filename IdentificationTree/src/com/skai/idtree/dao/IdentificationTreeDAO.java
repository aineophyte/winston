package com.skai.idtree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class IdentificationTreeDAO
{
	// All the entities that should be included in generating the test
	// they all have the input features and result feature
	private final String GET_ENTITIES_FOR_TEST = "select id.ENTITY_ID, it.RESULT_FEATURE_TYPE, id.FEATURE_VALUE from IDENTIFICATION_DATA id\r\n"
			+ "join IDENTIFICATION_TEST it on it.RESULT_FEATURE_TYPE = id.FEATURE_TYPE\r\n"
			+ "join (select ENTITY_FEATURE_COUNT.ENTITY_ID, ENTITY_FEATURE_COUNT.TEST_ID from\r\n"
			+ "(select id.ENTITY_ID, iti.TEST_ID, count(id.FEATURE_TYPE) FEATURE_COUNT from IDENTIFICATION_DATA id\r\n"
			+ "join IDENTIFICATION_TEST_INPUT iti on iti.FEATURE_TYPE = id.FEATURE_TYPE\r\n"
			+ "group by id.ENTITY_ID, iti.TEST_ID) ENTITY_FEATURE_COUNT\r\n"
			+ "join (select TEST_ID, count(FEATURE_TYPE) FEATURE_COUNT from IDENTIFICATION_TEST_INPUT group by TEST_ID) TOTAL_FEATURE_COUNT on TOTAL_FEATURE_COUNT.FEATURE_COUNT = ENTITY_FEATURE_COUNT.FEATURE_COUNT\r\n"
			+ "and TOTAL_FEATURE_COUNT.TEST_ID = ENTITY_FEATURE_COUNT.TEST_ID) miti on miti.ENTITY_ID = id.ENTITY_ID and miti.TEST_ID = it.TEST_ID\r\n"
			+ "where it.TEST_ID = ?";
	
	private final String GET_INPUT_FEATURES_FOR_TEST = "select id.ENTITY_ID, id.FEATURE_TYPE, id.FEATURE_VALUE from IDENTIFICATION_DATA id\r\n"
			+ "join IDENTIFICATION_TEST_INPUT iti on iti.FEATURE_TYPE = id.FEATURE_TYPE\r\n"
			+ "where iti.TEST_ID = ? and id.ENTITY_ID in (%s)";
	
	private final String GET_RESULT_FEATURE_FOR_TEST = "select RESULT_FEATURE_TYPE from IDENTIFICATION_TEST where TEST_ID = ?";
	
	private final String GET_ENTITIES_WITH_FEATURES =  "select e.ENTITY_ID, e.FIRST_NAME, e.LAST_NAME from ENTITY e join\r\n"
			+ "(select ENTITY_ID, count(FEATURE_TYPE) matches from IDENTIFICATION_DATA where %s group by ENTITY_ID) features\r\n"
			+ "on features.ENTITY_ID = e.ENTITY_ID where features.matches = ?";
	
	public Map<Long, String> getEntitiesForTest(Connection connection, long testId) throws SQLException
	{
		Map<Long, String> entityToTestResult = new HashMap<>();

        try (PreparedStatement stmt = connection.prepareStatement(GET_ENTITIES_FOR_TEST)) {
            stmt.setLong(1, testId);
        	ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
            	long entityId = resultSet.getLong(1);
            	String resultValue = resultSet.getString(3);
            	entityToTestResult.put(entityId, resultValue);
            }
        	return entityToTestResult;
        }
	}

	public Map<String, Map<Long, String>> getInputFeaturesForTest(Connection connection, long testId, Collection<Long> entityIds) throws SQLException
	{
		StringBuilder entityIdWhere = new StringBuilder();
		Iterator<Long> it = entityIds.iterator();
		while (it.hasNext()) {
			it.next();
			if (entityIdWhere.length() > 0) {
				entityIdWhere.append(",");
			}
			entityIdWhere.append("?");
		}
		
		String sql = String.format(GET_INPUT_FEATURES_FOR_TEST, entityIdWhere.toString());
		
		Map<String, Map<Long, String>> features = new HashMap<>();
		
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        	int i = 1;
            stmt.setLong(i++, testId);
    		for (long id : entityIds) {
    			stmt.setLong(i++, id);
    		}
        	ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
            	long id = resultSet.getLong(1);
            	String feature = resultSet.getString(2);
            	String featureValue = resultSet.getString(3);
            	
            	Map<Long, String> featureMap = features.get(feature);
            	if (featureMap == null) {
            		featureMap = new HashMap<>();
            		features.put(feature, featureMap);
            	}
            	featureMap.put(id, featureValue);
            }
            
        	return features;
        }		
	}
	
	public String getResultFeatureForTest(Connection connection, long testId) throws SQLException
	{
        try (PreparedStatement stmt = connection.prepareStatement(GET_RESULT_FEATURE_FOR_TEST)) {
            stmt.setLong(1, testId);
        	ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            return resultSet.getString(1);
        }		
	}
	
	public Map<Long, String> getEntitiesWithFeatures(Connection connection, Map<String,String> features) throws SQLException
	{
		StringBuilder featuresWhere = new StringBuilder();
		Iterator<String> it = features.keySet().iterator();
		while (it.hasNext()) {
			it.next();
			if (featuresWhere.length() > 0) {
				featuresWhere.append(" or ");
			}
			featuresWhere.append("(FEATURE_TYPE = ? and FEATURE_VALUE = ?)");
		}
		
		String sql = String.format(GET_ENTITIES_WITH_FEATURES, featuresWhere.toString());
		
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        	int i = 1;
    		for (Entry<String,String> entry : features.entrySet()) {
    			stmt.setString(i++, entry.getKey());
    			stmt.setString(i++, entry.getValue());
    		}
            stmt.setLong(i++, features.size());

            ResultSet resultSet = stmt.executeQuery();
            
            Map<Long,String> entities = new HashMap<>();
            while (resultSet.next()) {
            	long id = resultSet.getLong(1);
            	String firstName = resultSet.getString(2);
            	String lastName = resultSet.getString(3);
            	entities.put(id, firstName + " " + lastName);
            }
            
        	return entities;
        }		
	}
}
