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
public class AdminRest {

	@PostMapping("/assignRole")
	public String doAssignRole(@RequestBody Utente utente, HttpServletResponse resp) {

		Utente now = Database.getInstance().getUtenteDao().getUserByUsername(utente.getUsername());
		// se l'utente è gia amministratore non possiamo rimuoverlo
		if (now.getTipo() == TipoUtente.AMMINISTRATORE) {
			resp.setStatus(500);
			return Messages.ERROR_CANNOT_REMOVE_ADMIN;
		}

		String result = Database.getInstance().getUtenteDao().assignRoleToUser(utente.getUsername(), utente.getTipo());

		if (!result.equals(Messages.SUCCESS))
			resp.setStatus(500);

		return result;
	}

	@PostMapping("/banOrUnbanUser")
	public String doBanOrUnbanUser(@RequestBody Utente utente, HttpServletResponse res, HttpServletRequest req) {

		Utente now = Database.getInstance().getUtenteDao().getUserByUsername(utente.getUsername());

		// non si puo bannare un amministratore
		if (now.getTipo() == TipoUtente.AMMINISTRATORE) {
			res.setStatus(500);
			return Messages.ERROR_CANNOT_BAN_ADMIN;
		}

		HttpSession session = req.getSession(false);
		String thisUsername = (String) session.getAttribute("username");
		System.out.println(thisUsername);

		Utente you = Database.getInstance().getUtenteDao().getUserByUsername(thisUsername);

		// un moderatore non puo bannare un'altro moderatore
		if (now.getTipo() == TipoUtente.MODERATATORE && you.getTipo() == TipoUtente.MODERATATORE) {
			res.setStatus(500);
			return Messages.ERROR_CANNOT_BAN_MODERATOR;
		}

		String result = Database.getInstance().getUtenteDao().banOrUnbanUser(utente.getUsername(),
				utente.isAbilitato());
		if (!result.equals(Messages.SUCCESS))
			res.setStatus(500);

		return result;
	}
}
