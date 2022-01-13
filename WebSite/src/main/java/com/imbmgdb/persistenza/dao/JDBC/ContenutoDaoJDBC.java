package com.imbmgdb.persistenza.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imbmgdb.model.Categoria;
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
			c.setId(IdBrokerContenuto.getID(con));
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, c.getId());
			st.setString(2, c.getTitolo());
			st.setString(3, c.getDescrizione());
			st.setDate(4, c.getData());
			st.setString(5, c.getProduttore());
			st.setString(6, c.getUrlImg());
			st.setInt(7, c.getTipoContenuto());
			st.setString(8, c.getSviluppatore());
			st.setString(9, c.getUrlTrailer());

			int res = 0;
			res = st.executeUpdate();
			
			return res == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

//TODO PROXY RECENSIONI
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
				contenuto.setData(res.getDate("data"));
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

	// TODO PROXY RECENSIONI
	@Override
	public Contenuto findByName(String name) {
		Contenuto contenuto = null;

		String query = "select * from contenuto where titolo = ?";

		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);

			ResultSet res = st.executeQuery();
			if (res.next()) {
				contenuto = new Contenuto();
				contenuto.setId(res.getLong("id"));
				contenuto.setTitolo(res.getString("titolo"));
				contenuto.setDescrizione(res.getString("descrizione"));
				contenuto.setData(res.getDate("data"));
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

	@Override
	public void delete(Contenuto c) {

	}

	@Override
	public ArrayList<Contenuto> findAllContenutiByCategoria(Categoria c, int tipoContenuto) {

		return null;
	}

	@Override
	public List<Contenuto> findAllByType(int tipoContenuto) {
		return null;
	}

	@Override
	public ArrayList<Contenuto> findAllBySearch(String value) {
		return null;
	}

}
