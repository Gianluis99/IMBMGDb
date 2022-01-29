package com.example.demo.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.imbmgdb.other.ContentFromAPi;


@Controller
public class ContentController {

	@GetMapping("/movie_{id}")
	public String handContentMovie(@PathVariable String id, HttpServletRequest req) {

		req.setAttribute("contentMovie", ContentFromAPi.getContenutoFromAPi(id));

		return "contentPage";
	}

	
	
	

	@GetMapping("/music_{contentName}")
	public String handContentMusic(@PathVariable String contentName, HttpServletRequest req) {
		System.out.println(contentName);
		req.setAttribute("contentName", contentName);

		return "contentPage";
	}

	@GetMapping("/book_{contentName}")
	public String handContentBook(@PathVariable String contentName, HttpServletRequest req) {
		System.out.println(contentName);
		req.setAttribute("contentName", contentName);

		return "contentPage";
	}

	@GetMapping("/game_{contentName}")
	public String handContentgame(@PathVariable String contentName, HttpServletRequest req) {
		System.out.println(contentName);
		req.setAttribute("contentName", contentName);

		return "contentPage";
	}

}
