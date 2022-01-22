package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			st.setString(1, utente.getUsername());

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
			st.setString(1, utente.getUsername());

			// password criptata con il sale per sicurezza
			st.setString(2, BCrypt.hashpw(utente.getPassword(), BCrypt.gensalt(13)));
			st.setString(3, utente.getEmail());
			st.setDate(4, utente.getDataDiNascita());

			st.setBoolean(5, true);
			st.setInt(6, 1);

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
	public ArrayList<String> searchUser(String value) {
		ArrayList<String> nomi = new ArrayList<String>();
		String query = "SELECT nome_utente FROM utente WHERE nome_utente LIKE  '%" + value + "%'";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.executeQuery();
			ResultSet res = st.executeQuery();
			while (res.next()) {
				nomi.add(res.getString("nome_utente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return nomi;
	}

	@Override
	public String assignRoleToUser(String username, int tipo) {

		if (!searchByUsername(username))
			return Messages.ERROR_USER_NOT_EXISTS;

		String query = "select tipologia_utente  from utente where nome_utente = ?";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);

			ResultSet res = st.executeQuery();
			if (res.next()) {
				int typeUs = res.getInt("tipologia_utente");
				if (typeUs == tipo)
					return Messages.ERROR_ROLE_EXISTS;
			}

			query = "UPDATE utente set tipologia_utente = ? where nome_utente=? ";

			st = conn.prepareStatement(query);
			st.setInt(1, tipo);
			st.setString(2, username);
			int result = 0;
			result = st.executeUpdate();

			if (result > 0)
				return Messages.SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return Messages.ERROR;
	}

	@Override
	public boolean searchByUsername(String username) {

		String query = "select * from utente where nome_utente = ?";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);

			ResultSet res = st.executeQuery();
			if (res.next())
				return true;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;

	}

	@Override
	public ArrayList<Utente> getAllUsers() {
		ArrayList<Utente> users = new ArrayList<Utente>();
		String query = "SELECT * FROM utente";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.executeQuery();
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Utente utente = new Utente();
				utente.setUsername(res.getString("nome_utente"));
				utente.setEmail(res.getString("email"));
				utente.setTipo(res.getInt("tipologia_utente"));
				utente.setAbilitato(res.getBoolean("abilitato"));
				users.add(utente);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return users;
	}

	@Override
	public ArrayList<Utente> getAllUsersBanned() {
		ArrayList<Utente> users = new ArrayList<Utente>();
		String query = "SELECT * FROM utente where abilitato = '0'";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.executeQuery();
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Utente utente = new Utente();
				utente.setUsername(res.getString("nome_utente"));
				utente.setEmail(res.getString("email"));
				utente.setTipo(res.getInt("tipologia_utente"));
				utente.setAbilitato(res.getBoolean("abilitato"));
				users.add(utente);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return users;
	}

	@Override
	public ArrayList<Utente> getAllUsersByType(int tipo) {
		ArrayList<Utente> users = new ArrayList<Utente>();
		String query = "SELECT * FROM utente WHERE tipologia_utente=?";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, tipo);
			st.executeQuery();
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Utente utente = new Utente();
				utente.setUsername(res.getString("nome_utente"));
				utente.setEmail(res.getString("email"));
				utente.setTipo(res.getInt("tipologia_utente"));
				utente.setAbilitato(res.getBoolean("abilitato"));
				users.add(utente);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return users;
	}

	@Override
	public Utente getUserByUsername(String username) {
		String query = "SELECT * FROM utente where nome_utente = ?";
		Utente utente = new Utente();

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			st.executeQuery();
			ResultSet res = st.executeQuery();
			while (res.next()) {
				utente = new Utente();
				utente.setUsername(res.getString("nome_utente"));
				utente.setEmail(res.getString("email"));
				utente.setTipo(res.getInt("tipologia_utente"));
				utente.setAbilitato(res.getBoolean("abilitato"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return utente;
	}

	@Override
	public String banOrUnbanUser(String username, boolean ban) {

		String 	query = "UPDATE utente set abilitato = ? where nome_utente=? ";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st = conn.prepareStatement(query);
			st.setBoolean(1, ban);
			st.setString(2, username);

			int result = 0;
			result = st.executeUpdate();

			if (result > 0)
				return Messages.SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return Messages.ERROR;
	}

}
