package com.aineophyte.connectfour.dao;

public class DataAccessFactory
{
	public static DataAccess getDataAccess()
	{
		// TODO, eventually allow for choice of data store
		return CassandraDataAccess.getInstance();
	}

}
