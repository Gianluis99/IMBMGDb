package com.example.demo.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Database;
import com.imbmgdb.model.TipoUtente;
import com.imbmgdb.model.Utente;
import com.imbmgdb.other.CheckString;
import com.imbmgdb.other.Messages;

@Controller
public class RegistrationController {

	
	
	@GetMapping("/registration")
	public String paginaLogin() {
		return "registrationPage";
	}
		
	
	
	
	@PostMapping("/registrationService")
	public String doRegistration(HttpServletResponse resp, HttpServletRequest req, String username, String email,
			String password, String rePassword) {
		
		
		HttpSession session= req.getSession(true);//creiamo la sessione
		String risposta = "registrationPage";
		session.setAttribute("error", null);
		session.setAttribute("username", username);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		session.setAttribute("password", rePassword);
		session.setAttribute("tipo", TipoUtente.BASE);




		
		if(!password.equals(rePassword)) { //controlliamo che le password siano uguali
			session.setAttribute("error", Messages.REGISTRATION_PASSWORDs_NOTVALID);
			return risposta;
		}
		if(!CheckString.checkPassword(password)) {//controlliamo che la password sia valida
			session.setAttribute("error", Messages.REGISTRATION_PASSWORD_NOTVALID);
			return risposta;

		}
			
		Utente utente=new Utente();
		utente.setUsername(username);
		utente.setEmail(email);
		utente.setPassword(password);
		String res=Database.getInstance().getUtenteDao().insertNewUtente(utente);
		
		if(!res.equals(Messages.SUCCESS)) {
			session.setAttribute("error", res);
			return risposta;
		}
		else {
			risposta="homePage";
		}
			 
		
		
		
		return risposta;
	}

}
