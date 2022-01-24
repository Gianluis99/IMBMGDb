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
import com.imbmgdb.model.Utente;

@Controller
public class AdminController {

	@GetMapping("/adminPage")
	public String pageAdmin(HttpServletRequest req) {
		List<Utente> users = Database.getInstance().getUtenteDao().getAllUsers();
		if (req.getSession().getAttribute("username") != null) {
			req.setAttribute("usersList", users);
		}
		HttpSession session = req.getSession(false);

		int userType= (int) session.getAttribute("tipo");
		System.out.println(userType);
		
		if(userType==1 ||userType ==2)
			return "adminPage";
		else
			return "pageNotFound";
	}

	
	
	//ricerca nel db per autocomplite 
	//tramite jquery gli passo un term in modo tale posso ottenere tutti gli user presenti facendo like nel db

	@RequestMapping(value = "/searchUser")
	@ResponseBody  
	public List<String> searchUserInDB(
			@RequestParam(value = "term", required = false, defaultValue = "") String username) {

		List<String> usernames = Database.getInstance().getUtenteDao().searchUser(username);

		return usernames;
	}

}
