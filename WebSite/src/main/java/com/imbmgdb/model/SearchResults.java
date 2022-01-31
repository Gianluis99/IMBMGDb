package com.imbmgdb.model;

import java.util.ArrayList;
import java.util.List;

public class SearchResults {
	private static SearchResults instance = null;
	private static List<Movie> resultsMovie = new ArrayList<Movie>();
	
	public static SearchResults getInstance() {
		if (instance == null) {
			instance = new SearchResults();
		}
		return instance;
	}
	
	public void addResultMovie(Movie movie) {
		resultsMovie.add(movie);
	}
	
	private void setResultsMovie() {
		resultsMovie = null;
		resultsMovie = new ArrayList<Movie>();
	}
	
	public List<Movie> getResultsMovie(){
		List<Movie> results = new ArrayList<Movie>(resultsMovie);
		setResultsMovie();
		
		return results;
	}

}
