package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CategoriesController {

	@GetMapping("/MoviePage")
	public String pageAdmin(HttpServletRequest req) {
		return "moviePage";
	}
}
