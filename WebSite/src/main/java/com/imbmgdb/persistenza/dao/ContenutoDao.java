package com.imbmgdb.persistenza.dao;

import java.util.ArrayList;
import java.util.List;

import com.imbmgdb.model.Categoria;
import com.imbmgdb.model.Contenuto;


public interface ContenutoDao {

	public List<Contenuto> findAllByType(int tipoContenuto);	
	public Contenuto findByPrimaryKey(Long id);
	public Contenuto findByName(String name);
	public boolean insertContenuto(Contenuto c);
	public void delete(Contenuto c);
	public ArrayList<Contenuto> findAllContenutiByCategoria(Categoria c,int tipoContenuto);
	public ArrayList<Contenuto> findAllBySearch(String value);


}
