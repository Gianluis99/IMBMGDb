package com.imbmgdb.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class Contenuto{

	private long id;
	private int tipoContenuto;
	private String titolo;
	private String urlImg;
	private String descrizione;
	private String urlTrailer;
	private Date data;
	private String produttore;
	private String sviluppatore;
	
	private ArrayList<Recensione> recensioni;
	private ArrayList<Categoria> categorie;
	
	
	public Contenuto() {
		
	}


	public Contenuto(long id, String titolo, String urlImg,int tipoContenuto) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.urlImg = urlImg;
		this.setTipoContenuto(tipoContenuto);
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getUrlImg() {
		return urlImg;
	}


	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}


	public String getUrlTrailer() {
		return urlTrailer;
	}


	public void setUrlTrailer(String urlTrailer) {
		this.urlTrailer = urlTrailer;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getProduttore() {
		return produttore;
	}


	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}


	public String getSviluppatore() {
		return sviluppatore;
	}


	public void setSviluppatore(String sviluppatore) {
		this.sviluppatore = sviluppatore;
	}

	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	

	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}


	public void setRecensioni(ArrayList<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	public ArrayList<Categoria> getCategorie() {
		return categorie;
	}


	public void setCategorie(ArrayList<Categoria> categoria) {
		this.categorie = categoria;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	

	public int getTipoContenuto() {
		return tipoContenuto;
	}


	public void setTipoContenuto(int tipoContenuto) {
		this.tipoContenuto = tipoContenuto;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contenuto other = (Contenuto) obj;
		return id == other.id;
	}


	
	
	
	
	
	
	
	
}
