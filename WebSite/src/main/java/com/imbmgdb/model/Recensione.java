package com.imbmgdb.model;

import java.util.List;
import java.util.Objects;

public class Recensione {
	

	private Long id;
	private String titolo;
	private String testo;
	private int voto;
	private List<Utente> like;
	private List <Utente> dislike;
	private Long idContenuto;
	private String nomeUtente;

	
	public Recensione( String nomeUtente,String testo, int voto) {
		this.testo = testo;
		this.voto = voto;
		this.nomeUtente = nomeUtente;
	}
	
	public Recensione(Long id, String titolo,String testo, int voto, String nomeUtente) {
		super();
		this.id = id;
		this.testo = testo;
		this.voto = voto;
		this.nomeUtente = nomeUtente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public List<Utente> getLike() {
		return like;
	}

	public void setLike(List<Utente> like) {
		this.like = like;
	}

	public List<Utente> getDislike() {
		return dislike;
	}

	public void setDislike(List<Utente> dislike) {
		this.dislike = dislike;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String utente) {
		this.nomeUtente = utente;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Long getIdContenuto() {
		return idContenuto;
	}

	public void setIdContenuto(Long idRecensione) {
		this.idContenuto = idRecensione;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recensione other = (Recensione) obj;
		return Objects.equals(id, other.id);
	}

	
	

}
