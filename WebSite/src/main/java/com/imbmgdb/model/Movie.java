package com.imbmgdb.model;

public class Movie {
	private String id;
	private String title;
	private String year; 
	private String plot;
	private String image;
	private String director;
	
	Movie(String id, String title, String year, String plot/*, String image, String director*/){
		this.id = id;
		this.title = title;
		this.year = year;
		this.plot = plot;
		/*
		this.image = image;
		this.director = director;
		*/
	}
	
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getPlot() {
		return plot;
	}

	public String getImage() {
		return image;
	}

	public String getDirector() {
		return director;
	}
	
}
