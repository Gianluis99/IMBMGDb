package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imbmgdb.model.Lista;
import com.imbmgdb.other.Messages;
import com.imbmgdb.persistenza.dao.ListaDao;

public class ListaDaoJDBC implements ListaDao {

	
	private Connection conn;
	
	public ListaDaoJDBC(Connection conn) {
		this.conn=conn;
	}
	
	
	@Override
	public List<String> findByUser(String username) {
		List<String> lists = new ArrayList<String>();
		String query = "SELECT nome FROM lista WHERE nome_utente LIKE  '%" + username + "%'";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.executeQuery();
			ResultSet res = st.executeQuery();
			while (res.next()) {
				lists.add(res.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return lists;
	}


	@Override
	public void delete(Lista lista) {
		String query = "delete from lista where nome = ? and nome_utente = ?";
		
		try {
			deleteAllContents(lista);
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, lista.getNome());
			st.setString(2, lista.getNomeUtente());
		
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
	}
	
	private void deleteAllContents(Lista lista) {
		String query = "delete from contiene where nome_lista = ? and nome_utente = ?";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, lista.getNome());
			st.setString(2, lista.getNomeUtente());
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
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


	//Metodo per caricare nuovi contenuti nella lista
	@Override
	public boolean updateLista(Lista lista, String id) {
		//Controllo prima se ho inserito un contenuto per un utente nella stessa lista
		String query = "select * from contiene where nome_utente = ? and nome_lista = ? and id_contenuto = ?";
		
		try {
			PreparedStatement st;
			st = conn.prepareStatement(query);
			
			st.setString(1, lista.getNomeUtente());
			st.setString(2, lista.getNome());
			st.setString(3, id);
			
			ResultSet res = st.executeQuery(); 
			if (res.next()) { return false; }
			
			query = "insert into contiene values (?,?,?)";
			
			st = conn.prepareStatement(query);
			st.setString(1, lista.getNome());
			st.setString(2, lista.getNomeUtente());
			st.setString(3, id);
			
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return true;
	}


	@Override
	public List<String> getContents(String listname, String username) {
		List<String> contents = new ArrayList<String>();
		
		String query = "select * from contiene where nome_lista = ? and nome_utente = ?";
	
		try {
			PreparedStatement st;
			st = conn.prepareStatement(query);
			st.setString(1, listname);
			st.setString(2, username);
			ResultSet res = st.executeQuery(); 
			
			while(res.next()) { contents.add(res.getString("id_contenuto")); }
		} catch (SQLException e) { e.printStackTrace(); }
		
		return contents;
	}


	@Override
	public void deleteContent(Lista lista, String id) {
		String query = "delete from contiene where nome_lista = ? and nome_utente = ? and id_contenuto = ?";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, lista.getNome());
			st.setString(2, lista.getNomeUtente());
			st.setString(3, id);
		
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
	}

}
