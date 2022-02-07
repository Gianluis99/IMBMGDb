package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Database;

@RestController
public class ListRest {
	
	//Lo metto nel rest perché mi restituisce una stringa
	@GetMapping("/getLists_{username}")
	public List<String> getLists(@PathVariable String username, HttpServletRequest req, HttpServletResponse res) {		
		List<String> lists = Database.getInstance().getListaDao().findByUser(username);
		
		return lists;
	}
	
	@GetMapping("/getContents_{username}_{listname}")
	public List<String> getContents(@PathVariable String username, @PathVariable String listname, HttpServletRequest req, HttpServletResponse res) {		
		List<String> contents = Database.getInstance().getListaDao().getContents(listname, username);
		
		return contents;
	}
}
