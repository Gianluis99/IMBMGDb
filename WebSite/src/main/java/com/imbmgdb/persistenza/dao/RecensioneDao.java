package com.imbmgdb.persistenza.dao;

import java.util.List;

import com.imbmgdb.model.Recensione;


public interface RecensioneDao {
	
	public List<Recensione> findAllOfAUser(String username);
	public boolean updateUsername(Recensione recensione);

	//dato un contenuto restituisce tutte le recensioni
	public List<Recensione> findAll(Long idContenuto);
	
	//dato una chiave restituisce una recensione
	public Recensione findByPrimaryKey(Long id);
	
	//inserisce o aggiorna una recensione
	public long saveOrUpdate(Recensione r);
	
	public Recensione findByUsername(Long contentId,String username);

	
	//elimina recensione
	public boolean delete(Long  id );
	
}
