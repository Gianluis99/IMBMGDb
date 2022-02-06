package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Database;
import com.imbmgdb.model.TipoUtente;
import com.imbmgdb.model.Utente;
import com.imbmgdb.other.Messages;

@RestController
public class AdminRest
{

	@PostMapping("/assignRole")
	public String doAssignRole(@RequestBody Utente utente, HttpServletResponse resp)
	{

		//prende dal database, i dati dell'utente
		Utente now = Database.getInstance().getUtenteDao().getUserByUsername(utente.getUsername());
		
		//se l'utente è un amministratore
		if(now.getTipo() == TipoUtente.AMMINISTRATORE)
		{
			
			//comunica che non è possibile
			resp.setStatus(500);
			
			//restituisce il messaggio d'errore
			return Messages.ERROR_CANNOT_REMOVE_ADMIN;
			
		}
		//se l'utente è bannato
		if(!now.isAbilitato())
		{
			
			//comunica che non è possibile
			resp.setStatus(500);
			
			//restituisce il messaggio d'errore
			return Messages.ERROR_CANNOT_ASSIGN_BANNED;
			
		}
		
		//assegna il nuovo tipo, all'utente
		String result = Database.getInstance().getUtenteDao().assignRoleToUser(utente.getUsername(), utente.getTipo());

		//se l'update fallisce
		if(!result.equals(Messages.SUCCESS))
		{
			
			//comunica un errore da parte del server
			resp.setStatus(500);
			
		}

		//restituisce il messaggio contenente il risultato dell'update
		return result;
		
	}

	@PostMapping("/banOrUnbanUser")
	public String doBanOrUnbanUser(@RequestBody Utente utente, HttpServletResponse res, HttpServletRequest req)
	{

		//prende dal database, i dati dell'utente
		Utente now = Database.getInstance().getUtenteDao().getUserByUsername(utente.getUsername());

		//se l'utente è un amministratore
		if(now.getTipo() == TipoUtente.AMMINISTRATORE)
		{
			
			//comunica che non è possibile
			res.setStatus(500);
			
			//restituisce il messaggio d'errore
			return Messages.ERROR_CANNOT_BAN_ADMIN;
			
		}

		//prende la sessione corrente
		HttpSession session = req.getSession(false);
		
		//prende il nome dell'utente, della sessione corrente
		String thisUsername = (String) session.getAttribute("username");
		
		System.out.println(thisUsername);

		//prende i dati dell'utente corrente, che sta cercando di bannare/sbannare
		Utente you = Database.getInstance().getUtenteDao().getUserByUsername(thisUsername);

		//se si è un moderatore, non si ha il diritto di bannare altri moderatori
		if(now.getTipo() == TipoUtente.MODERATATORE && you.getTipo() == TipoUtente.MODERATATORE)
		{
			
			//comunica che non è possibile
			res.setStatus(500);
			
			//restituisce il messaggio d'errore
			return Messages.ERROR_CANNOT_BAN_MODERATOR;
			
		}

		//assegna lo stato di bannato o non bannato, all'utente
		String result = Database.getInstance().getUtenteDao().banOrUnbanUser(utente.getUsername(), utente.isAbilitato());
		
		//se l'update fallisce
		if(!result.equals(Messages.SUCCESS))
		{

			//comunica un errore da parte del server
			res.setStatus(500);
			
		}

		//restituisce il messaggio contenente il risultato dell'update
		return result;
		
	}
}
