package com.imbmgdb.persistenza.dao;

import java.util.List;

import com.imbmgdb.model.Recensione;


public interface RecensioneDao {

	//dato un contenuto restituisce tutte le recensioni
	public List<Recensione> findAll(Long idContenuto);
	
	//dato una chiave restituisce una recensione
	public Recensione findByPrimaryKey(Long id);
	
	//inserisce o aggiorna una recensione
	public boolean saveOrUpdate(Recensione r);
	public void delete(Recensione r );
	
}
