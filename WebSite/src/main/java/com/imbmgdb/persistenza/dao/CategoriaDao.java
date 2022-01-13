package com.imbmgdb.persistenza.dao;


import com.imbmgdb.model.Categoria;

public interface CategoriaDao {

	
	public boolean save(Categoria c); //inserisce un nuova categoria

	public boolean delete(Categoria c);
}
