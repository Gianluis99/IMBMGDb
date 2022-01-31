package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAreaController {
	@GetMapping("/myAreaPage")
	public String myAreaPage(HttpServletRequest req, HttpServletResponse res) {
		return "profilePage";
	}

}
