package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.imbmgdb.model.Contenuto;
import com.imbmgdb.persistenza.dao.ContenutoDao;

public class ContenutoDaoJDBC implements ContenutoDao {

	private Connection con;

	public ContenutoDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public boolean insertContenuto(Contenuto c) {
		String query = "insert into contenuto values (?,?,?,?,?,?,?,?,?)";
		try {
			c.setId(IdBrokerContenuto.getID(con)); //prendo l'id dalla sequences di dbeaver
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, c.getId());
			st.setString(2, c.getTitolo());
			st.setString(3, c.getDescrizione());
			st.setString(4, c.getData());
			st.setString(5, c.getProduttore());
			st.setString(6, c.getUrlImg());
			st.setInt(7, c.getTipoContenuto());
			st.setString(8, c.getSviluppatore());
			st.setString(9, c.getUrlTrailer());

			int res = 0;
			res = st.executeUpdate();
			
			return res > 0; //se il contenuto è stato inserito ritorna true

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

//TODO PROXY RECENSIONI e CATEGORIE
	@Override
	public Contenuto findByPrimaryKey(Long id) {
		Contenuto contenuto = null;

		String query = "select * from contenuto where id = ?";

		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);

			ResultSet res = st.executeQuery();
			if (res.next()) {
				contenuto = new Contenuto();
				contenuto.setId(res.getLong("id"));
				contenuto.setTitolo(res.getString("titolo"));
				contenuto.setDescrizione(res.getString("descrizione"));
				contenuto.setData(res.getString("data"));
				contenuto.setProduttore(res.getString("produttore"));
				contenuto.setUrlImg(res.getString("url_img"));
				contenuto.setUrlTrailer(res.getString("url_trailer"));
				contenuto.setSviluppatore(res.getString("sviluppatore"));
				contenuto.setTipoContenuto(res.getInt("tipologia_contenuto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contenuto;
	}

	

}
