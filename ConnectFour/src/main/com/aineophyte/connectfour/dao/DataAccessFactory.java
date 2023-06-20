package com.aineophyte.connectfour.dao;

public class DataAccessFactory
{
	public static DataAccess getDataAccess()
	{
		// TODO, eventually allow for choice of data store
		//
		// Maybe each can be a singleton?
		return new CassandraDataAccess();
	}

}
