package com.imbmgdb.persistenza.dao;

import com.imbmgdb.model.Utente;

public interface UtenteDao {

	public String insertNewUtente(Utente utente);
	public String checkUser(Utente user);

	public boolean delete(Utente u);
}
