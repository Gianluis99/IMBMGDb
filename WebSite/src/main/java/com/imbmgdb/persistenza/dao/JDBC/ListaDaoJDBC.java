package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.imbmgdb.model.Lista;
import com.imbmgdb.persistenza.dao.ListaDao;

public class ListaDaoJDBC implements ListaDao {

	
	private Connection conn;
	
	public ListaDaoJDBC(Connection conn) {
		this.conn=conn;
	}
	
	
	@Override
	public List<Lista> findByUser(String username) {
		return null;
	}


	@Override
	public void delete(Lista lista) {
		
	}


	@Override
	public boolean insertNewLista(Lista lista) {
		String query = "insert into lista values (?,?)";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, lista.getNome());
			st.setString(2, lista.getNomeUtente());
			
			int res=0;
			res=st.executeUpdate();
			return res > 0; //se l'elemento è stato inserito ritorna true

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	}


	@Override
	public boolean updateLista(Long id) {
		return false;
	}

}
