package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imbmgdb.model.Movie;
import com.imbmgdb.model.SearchResults;

@RestController
public class ResultsRestController {
	
	@PostMapping("/calculateResults")
	public void calculateResults(HttpServletRequest red, HttpServletResponse res, @RequestBody Movie movie) {
		SearchResults.getInstance().addResultMovie(movie);
	}
	
	@PostMapping("/sendResults")
	public void sendResults(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(true);
		List<Movie> resultsMovie = SearchResults.getInstance().getResultsMovie();
			
		session.setAttribute("resultsMovie", resultsMovie);
	}
}
