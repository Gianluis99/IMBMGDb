package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.example.demo.Database;
import com.imbmgdb.model.Recensione;
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
			st.setInt(6, 0);

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
	public boolean updateUserUsername(Utente user)
	{
		
		try
		{
			
			//salvo il vecchio nome utente
			String queryVecchioNome = "select * from utente where email = ?";
			PreparedStatement stmtVecchioNome = conn.prepareStatement(queryVecchioNome);
			stmtVecchioNome.setString(1, user.getEmail());
			
			//esegue la query
			ResultSet rsVecchioNome = stmtVecchioNome.executeQuery();
			rsVecchioNome.next();
			
			//salva il risultato
			String vecchioNomeUtente = rsVecchioNome.getString("nome_utente");
			
			//chiude
			rsVecchioNome.close();
			
			String query = "begin; " +
						   "with dummy as (" +
					   	   "update recensione set nome_utente = ? where nome_utente = ? )" +
						   "update utente set nome_utente = ? where email = ?; " +
						   "commit;";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, vecchioNomeUtente);
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getEmail());

			stmt.executeUpdate();
			stmt.close();
			
//			//prende tutte le recensioni dell'utente
//			List<Recensione> recensioni = Database.getInstance().getRecensioneDao().findAllOfAUser(user.getUsername());
//			
//			//aggiorna il nome utente, legato alle recensioni
//			for(Recensione rec : recensioni)
//			{
//				rec.setNomeUtente(user.getUsername());
//			}
//			
//			//aggiorna, le recensioni, nel database
//			for(Recensione rec : recensioni)
//			{
//				Database.getInstance().getRecensioneDao().updateUsername(rec);
//			}
			
			return true;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	@Override
	public boolean updateUserEmail(Utente user)
	{
		
		try
		{
			
			String query = "update utente set email = ? where nome_utente = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getUsername());
			
			stmt.executeUpdate();
			stmt.close();
			
			return true;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
		
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
			st.setString(1, user.getUsername());
			ResultSet rs = st.executeQuery();
			Boolean result = false;
			if (rs.next()) {
				String password = rs.getString("password");
				result = BCrypt.checkpw(user.getPassword(), password);
			}
			st.close();

			if (result) {
				return Messages.SUCCESS;
			} else {
				return Messages.LOGIN_GENERIC_ERROR;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Messages.ERROR;
	}

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
			return Messages.ERROR;

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

		String query = "UPDATE utente set abilitato = ? where nome_utente=? ";

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
			return Messages.ERROR;


		}
		return Messages.ERROR;
	}

}
