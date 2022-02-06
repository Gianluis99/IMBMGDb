package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Database;
import com.imbmgdb.model.TipoUtente;
import com.imbmgdb.model.Utente;

@Controller
public class AdminController
{

	@GetMapping("/adminPage")
	public String pageAdmin(HttpServletRequest req)
	{
		
		//prende la sessione corrente, dalla richiesta
		HttpSession session = req.getSession(false);
		
		//se la sessione esiste
		if(session != null)
		{
			
			//se la sessione attiva, contiene un username assegnato
			if(session.getAttribute("username") != null)
			{
				
				//prende il tipo di utente, dall'utente corrente della sessione
				int userType = (int) session.getAttribute("tipo");
				
				//se il tipo dell'utente, corrisponde a "Admin" o "Moderatore"
				if(userType == TipoUtente.AMMINISTRATORE || userType == TipoUtente.MODERATATORE)
				{
					
					//crea la lista degli utenti registrati al sito e la riempie tramite DAO
					List<Utente> users = Database.getInstance().getUtenteDao().getAllUsers();
					
					//assegna la lista di utenti ottenuta
					req.setAttribute("usersList", users);
					
					//riporta alla pagina jsp dell'admin (accessibile solo ad untenti di questo tipo o moderatori)
					return "adminPage";
					
				}
			
			}
			
		}
		
		//altrimenti, riporta alla "pagina non trovata"
		return "pageNotFound";
		
	}

	//ricerca nel db per autocomplite, tramite jquery si passa un term per ottenere tutti gli utenti presenti facendo like nel db
	@RequestMapping(value = "/searchUser")
	@ResponseBody  
	public List<String> searchUserInDB(@RequestParam(value = "term", required = false, defaultValue = "") String username)
	{

		//crea la lista dei nomi degli utenti registrati al sito e la riempie tramite DAO
		List<String> usernames = Database.getInstance().getUtenteDao().searchUser(username);

		//restituisce i nomi degli utenti
		return usernames;
		
	}

}
