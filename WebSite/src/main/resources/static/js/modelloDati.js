
function Utente(username, tipo, abilitato) {
	this.username=username;

	this.tipo=tipo;
	this.abilitato=abilitato;

}

function Movie(id, title, year, plot){
	this.id = id;
	this.title = title;
	this.year = year; 
	this.plot = plot;
	/*
	this.image = image;
	this.director = director;
	*/
	
	this.getId = function(){
		return id;
	}
	
	this.getTitle = function(){
		return title;
	}
	
	this.getYear = function(){
		return year;
	}
	
	this.getPlot = function(){
		return plot;
	}
	
	/*
	this.getImage = function(){
		return image;
	}
	
	this.getDirector = function(){
		return director;
	}
	*/
}




