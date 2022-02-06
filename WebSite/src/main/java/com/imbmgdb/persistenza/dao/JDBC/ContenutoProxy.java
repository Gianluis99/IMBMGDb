package com.imbmgdb.persistenza.dao.JDBC;

import java.util.ArrayList;

import com.example.demo.Database;
import com.imbmgdb.model.Contenuto;
import com.imbmgdb.model.Recensione;

public class ContenutoProxy extends Contenuto {

	@Override
	public ArrayList<Recensione> getRecensioni() {
		if(super.getRecensioni() == null) {
			ArrayList<Recensione> reviews=(ArrayList<Recensione>) Database.getInstance().getRecensioneDao().findAll(getId());
			setRecensioni(reviews);
		}
		return super.getRecensioni();
	}
}
