package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultsController {
	
	@PostMapping("/resultsPage")
	public String resultsPage(HttpServletRequest req, HttpServletResponse res, String searchField) {
		HttpSession session = req.getSession(true);
        session.setAttribute("text", searchField);
		return "resultsPage";
	}
	
}
