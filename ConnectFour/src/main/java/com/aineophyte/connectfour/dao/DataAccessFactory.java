package com.aineophyte.connectfour.dao;

/**
 * By default, the server implementation assumes the data store has
 * been setup in Cassandra and running on the local host.
 * 
 * Starting the server with property com.aineophyte.connectfour.dao.DataAccessFactory=FileSystem
 * will instead use the file system for data storage and retrieval.
 * 
 * @author krasr
 *
 */
public class DataAccessFactory
{
	private static final String DATA_SOURCE =
			System.getProperty("com.aineophyte.connectfour.dao.DataAccessFactory", "Cassandra");

	public static DataAccess getDataAccess()
	{
		// TODO, eventually allow for choice of data store
		if ("FileSystem".equals(DATA_SOURCE)) {
			return new FileSystemDataAccess();
		}
		
		return CassandraDataAccess.getInstance();
	}
}
