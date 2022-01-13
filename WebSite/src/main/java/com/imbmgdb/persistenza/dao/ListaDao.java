package com.imbmgdb.persistenza.dao;

import java.util.List;

import com.imbmgdb.model.Lista;


public interface ListaDao {

	public List<Lista> findByUser(String username);
	public boolean insert(Lista l);
	public boolean update(Lista l);

	public void delete(Lista l);
}
