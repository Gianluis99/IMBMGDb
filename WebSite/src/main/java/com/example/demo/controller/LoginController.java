package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping("/")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/")
	public String doLogin(HttpServletRequest req, HttpServletResponse res, String username, String password) throws IOException {
		if(username.equals("user1") && password.equals("pass1")) {
			res.sendRedirect("home");
		}
		
		return "login";
	}

}
