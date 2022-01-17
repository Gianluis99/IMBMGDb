package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.imbmgdb.persistenza.dao.CategoriaDao;
import com.imbmgdb.persistenza.dao.ContenutoDao;
import com.imbmgdb.persistenza.dao.ListaDao;
import com.imbmgdb.persistenza.dao.PollDao;
import com.imbmgdb.persistenza.dao.RecensioneDao;
import com.imbmgdb.persistenza.dao.UtenteDao;
import com.imbmgdb.persistenza.dao.JDBC.CategoriaDaoJDBC;
import com.imbmgdb.persistenza.dao.JDBC.ContenutoDaoJDBC;
import com.imbmgdb.persistenza.dao.JDBC.ListaDaoJDBC;
import com.imbmgdb.persistenza.dao.JDBC.PollDaoJDBC;
import com.imbmgdb.persistenza.dao.JDBC.RecensioneDaoJDBC;
import com.imbmgdb.persistenza.dao.JDBC.UtenteDaoJDBC;

public class Database {

	private static Database instance = null;
	private Connection conn;

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();

		return instance;
	}

	private Database() {
		try {											//link db creato		nomeUtente postgress    password
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imdb", "postgres", "VostraPassword");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public CategoriaDao getCategoriaDao() {
		return new CategoriaDaoJDBC(conn);
	}

	public ContenutoDao getContenutoDao() {
		return new ContenutoDaoJDBC(conn);
	}

	public ListaDao getListaDao() {
		return new ListaDaoJDBC(conn);
	}


	public RecensioneDao getRecensioneDao() {
		return new RecensioneDaoJDBC(conn);
	}
	
	public PollDao getPollDao() {
		return new PollDaoJDBC(conn);
	}
	
	public UtenteDao getUtenteDao() {
		return new UtenteDaoJDBC(conn);
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	
	

}
