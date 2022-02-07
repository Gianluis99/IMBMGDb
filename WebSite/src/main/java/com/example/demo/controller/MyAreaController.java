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

@Controller
public class MyAreaController
{
	
	//porta alla pagina del profilo
	@GetMapping("/myAreaPage")
	public String myAreaPage(HttpServletRequest req, HttpServletResponse res)
	{
		
		//riporta alla pagina jsp del profilo
		return "profilePage";
		
	}
	
	//cambio nome utente
	@PostMapping("/changeUsername")
	public void changeUsername(HttpServletRequest req, HttpServletResponse res, String newUsername) throws IOException
	{
		
		//se il nome utente passato non è vuoto e non ha un numero inferiore a 3 di caratteri
		if(newUsername != null && !newUsername.isBlank() && newUsername.length() >= 3)
		{

			//prende la sessione corrente, dalla richiesta
			HttpSession session = req.getSession(false);
			
			//se la sessione esiste
			if(session != null)
			{
			
				//se la sessione attiva, contiene un username assegnato
				if(session.getAttribute("username") != null)
				{
					
					//prende il nome utente, dell'utente corrente della sessione
					String username = (String) session.getAttribute("username");
					
					//prende l'utente, della sessione corrente
					Utente user = Database.getInstance().getUtenteDao().getUserByUsername(username);
					
					//cambia il nome utente
					user.setUsername(newUsername);
					
					//aggiorna il database
					Database.getInstance().getUtenteDao().updateUserUsername(user);
					
					//cambia il nome utente salvato nella sessione
					session.setAttribute("username", newUsername);
				
				}
			
			}
			
		}
			
		//riporta alla pagina del profilo
		res.sendRedirect("/myAreaPage");
	
	}
	
	//cambio email
	@PostMapping("/changeEmail")
	public void changeEmail(HttpServletRequest req, HttpServletResponse res, String newEmail) throws IOException
	{
		
		//se la email passata non è vuota e non ha un numero inferiore a 3 di caratteri
		if(newEmail != null && !newEmail.isBlank() && newEmail.length() >= 3)
		{
			
			//prende la sessione corrente, dalla richiesta
			HttpSession session = req.getSession(false);
			
			//se la sessione esiste
			if(session != null)
			{
			
				//se la sessione attiva, contiene un username assegnato
				if(session.getAttribute("username") != null)
				{
					
					//prende il nome utente, dell'utente corrente della sessione
					String username = (String) session.getAttribute("username");
					
					//prende l'utente, della sessione corrente
					Utente user = Database.getInstance().getUtenteDao().getUserByUsername(username);
					
					//cambia la email
					user.setEmail(newEmail);
					
					//aggiorna il database
					Database.getInstance().getUtenteDao().updateUserEmail(user);
					
					//cambia la email salvata nella sessione
					session.setAttribute("email", newEmail);
				
				}
			
			}
			
		}
			
		//riporta alla pagina del profilo
		res.sendRedirect("/myAreaPage");
	
	}

}
