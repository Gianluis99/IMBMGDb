package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	//Servlet per andare nella home
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	
}
