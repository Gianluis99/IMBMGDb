package com.imbmgdb.persistenza.dao;

import java.util.ArrayList;

import com.imbmgdb.model.Utente;

public interface UtenteDao {

	public String insertNewUtente(Utente utente);

	public boolean delete(Utente u);
	
	public ArrayList<String> searchUser(String value);
	
	public String assignRoleToUser(String username, int tipo);
	
	public boolean searchByUsername(String  username);
	
	public ArrayList<Utente> getAllUsers( );
	public ArrayList<Utente> getAllUsersBanned( );
	public ArrayList<Utente> getAllUsersByType( int tipo );
	public Utente getUserByUsername( String username );
	
	public String banOrUnbanUser( String username,boolean ban );





	
}
