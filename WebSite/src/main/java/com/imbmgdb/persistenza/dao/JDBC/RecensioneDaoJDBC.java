package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.imbmgdb.model.Recensione;
import com.imbmgdb.persistenza.dao.RecensioneDao;

public class RecensioneDaoJDBC implements RecensioneDao {

	private Connection conn;

	public RecensioneDaoJDBC(Connection con) {
		this.conn = con;
	}


	@Override
	public boolean saveOrUpdate(Recensione recensione, String nomeUtente, Long idContenuto) {
		if (recensione.getId() == 0) {
			// INSERT
			try {
				recensione.setId(IdBrokerGeneric.getID(conn));
				String query = "insert into recensione " 
				+ "values (?, ?, ?, ?, ?, ?)";
				PreparedStatement st = conn.prepareStatement(query);
				st.setLong(1, recensione.getId());
				st.setString(2, recensione.getTitolo());
				st.setString(3, recensione.getTesto());
				st.setInt(4, recensione.getVoto());
				st.setString(5, nomeUtente);
				st.setLong(6, idContenuto);

				int res = 0;
				res = st.executeUpdate();
				return res == 1;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			// UPDATE
			try {
				String query = "update recensione " 
						+ "set titolo = ?, testo = ?, voto = ? " + "where id = ?";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, recensione.getTitolo());
				st.setString(2, recensione.getTesto());
				st.setInt(3, recensione.getVoto());
				st.setLong(4, recensione.getId());

				int res = 0;
				res = st.executeUpdate();
				return res == 1;

			} catch (SQLException e) {

				e.printStackTrace();
				return false;
			}
		}
	}

	
	
	@Override
	public List<Recensione> findAll(Long idContenuto) {
		return null;
	}

	@Override
	public Recensione findByPrimaryKey(Long id) {
		return null;
	}

	
	
	@Override
	public void delete(Recensione r) {

	}

}
