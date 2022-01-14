package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/doLogin")
	public void doLogin(HttpServletRequest req, HttpServletResponse res, String username, String password) throws IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("username", username);
		
		if((username.equals("user1") || username.equals("user2")) && password.equals("pass1")) {
			res.sendRedirect("/");
		}
		else {
			res.sendRedirect("/loginPage");
		}
	}

}
