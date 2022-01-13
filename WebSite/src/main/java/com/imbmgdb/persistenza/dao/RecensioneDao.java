package com.imbmgdb.persistenza.dao;

import java.util.List;

import com.imbmgdb.model.Recensione;


public interface RecensioneDao {

	public List<Recensione> findAll(Long idContenuto);
	public Recensione findByPrimaryKey(Long id);
	public boolean saveOrUpdate(Recensione r,String nomeUtente,Long idContenuto);
	public void delete(Recensione r );
	
}
