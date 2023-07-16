package com.aineophyte.connectfour.dao;

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
