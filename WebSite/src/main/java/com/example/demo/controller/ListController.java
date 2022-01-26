package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
	
	@GetMapping("/listPage")
	public String loginPage(HttpServletRequest req, HttpServletResponse res) {
		return "listPage";
	}

}
