package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Database;
import com.imbmgdb.model.Utente;
import com.imbmgdb.other.Messages;

@Controller
public class LoginController {
	
	//Servlet per mostrare la pagina del login
	@GetMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	
	//Servlet per fare il login
	@PostMapping("/doLogin")
	public void doLogin(HttpServletRequest req, HttpServletResponse res, String username, String password) throws IOException {
		HttpSession session = req.getSession(true);
		
		Utente user = new Utente();
		user.setUserName(username);
		user.setPassword(password);
		
		String result = Database.getInstance().getUtenteDao().checkUser(user);
		
		if(result.equals(Messages.SUCCESS)) {
			session.setAttribute("username", username);
			res.sendRedirect("/");
		}
		else {
			res.sendRedirect("/loginPage");
		}
	}

}
