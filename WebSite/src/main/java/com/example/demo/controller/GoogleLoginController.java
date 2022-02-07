package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleLoginController {

	@PostMapping("/googleLogin")
	public String doGoogleLogin(@RequestBody String username, HttpServletResponse resp, HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("username", username);
		resp.sendRedirect("/loginPage");

		System.out.println(username);
		return null;
	}
}
