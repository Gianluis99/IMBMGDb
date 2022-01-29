package com.imbmgdb.persistenza.dao;


import com.imbmgdb.model.Contenuto;


public interface ContenutoDao {

	//trova un contenuto tramite id
	public Contenuto findByPrimaryKey(Long id);
	

	public boolean insertContenuto(Contenuto c);
	
	

}
