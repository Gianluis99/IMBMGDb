package com.imbmgdb.persistenza.dao;

import java.util.ArrayList;

import com.imbmgdb.model.Categoria;
import com.imbmgdb.model.Contenuto;


public interface ContenutoDao {

	//trova un contenuto tramite id
	public Contenuto findByPrimaryKey(Long id);
	
	//trova un contenuto tramite name
	public Contenuto findByName(String name);	
	
	public boolean insertContenuto(Contenuto c);
	
	public void delete(Contenuto c);
	
	//dato la categoria e il tipo contenuto restituisce tutti i contenuti
	public ArrayList<Contenuto> findAllContenutiByCategoria(Categoria c,int tipoContenuto);
	
	//inserito un valore trova tutti i contenuti annessi
	public ArrayList<Contenuto> findAllBySearch(String value);


}
