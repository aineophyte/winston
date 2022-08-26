package com.skai.idtree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdentificationTreeTest {
	
	private static final Logger LOGGER = LogManager.getLogger();
	/*
	 * data from Lecture 11
	1,CASTS_SHADOW=?,EATS_GARLIC=Y,COMPLEXION=Pale,ACCENT=None,IS_VAMPIRE=N
	2,CASTS_SHADOW=Y,EATS_GARLIC=Y,COMPLEXION=Ruddy,ACCENT=None,IS_VAMPIRE=N
	3,CASTS_SHADOW=?,EATS_GARLIC=N,COMPLEXION=Ruddy,ACCENT=None,IS_VAMPIRE=Y
	4,CASTS_SHADOW=N,EATS_GARLIC=N,COMPLEXION=Average,ACCENT=Heavy,IS_VAMPIRE=Y
	5,CASTS_SHADOW=?,EATS_GARLIC=N,COMPLEXION=Average,ACCENT=Odd,IS_VAMPIRE=Y
	6,CASTS_SHADOW=Y,EATS_GARLIC=N,COMPLEXION=Pale,ACCENT=Heavy,IS_VAMPIRE=N
	7,CASTS_SHADOW=Y,EATS_GARLIC=N,COMPLEXION=Average,ACCENT=Heavy,IS_VAMPIRE=N
	8,CASTS_SHADOW=?,EATS_GARLIC=Y,COMPLEXION=Ruddy,ACCENT=Odd,IS_VAMPIRE=N
	*/
	@Test
	void winstonLectureElevenVampireTest()
	{
		String resultFeature = "IS_VAMPIRE";
		Map<Long,String> entitiesForTest = new HashMap<>();
		entitiesForTest.put(1L, "N");
		entitiesForTest.put(2L, "N");
		entitiesForTest.put(3L, "Y");
		entitiesForTest.put(4L, "Y");
		entitiesForTest.put(5L, "Y");
		entitiesForTest.put(6L, "N");
		entitiesForTest.put(7L, "N");
		entitiesForTest.put(8L, "N");
		Map<String, Map<Long, String>> inputFeatures = new HashMap<>();
		Map<Long,String> complexionResults = new HashMap<>();
		complexionResults.put(1L, "Pale");
		complexionResults.put(2L, "Ruddy");
		complexionResults.put(3L, "Ruddy");
		complexionResults.put(4L, "Average");
		complexionResults.put(5L, "Average");
		complexionResults.put(6L, "Pale");
		complexionResults.put(7L, "Average");
		complexionResults.put(8L, "Ruddy");
		inputFeatures.put("COMPLEXION", complexionResults);
		Map<Long,String> accentResults = new HashMap<>();
		accentResults.put(1L, "None");
		accentResults.put(2L, "None");
		accentResults.put(3L, "None");
		accentResults.put(4L, "Heavy");
		accentResults.put(5L, "Odd");
		accentResults.put(6L, "Heavy");
		accentResults.put(7L, "Heavy");
		accentResults.put(8L, "Odd");
		inputFeatures.put("ACCENT", accentResults);
		Map<Long,String> castsShadowResults = new HashMap<>();
		castsShadowResults.put(1L, "?");
		castsShadowResults.put(2L, "Y");
		castsShadowResults.put(3L, "?");
		castsShadowResults.put(4L, "N");
		castsShadowResults.put(5L, "?");
		castsShadowResults.put(6L, "Y");
		castsShadowResults.put(7L, "Y");
		castsShadowResults.put(8L, "?");
		inputFeatures.put("CASTS_SHADOW", castsShadowResults);
		Map<Long,String> eatsGarlicResults = new HashMap<>();
		eatsGarlicResults.put(1L, "Y");
		eatsGarlicResults.put(2L, "Y");
		eatsGarlicResults.put(3L, "N");
		eatsGarlicResults.put(4L, "N");
		eatsGarlicResults.put(5L, "N");
		eatsGarlicResults.put(6L, "N");
		eatsGarlicResults.put(7L, "N");
		eatsGarlicResults.put(8L, "Y");
		inputFeatures.put("EATS_GARLIC", eatsGarlicResults);
		
		IdentificationTree idTree = new IdentificationTree(resultFeature, entitiesForTest, inputFeatures);
		idTree.buildTreeFromSampleData();
		Collection<Rule> rules = idTree.buildRules();
		assertEquals(4, rules.size(), "Incorrect number of rules");
		
		Collection<Rule> expected = new ArrayList<>();
		Rule expRule1 = new Rule("IS_VAMPIRE");
		expRule1.setResultValue("Y");
		expRule1.addCriteria("CASTS_SHADOW", "N");
		expected.add(expRule1);
		
		Rule expRule2 = new Rule("IS_VAMPIRE");
		expRule2.setResultValue("N");
		expRule2.addCriteria("CASTS_SHADOW", "Y");
		expected.add(expRule2);
		
		Rule expRule3 = new Rule("IS_VAMPIRE");
		expRule3.setResultValue("Y");
		expRule3.addCriteria("CASTS_SHADOW", "?");
		expRule3.addCriteria("EATS_GARLIC", "N");
		expected.add(expRule3);
		
		Rule expRule4 = new Rule("IS_VAMPIRE");
		expRule4.setResultValue("N");
		expRule4.addCriteria("CASTS_SHADOW", "?");
		expRule4.addCriteria("EATS_GARLIC", "Y");
		expected.add(expRule4);
		
		for (Rule rule : rules) {
			LOGGER.info(rule);
		}
		
		assertEquals(expected, rules, "Incorect rules");
	}
	
	@Test
	void playGolfTest1()
	{
		String resultFeature = "PLAY_GOLF";
		Map<Long,String> entitiesForTest = new HashMap<>();
		entitiesForTest.put(1L, "Y");
		entitiesForTest.put(2L, "Y");
		entitiesForTest.put(3L, "Y");
		entitiesForTest.put(4L, "Y");
		entitiesForTest.put(5L, "Y");
		entitiesForTest.put(6L, "Y");
		entitiesForTest.put(7L, "N");
		entitiesForTest.put(8L, "Y");
		entitiesForTest.put(9L, "N");
		entitiesForTest.put(10L, "N");
		entitiesForTest.put(11L, "N");
		entitiesForTest.put(12L, "N");
		entitiesForTest.put(13L, "Y");
		entitiesForTest.put(14L, "Y");
		Map<String, Map<Long, String>> inputFeatures = new HashMap<>();
		Map<Long,String> outlookResults = new HashMap<>();
		outlookResults.put(1L, "Overcast");
		outlookResults.put(2L, "Overcast");
		outlookResults.put(3L, "Overcast");
		outlookResults.put(4L, "Overcast");
		outlookResults.put(5L, "Rainy");
		outlookResults.put(6L, "Rainy");
		outlookResults.put(7L, "Rainy");
		outlookResults.put(8L, "Rainy");
		outlookResults.put(9L, "Rainy");
		outlookResults.put(10L, "Sunny");
		outlookResults.put(11L, "Sunny");
		outlookResults.put(12L, "Sunny");
		outlookResults.put(13L, "Sunny");
		outlookResults.put(14L, "Sunny");
		inputFeatures.put("OUTLOOK", outlookResults);
		Map<Long,String> temperatureResults = new HashMap<>();
		temperatureResults.put(1L, "Hot");
		temperatureResults.put(2L, "Cool");
		temperatureResults.put(3L, "Mild");
		temperatureResults.put(4L, "Hot");
		temperatureResults.put(5L, "Mild");
		temperatureResults.put(6L, "Cool");
		temperatureResults.put(7L, "Cool");
		temperatureResults.put(8L, "Mild");
		temperatureResults.put(9L, "Mild");
		temperatureResults.put(10L, "Hot");
		temperatureResults.put(11L, "Hot");
		temperatureResults.put(12L, "Mild");
		temperatureResults.put(13L, "Cool");
		temperatureResults.put(14L, "Mild");
		inputFeatures.put("TEMPERATURE", temperatureResults);
		Map<Long,String> humidityResults = new HashMap<>();
		humidityResults.put(1L, "High");
		humidityResults.put(2L, "Normal");
		humidityResults.put(3L, "High");
		humidityResults.put(4L, "Normal");
		humidityResults.put(5L, "High");
		humidityResults.put(6L, "Normal");
		humidityResults.put(7L, "Normal");
		humidityResults.put(8L, "Normal");
		humidityResults.put(9L, "High");
		humidityResults.put(10L, "High");
		humidityResults.put(11L, "High");
		humidityResults.put(12L, "High");
		humidityResults.put(13L, "Normal");
		humidityResults.put(14L, "Normal");
		inputFeatures.put("HUMIDITY", humidityResults);
		Map<Long,String> windyResults = new HashMap<>();
		windyResults.put(1L, "N");
		windyResults.put(2L, "Y");
		windyResults.put(3L, "Y");
		windyResults.put(4L, "N");
		windyResults.put(5L, "N");
		windyResults.put(6L, "N");
		windyResults.put(7L, "Y");
		windyResults.put(8L, "N");
		windyResults.put(9L, "Y");
		windyResults.put(10L, "N");
		windyResults.put(11L, "Y");
		windyResults.put(12L, "N");
		windyResults.put(13L, "N");
		windyResults.put(14L, "Y");
		inputFeatures.put("WINDY", windyResults);
		
		IdentificationTree idTree = new IdentificationTree(resultFeature, entitiesForTest, inputFeatures);
		idTree.buildTreeFromSampleData();
		Collection<Rule> rules = idTree.buildRules();
		assertEquals(5, rules.size(), "Incorrect number of rules");
		
		Collection<Rule> expected = new ArrayList<>();
		Rule expRule1 = new Rule("PLAY_GOLF");
		expRule1.setResultValue("Y");
		expRule1.addCriteria("OUTLOOK", "Overcast");
		expected.add(expRule1);
		
		Rule expRule2 = new Rule("PLAY_GOLF");
		expRule2.setResultValue("Y");
		expRule2.addCriteria("OUTLOOK", "Rainy");
		expRule2.addCriteria("WINDY", "N");
		expected.add(expRule2);
		
		Rule expRule3 = new Rule("PLAY_GOLF");
		expRule3.setResultValue("N");
		expRule3.addCriteria("OUTLOOK", "Rainy");
		expRule3.addCriteria("WINDY", "Y");
		expected.add(expRule3);

		Rule expRule4 = new Rule("PLAY_GOLF");
		expRule4.setResultValue("N");
		expRule4.addCriteria("OUTLOOK", "Sunny");
		expRule4.addCriteria("HUMIDITY", "High");
		expected.add(expRule4);
		
		Rule expRule5 = new Rule("PLAY_GOLF");
		expRule5.setResultValue("Y");
		expRule5.addCriteria("OUTLOOK", "Sunny");
		expRule5.addCriteria("HUMIDITY", "Normal");
		expected.add(expRule5);

		for (Rule rule : rules) {
			LOGGER.info(rule);
		}
		
		assertEquals(expected, rules, "Incorect rules");
	}

	@Test
	void playGolfTest2()
	{
		String resultFeature = "PLAY_GOLF";
		Map<Long,String> entitiesForTest = new HashMap<>();
		entitiesForTest.put(1L, "Y");
		entitiesForTest.put(2L, "Y");
		entitiesForTest.put(3L, "Y");
		entitiesForTest.put(4L, "Y");
		entitiesForTest.put(5L, "Y");
		entitiesForTest.put(6L, "Y");
		entitiesForTest.put(7L, "N");
		entitiesForTest.put(8L, "N"); // different than playGolfTest1
		entitiesForTest.put(9L, "N");
		entitiesForTest.put(10L, "N");
		entitiesForTest.put(11L, "N");
		entitiesForTest.put(12L, "N");
		entitiesForTest.put(13L, "Y");
		entitiesForTest.put(14L, "Y");
		Map<String, Map<Long, String>> inputFeatures = new HashMap<>();
		Map<Long,String> outlookResults = new HashMap<>();
		outlookResults.put(1L, "Overcast");
		outlookResults.put(2L, "Overcast");
		outlookResults.put(3L, "Overcast");
		outlookResults.put(4L, "Overcast");
		outlookResults.put(5L, "Rainy");
		outlookResults.put(6L, "Rainy");
		outlookResults.put(7L, "Rainy");
		outlookResults.put(8L, "Rainy");
		outlookResults.put(9L, "Rainy");
		outlookResults.put(10L, "Sunny");
		outlookResults.put(11L, "Sunny");
		outlookResults.put(12L, "Sunny");
		outlookResults.put(13L, "Sunny");
		outlookResults.put(14L, "Sunny");
		inputFeatures.put("OUTLOOK", outlookResults);
		Map<Long,String> temperatureResults = new HashMap<>();
		temperatureResults.put(1L, "Hot");
		temperatureResults.put(2L, "Cool");
		temperatureResults.put(3L, "Mild");
		temperatureResults.put(4L, "Hot");
		temperatureResults.put(5L, "Mild");
		temperatureResults.put(6L, "Cool");
		temperatureResults.put(7L, "Cool");
		temperatureResults.put(8L, "Mild");
		temperatureResults.put(9L, "Mild");
		temperatureResults.put(10L, "Hot");
		temperatureResults.put(11L, "Hot");
		temperatureResults.put(12L, "Mild");
		temperatureResults.put(13L, "Cool");
		temperatureResults.put(14L, "Mild");
		inputFeatures.put("TEMPERATURE", temperatureResults);
		Map<Long,String> humidityResults = new HashMap<>();
		humidityResults.put(1L, "High");
		humidityResults.put(2L, "Normal");
		humidityResults.put(3L, "High");
		humidityResults.put(4L, "Normal");
		humidityResults.put(5L, "High");
		humidityResults.put(6L, "Normal");
		humidityResults.put(7L, "Normal");
		humidityResults.put(8L, "Normal");
		humidityResults.put(9L, "High");
		humidityResults.put(10L, "High");
		humidityResults.put(11L, "High");
		humidityResults.put(12L, "High");
		humidityResults.put(13L, "Normal");
		humidityResults.put(14L, "Normal");
		inputFeatures.put("HUMIDITY", humidityResults);
		Map<Long,String> windyResults = new HashMap<>();
		windyResults.put(1L, "N");
		windyResults.put(2L, "Y");
		windyResults.put(3L, "Y");
		windyResults.put(4L, "N");
		windyResults.put(5L, "N");
		windyResults.put(6L, "N");
		windyResults.put(7L, "Y");
		windyResults.put(8L, "N");
		windyResults.put(9L, "Y");
		windyResults.put(10L, "N");
		windyResults.put(11L, "Y");
		windyResults.put(12L, "N");
		windyResults.put(13L, "N");
		windyResults.put(14L, "Y");
		inputFeatures.put("WINDY", windyResults);
		
		IdentificationTree idTree = new IdentificationTree(resultFeature, entitiesForTest, inputFeatures);
		idTree.buildTreeFromSampleData();
		Collection<Rule> rules = idTree.buildRules();
		assertEquals(7, rules.size(), "Incorrect number of rules");
		
		Collection<Rule> expected = new ArrayList<>();
		Rule expRule1 = new Rule("PLAY_GOLF");
		expRule1.setResultValue("Y");
		expRule1.addCriteria("OUTLOOK", "Overcast");
		expected.add(expRule1);

		Rule expRule2 = new Rule("PLAY_GOLF");
		expRule2.setResultValue("N");
		expRule2.addCriteria("OUTLOOK", "Rainy");
		expRule2.addCriteria("WINDY", "Y");
		expected.add(expRule2);
		
		Rule expRule3 = new Rule("PLAY_GOLF");
		expRule3.setResultValue("Y");
		expRule3.addCriteria("OUTLOOK", "Rainy");
		expRule3.addCriteria("WINDY", "N");
		expRule3.addCriteria("HUMIDITY", "High");
		expected.add(expRule3);

		Rule expRule4 = new Rule("PLAY_GOLF");
		expRule4.setResultValue("Y");
		expRule4.addCriteria("OUTLOOK", "Rainy");
		expRule4.addCriteria("WINDY", "N");
		expRule4.addCriteria("HUMIDITY", "Normal");
		expRule4.addCriteria("TEMPERATURE", "Cool");
		expected.add(expRule4);

		Rule expRule5 = new Rule("PLAY_GOLF");
		expRule5.setResultValue("N");
		expRule5.addCriteria("OUTLOOK", "Rainy");
		expRule5.addCriteria("WINDY", "N");
		expRule5.addCriteria("HUMIDITY", "Normal");
		expRule5.addCriteria("TEMPERATURE", "Mild");
		expected.add(expRule5);

		Rule expRule6 = new Rule("PLAY_GOLF");
		expRule6.setResultValue("N");
		expRule6.addCriteria("OUTLOOK", "Sunny");
		expRule6.addCriteria("HUMIDITY", "High");
		expected.add(expRule6);
		
		Rule expRule7 = new Rule("PLAY_GOLF");
		expRule7.setResultValue("Y");
		expRule7.addCriteria("OUTLOOK", "Sunny");
		expRule7.addCriteria("HUMIDITY", "Normal");
		expected.add(expRule7);
		
		for (Rule rule : rules) {
			LOGGER.info(rule);
		}
		
		assertEquals(expected, rules, "Incorect rules");
	}
	
	@Test
	void playGolfTest3()
	{
		String resultFeature = "PLAY_GOLF";
		Map<Long,String> entitiesForTest = new HashMap<>();
		entitiesForTest.put(1L, "Y");
		entitiesForTest.put(2L, "Y");
		entitiesForTest.put(3L, "Y");
		entitiesForTest.put(4L, "Y");
		entitiesForTest.put(5L, "Y");
		entitiesForTest.put(6L, "Y");
		entitiesForTest.put(7L, "N");
		entitiesForTest.put(8L, "N"); // different than playGolfTest1
		entitiesForTest.put(9L, "Y"); // different than playGolfTest2
		entitiesForTest.put(10L, "N");
		entitiesForTest.put(11L, "N");
		entitiesForTest.put(12L, "N");
		entitiesForTest.put(13L, "Y");
		entitiesForTest.put(14L, "Y");
		Map<String, Map<Long, String>> inputFeatures = new HashMap<>();
		Map<Long,String> outlookResults = new HashMap<>();
		outlookResults.put(1L, "Overcast");
		outlookResults.put(2L, "Overcast");
		outlookResults.put(3L, "Overcast");
		outlookResults.put(4L, "Overcast");
		outlookResults.put(5L, "Rainy");
		outlookResults.put(6L, "Rainy");
		outlookResults.put(7L, "Rainy");
		outlookResults.put(8L, "Rainy");
		outlookResults.put(9L, "Rainy");
		outlookResults.put(10L, "Sunny");
		outlookResults.put(11L, "Sunny");
		outlookResults.put(12L, "Sunny");
		outlookResults.put(13L, "Sunny");
		outlookResults.put(14L, "Sunny");
		inputFeatures.put("OUTLOOK", outlookResults);
		Map<Long,String> temperatureResults = new HashMap<>();
		temperatureResults.put(1L, "Hot");
		temperatureResults.put(2L, "Cool");
		temperatureResults.put(3L, "Mild");
		temperatureResults.put(4L, "Hot");
		temperatureResults.put(5L, "Mild");
		temperatureResults.put(6L, "Cool");
		temperatureResults.put(7L, "Cool");
		temperatureResults.put(8L, "Mild");
		temperatureResults.put(9L, "Mild");
		temperatureResults.put(10L, "Hot");
		temperatureResults.put(11L, "Hot");
		temperatureResults.put(12L, "Mild");
		temperatureResults.put(13L, "Cool");
		temperatureResults.put(14L, "Mild");
		inputFeatures.put("TEMPERATURE", temperatureResults);
		Map<Long,String> humidityResults = new HashMap<>();
		humidityResults.put(1L, "High");
		humidityResults.put(2L, "Normal");
		humidityResults.put(3L, "High");
		humidityResults.put(4L, "Normal");
		humidityResults.put(5L, "High");
		humidityResults.put(6L, "Normal");
		humidityResults.put(7L, "Normal");
		humidityResults.put(8L, "Normal");
		humidityResults.put(9L, "High");
		humidityResults.put(10L, "High");
		humidityResults.put(11L, "High");
		humidityResults.put(12L, "High");
		humidityResults.put(13L, "Normal");
		humidityResults.put(14L, "Normal");
		inputFeatures.put("HUMIDITY", humidityResults);
		Map<Long,String> windyResults = new HashMap<>();
		windyResults.put(1L, "N");
		windyResults.put(2L, "Y");
		windyResults.put(3L, "Y");
		windyResults.put(4L, "N");
		windyResults.put(5L, "N");
		windyResults.put(6L, "N");
		windyResults.put(7L, "Y");
		windyResults.put(8L, "N");
		windyResults.put(9L, "Y");
		windyResults.put(10L, "N");
		windyResults.put(11L, "Y");
		windyResults.put(12L, "N");
		windyResults.put(13L, "N");
		windyResults.put(14L, "Y");
		inputFeatures.put("WINDY", windyResults);
		
		IdentificationTree idTree = new IdentificationTree(resultFeature, entitiesForTest, inputFeatures);
		idTree.buildTreeFromSampleData();
		Collection<Rule> rules = idTree.buildRules();
		assertEquals(7, rules.size(), "Incorrect number of rules");
		
		Collection<Rule> expected = new ArrayList<>();
		Rule expRule1 = new Rule("PLAY_GOLF");
		expRule1.setResultValue("Y");
		expRule1.addCriteria("OUTLOOK", "Overcast");
		expected.add(expRule1);

		Rule expRule2 = new Rule("PLAY_GOLF");
		expRule2.setResultValue("Y");
		expRule2.addCriteria("OUTLOOK", "Rainy");
		expRule2.addCriteria("HUMIDITY", "High");
		expected.add(expRule2);
		
		Rule expRule3 = new Rule("PLAY_GOLF");
		expRule3.setResultValue("N");
		expRule3.addCriteria("OUTLOOK", "Rainy");
		expRule3.addCriteria("HUMIDITY", "Normal");
		expRule3.addCriteria("TEMPERATURE", "Mild");
		expected.add(expRule3);

		Rule expRule4 = new Rule("PLAY_GOLF");
		expRule4.setResultValue("Y");
		expRule4.addCriteria("OUTLOOK", "Rainy");
		expRule4.addCriteria("HUMIDITY", "Normal");
		expRule4.addCriteria("TEMPERATURE", "Cool");
		expRule4.addCriteria("WINDY", "N");
		expected.add(expRule4);

		Rule expRule5 = new Rule("PLAY_GOLF");
		expRule5.setResultValue("N");
		expRule5.addCriteria("OUTLOOK", "Rainy");		
		expRule5.addCriteria("HUMIDITY", "Normal");
		expRule5.addCriteria("TEMPERATURE", "Cool");
		expRule5.addCriteria("WINDY", "Y");
		expected.add(expRule5);

		Rule expRule6 = new Rule("PLAY_GOLF");
		expRule6.setResultValue("N");
		expRule6.addCriteria("OUTLOOK", "Sunny");
		expRule6.addCriteria("HUMIDITY", "High");
		expected.add(expRule6);
		
		Rule expRule7 = new Rule("PLAY_GOLF");
		expRule7.setResultValue("Y");
		expRule7.addCriteria("OUTLOOK", "Sunny");
		expRule7.addCriteria("HUMIDITY", "Normal");
		expected.add(expRule7);
		
		for (Rule rule : rules) {
			LOGGER.info(rule);
		}
		
		assertEquals(expected, rules, "Incorect rules");
	}

	@Test
	void playGolfTest4()
	{
		String resultFeature = "PLAY_GOLF";
		Map<Long,String> entitiesForTest = new HashMap<>();
		entitiesForTest.put(1L, "Y");
		entitiesForTest.put(2L, "Y");
		entitiesForTest.put(3L, "Y");
		entitiesForTest.put(4L, "Y");
		entitiesForTest.put(5L, "Y");
		entitiesForTest.put(6L, "Y");
		entitiesForTest.put(7L, "N");
		entitiesForTest.put(8L, "N"); // different than playGolfTest1
		entitiesForTest.put(9L, "N");
		entitiesForTest.put(10L, "N");
		entitiesForTest.put(11L, "N");
		entitiesForTest.put(12L, "N");
		entitiesForTest.put(13L, "Y");
		entitiesForTest.put(14L, "Y");
		Map<String, Map<Long, String>> inputFeatures = new HashMap<>();
		Map<Long,String> outlookResults = new HashMap<>();
		outlookResults.put(1L, "Overcast");
		outlookResults.put(2L, "Overcast");
		outlookResults.put(3L, "Overcast");
		outlookResults.put(4L, "Overcast");
		outlookResults.put(5L, "Rainy");
		outlookResults.put(6L, "Rainy");
		outlookResults.put(7L, "Rainy");
		outlookResults.put(8L, "Rainy");
		outlookResults.put(9L, "Rainy");
		outlookResults.put(10L, "Sunny");
		outlookResults.put(11L, "Sunny");
		outlookResults.put(12L, "Sunny");
		outlookResults.put(13L, "Sunny");
		outlookResults.put(14L, "Sunny");
		inputFeatures.put("OUTLOOK", outlookResults);
		Map<Long,String> temperatureResults = new HashMap<>();
		temperatureResults.put(1L, "Hot");
		temperatureResults.put(2L, "Cool");
		temperatureResults.put(3L, "Mild");
		temperatureResults.put(4L, "Hot");
		temperatureResults.put(5L, "Mild");
		temperatureResults.put(6L, "Cool");
		temperatureResults.put(7L, "Cool");
		temperatureResults.put(8L, "Cool"); // different than playGolfTest1
		temperatureResults.put(9L, "Mild");
		temperatureResults.put(10L, "Hot");
		temperatureResults.put(11L, "Hot");
		temperatureResults.put(12L, "Mild");
		temperatureResults.put(13L, "Cool");
		temperatureResults.put(14L, "Mild");
		inputFeatures.put("TEMPERATURE", temperatureResults);
		Map<Long,String> humidityResults = new HashMap<>();
		humidityResults.put(1L, "High");
		humidityResults.put(2L, "Normal");
		humidityResults.put(3L, "High");
		humidityResults.put(4L, "Normal");
		humidityResults.put(5L, "High");
		humidityResults.put(6L, "Normal");
		humidityResults.put(7L, "Normal");
		humidityResults.put(8L, "Normal");
		humidityResults.put(9L, "High");
		humidityResults.put(10L, "High");
		humidityResults.put(11L, "High");
		humidityResults.put(12L, "High");
		humidityResults.put(13L, "Normal");
		humidityResults.put(14L, "Normal");
		inputFeatures.put("HUMIDITY", humidityResults);
		Map<Long,String> windyResults = new HashMap<>();
		windyResults.put(1L, "N");
		windyResults.put(2L, "Y");
		windyResults.put(3L, "Y");
		windyResults.put(4L, "N");
		windyResults.put(5L, "N");
		windyResults.put(6L, "N");
		windyResults.put(7L, "Y");
		windyResults.put(8L, "N");
		windyResults.put(9L, "Y");
		windyResults.put(10L, "N");
		windyResults.put(11L, "Y");
		windyResults.put(12L, "N");
		windyResults.put(13L, "N");
		windyResults.put(14L, "Y");
		inputFeatures.put("WINDY", windyResults);
		
		IdentificationTree idTree = new IdentificationTree(resultFeature, entitiesForTest, inputFeatures);
		idTree.buildTreeFromSampleData();
		Collection<Rule> rules = idTree.buildRules();
		assertEquals(6, rules.size(), "Incorrect number of rules");
		
		Collection<Rule> expected = new ArrayList<>();
		Rule expRule1 = new Rule("PLAY_GOLF");
		expRule1.setResultValue("Y");
		expRule1.addCriteria("OUTLOOK", "Overcast");
		expected.add(expRule1);

		Rule expRule2 = new Rule("PLAY_GOLF");
		expRule2.setResultValue("N");
		expRule2.addCriteria("OUTLOOK", "Rainy");
		expRule2.addCriteria("WINDY", "Y");
		expected.add(expRule2);

		Rule expRule3 = new Rule("PLAY_GOLF");
		expRule3.setResultValue("Y");
		expRule3.addCriteria("OUTLOOK", "Rainy");
		expRule3.addCriteria("WINDY", "N");
		expRule3.addCriteria("HUMIDITY", "High");
		expected.add(expRule3);

		Rule expRule4 = new Rule("PLAY_GOLF");
		expRule4.setResultValue("?");
		expRule4.addCriteria("OUTLOOK", "Rainy");
		expRule4.addCriteria("WINDY", "N");
		expRule4.addCriteria("HUMIDITY", "Normal");
		expRule4.addCriteria("TEMPERATURE", "Cool");
		expected.add(expRule4);
		
		Rule expRule5 = new Rule("PLAY_GOLF");
		expRule5.setResultValue("N");
		expRule5.addCriteria("OUTLOOK", "Sunny");
		expRule5.addCriteria("HUMIDITY", "High");
		expected.add(expRule5);
		
		Rule expRule6 = new Rule("PLAY_GOLF");
		expRule6.setResultValue("Y");
		expRule6.addCriteria("OUTLOOK", "Sunny");
		expRule6.addCriteria("HUMIDITY", "Normal");
		expected.add(expRule6);
		
		for (Rule rule : rules) {
			LOGGER.info(rule);
		}
		
		assertEquals(expected, rules, "Incorect rules");
	}
}
