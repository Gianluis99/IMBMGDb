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
		System.out.println("---");
		if(Database.getInstance().getListaDao().insertNewLista(list)) {
			System.out.println("ok");
		}
	}

}
