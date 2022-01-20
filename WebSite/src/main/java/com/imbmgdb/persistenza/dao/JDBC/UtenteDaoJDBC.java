package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.imbmgdb.model.Utente;
import com.imbmgdb.other.Messages;
import com.imbmgdb.persistenza.dao.UtenteDao;

public class UtenteDaoJDBC implements UtenteDao {

	private Connection conn;

	public UtenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public String insertNewUtente(Utente utente) {

		String query = "select * from utente where nome_utente = ?";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente.getUserName());

			ResultSet res = st.executeQuery(); // controlliamo prima se c'è un utente che ha associato l'username
												// inserito
			if (res.next())
				return Messages.ERROR_USER_EXISTS;

			query = "select * from utente where email = ?";
			st = conn.prepareStatement(query);
			st.setString(1, utente.getEmail());

			 res = st.executeQuery(); // controlliamo prima se c'è un utente che ha associato l'username
												// inserito
			if (res.next())
				return Messages.ERROR_EMAIL_EXISTS;

			query = "insert into utente values (?,?,?,?,?,?)";

			st = conn.prepareStatement(query);
			st.setString(1, utente.getUserName());
			
			//password criptata con il sale per sicurezza
			st.setString(2, BCrypt.hashpw(utente.getPassword(), BCrypt.gensalt(13)));
			st.setString(3, utente.getEmail());
			st.setDate(4, utente.getDataDiNascita());

			st.setBoolean(5, true);
			st.setInt(6, utente.getTipo());

			int result = 0;
			result = st.executeUpdate();
			st.close();

			if (result > 0)
				return Messages.SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return Messages.ERROR;

	}

	@Override
	public boolean delete(Utente u) {
		return false;
	}

	@Override
	public String checkUser(Utente user) {
		String query = "select * from utente where nome_utente = ?";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, user.getUserName());
			ResultSet rs = st.executeQuery();
			Boolean result = false;
			if(rs.next()) {
				String password = rs.getString("password");
				result = BCrypt.checkpw(user.getPassword(), password);
			}
			st.close();
			
			if(result) { return Messages.SUCCESS; }
			else { return Messages.LOGIN_GENERIC_ERROR; }
			
		} catch (SQLException e) { e.printStackTrace(); }
	
		return Messages.ERROR;
	}

}
