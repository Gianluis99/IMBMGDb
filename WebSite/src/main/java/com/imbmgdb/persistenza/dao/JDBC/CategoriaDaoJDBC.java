package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.imbmgdb.model.Categoria;
import com.imbmgdb.persistenza.dao.CategoriaDao;

public class CategoriaDaoJDBC implements CategoriaDao {

	private Connection conn;

	public CategoriaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean save(Categoria c) {
		String query = "insert into categoria values (?)";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, c.getNome());
			int result=0;
			result=st.executeUpdate();
			st.close();
			
			return result==1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	@Override
	public boolean delete(Categoria c) {
		return false;
	}
}
