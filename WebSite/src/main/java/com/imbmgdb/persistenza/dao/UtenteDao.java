package com.imbmgdb.persistenza.dao;

import com.imbmgdb.model.Utente;

public interface UtenteDao {

	public String insertNewUtente(Utente utente);

	public boolean delete(Utente u);
}
