package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Database;
import com.imbmgdb.model.Lista;

@Controller
public class ListController {
	
	@GetMapping("/listPage")
	public String loginPage(HttpServletRequest req, HttpServletResponse res) {
		return "listPage";
	}
	
	@PostMapping("/addList_{username}_{listname}")
	public void addList(@PathVariable String username, @PathVariable String listname, HttpServletRequest req, HttpServletResponse res) {
		Lista list = new Lista(listname);
		list.setNomeUtente(username);
		
		if(Database.getInstance().getListaDao().insertNewLista(list)) {
			
		}
	}
	
	@PostMapping("/addInList_{username}_{listname}_{id}")
	public void addInList(@PathVariable String username, @PathVariable String listname, @PathVariable String id, HttpServletRequest req, HttpServletResponse res) {
		Lista list = new Lista(listname);
		list.setNomeUtente(username);
		
		if(Database.getInstance().getListaDao().updateLista(list, id)) {
			
		}
	}
	
	@PostMapping("/deleteList_{username}_{listname}")
	public void deleteList(@PathVariable String username, @PathVariable String listname, HttpServletRequest req, HttpServletResponse res) {
		Lista list = new Lista(listname);
		list.setNomeUtente(username);
		
		Database.getInstance().getListaDao().delete(list);
	}
	
	@PostMapping("/deleteFromList_{username}_{listname}_{id}")
	public void deleteFromList(@PathVariable String username, @PathVariable String listname, @PathVariable String id, HttpServletRequest req, HttpServletResponse res) {
		Lista list = new Lista(listname);
		list.setNomeUtente(username);
		
		Database.getInstance().getListaDao().deleteContent(list, id);
			
		
	}
	
}
