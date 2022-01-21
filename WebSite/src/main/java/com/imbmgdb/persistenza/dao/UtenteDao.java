package com.imbmgdb.persistenza.dao;

import java.util.ArrayList;

import com.imbmgdb.model.Utente;

public interface UtenteDao {

	public String insertNewUtente(Utente utente);

	public boolean delete(Utente u);
	
	public ArrayList<String> searchUser(String value);
	
	public String assignRoleToUser(String username, int tipo);
	
	public boolean searchByUsername(String  username);

	
}
