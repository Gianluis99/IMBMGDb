package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Database;
import com.imbmgdb.model.Utente;

@RestController
public class AdminRest {

	@PostMapping("/assignRole")
	public String doAssignRole(@RequestBody Utente utente,HttpServletResponse res) {
		String result= Database.getInstance().getUtenteDao().assignRoleToUser(utente.getUsername(), utente.getTipo());
		return result;
	}
}
