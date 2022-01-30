package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imbmgdb.model.Recensione;

@RestController
public class ReviewRest {

	@PostMapping("/addReview")
	public String doReview(@RequestBody Recensione recensione,HttpServletResponse resp) {
		
		System.out.println("saasasas");
		System.out.println(recensione.getNomeUtente());
		return null;
	}
}
