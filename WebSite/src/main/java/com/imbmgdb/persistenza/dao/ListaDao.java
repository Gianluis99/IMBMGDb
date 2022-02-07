package com.imbmgdb.persistenza.dao;

import java.util.List;

import com.imbmgdb.model.Lista;


public interface ListaDao {

	//trova tutte le liste di un utente
	public List<String> findByUser(String username);
	
	public List<String> getContents(String listname, String username);
	
	//inserisce una lista di un utente
	public boolean insertNewLista(Lista l);
	
	//aggiorna la lista
	public boolean updateLista(Lista lista, String id);
	
	public void deleteContent(Lista lista, String id);

	public void delete(Lista l);
}
