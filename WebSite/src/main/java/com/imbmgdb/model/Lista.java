package com.imbmgdb.model;


import java.util.ArrayList;
import java.util.Objects;

public class Lista {
	
	private String nome;
	private String nomeUtente;
	private ArrayList<String> contenuti;

	public Lista(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getContenuti() {
		return contenuti;
	}

	public void setContenuti(ArrayList<String> contenuti) {
		this.contenuti = contenuti;
	}
	
	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lista other = (Lista) obj;
		return Objects.equals(nome, other.nome);
	}

	

	


	
}
