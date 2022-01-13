package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;

import com.imbmgdb.persistenza.dao.PollDao;

public class PollDaoJDBC implements PollDao{
	

	private Connection con;
	
	public PollDaoJDBC(Connection con) {
		this.con=con;
	}

}
