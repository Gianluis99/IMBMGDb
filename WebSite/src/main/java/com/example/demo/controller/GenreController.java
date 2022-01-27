package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GenreController {

	@GetMapping("/GenrePage")
	public String pageAdmin(@RequestParam  int id,@RequestParam  String name,@RequestParam  String type, HttpServletRequest req) {

		req.setAttribute("genreId", id);
		req.setAttribute("genreName", name);
		req.setAttribute("typeContent", type);

		return "genrePage";
	}
}
