package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultsController {
	
	@PostMapping("/resultsPage")
	public String resultsPage(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(true);
		
		String title = req.getParameter("searchField");
		String rating  =  req.getParameter("rating");
		String content  =  req.getParameter("content");
		String release  =  req.getParameter("release");
		String startDate  =  req.getParameter("startDate");
		String endDate  =  req.getParameter("endDate");
		
		if(title != null && rating != null && content != null && release != null) {
	        session.setAttribute("title", title);
	        session.setAttribute("content", content);
	        session.setAttribute("release", release);
	        session.setAttribute("rating", rating);
	        session.setAttribute("startDate", startDate);
	        session.setAttribute("endDate", endDate);
		}
        
		return "resultsPage";
	}
	
}
