package com.imbmgdb.model;

import java.sql.Date;
import java.util.Objects;

public class Utente {

	
	private String username;
	private String password;
	private int tipo;
	private String email;
	private Date dataDiNascita;
	private boolean abilitato;
	
	
	public Utente() {
		
	}
	
	public Utente(String username, int tipo, boolean abilitato) {
		super();
		this.username = username;
		this.tipo = tipo;
		this.abilitato = abilitato;

	
	}
	
	public Utente(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.tipo=TipoUtente.BASE;
		this.abilitato=true;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public boolean isAbilitato() {
		return abilitato;
	}

	public void setAbilitato(boolean abilitato) {
		this.abilitato = abilitato;
	}

	

	
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(username, other.username);
	}


	
	
	

}
