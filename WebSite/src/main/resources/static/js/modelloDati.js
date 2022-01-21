

function Contenuto(id, tipoContenuto, titolo, urlImg,
	descrizione, urlTraile, data, produttore, sviluppatore)  {
	this.id = id;
	this.tipoContenuto = tipoContenuto;
	this.titolo = titolo;
	this.urlImg = urlImg;
	this.descrizione = descrizione;
	this.urlTrailer = urlTrailer;
	this.data = data;
	this.produttore = produttore;
	this.sviluppatore = sviluppatore;

 
}


function Lista(nomeLista, nomeUtente) {
	this.nomeLista = nomeLista;
	this.nomeUtente = nomeUtente;

}

function Utente(userName, tipo, abilitato) {
	this.userName=userName;

	this.tipo=tipo;
	this.abilitato=abilitato;

}

function Recensione(id, titolo,testo,voto,nomeUtente,idContenuto) {
	this.id=id;
	this.titolo=titolo;
	this.testo=testo;
	this.voto=voto;
	this.nomeUtente=nomeUtente;
	this.idContnuto=idContenuto;

}


