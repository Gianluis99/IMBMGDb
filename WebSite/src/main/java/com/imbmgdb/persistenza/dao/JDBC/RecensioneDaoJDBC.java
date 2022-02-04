package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imbmgdb.model.Recensione;
import com.imbmgdb.persistenza.dao.RecensioneDao;

public class RecensioneDaoJDBC implements RecensioneDao {

	private Connection conn;

	public RecensioneDaoJDBC(Connection con) {
		this.conn = con;
	}

	@Override
	public long saveOrUpdate(Recensione recensione) {
		if (recensione.getId() == 0) {// se la recensione non esiste viene fatto l'insert
			// INSERT
			try {
				recensione.setId(IdBrokerGeneric.getID(conn));// prendo id generico da sequences di dbeaver
				String query = "insert into recensione " + "values (?, ?, ?, ?, ?, ?)";
				PreparedStatement st = conn.prepareStatement(query);
				st.setLong(1, recensione.getId());
				st.setString(2, recensione.getTitolo());
				st.setString(3, recensione.getTesto());
				st.setInt(4, recensione.getVoto());
				st.setString(5, recensione.getNomeUtente());
				st.setLong(6, recensione.getIdContenuto());

				st.executeUpdate();
				return  recensione.getId();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			// UPDATE se recensione esiste
			try {
				String query = "update recensione " + "testo = ?, voto = ? " + "where id = ?";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, recensione.getTesto());
				st.setInt(2, recensione.getVoto());
				st.setLong(3, recensione.getId());

				st.executeUpdate();
				return recensione.getId();

			} catch (SQLException e) {

				e.printStackTrace();
				return 0;
			}
		}
	}

	@Override
	public List<Recensione> findAll(Long idContenuto) {
		ArrayList<Recensione> reviews = new ArrayList<Recensione>();
		String query = "SELECT * FROM recensione WHERE id_contenuto=?";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, idContenuto);
			st.executeQuery();
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Recensione recensione = new Recensione();
				recensione.setTesto(res.getString("testo"));
				recensione.setVoto(res.getInt("voto"));
				recensione.setNomeUtente(res.getString("nome_utente"));
				recensione.setIdContenuto(res.getLong("id_contenuto"));
				recensione.setId(res.getLong("id"));
				reviews.add(recensione);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return reviews;
	}

	@Override
	public Recensione findByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public boolean delete(Long id) {
		String query="DELETE FROM recensione WHERE id=?";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, id);

			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
		
	}

	
	
	@Override
	public Recensione findByUsername(Long contentId, String username) {
		Recensione recensione = null;
		String query = "SELECT * FROM recensione WHERE id_contenuto=? AND nome_utente=?";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, contentId);
			st.setString(2, username);

			st.executeQuery();
			ResultSet res = st.executeQuery();
			if (res.next()) {
				recensione=new Recensione();
				recensione.setTesto(res.getString("testo"));
				recensione.setVoto(res.getInt("voto"));
				recensione.setNomeUtente(res.getString("nome_utente"));
				recensione.setIdContenuto(res.getLong("id_contenuto"));
				recensione.setId(res.getLong("id"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return recensione;
	}

}
