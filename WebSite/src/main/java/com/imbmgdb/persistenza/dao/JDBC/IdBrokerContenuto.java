package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IdBrokerContenuto {

	public static Long getID( Connection con) throws SQLException {
		String query="select nextval('contenuto_seq') as id";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getLong("id");
	}
}
