package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.imbmgdb.model.Contenuto;

@Controller
public class HomeController {
	//Servlet per andare nella home. Ogni volta che si va nella home vengono settati 
	//gli attributi del req permettendo di passare alla jsp le liste calcolate per gli slider.
	@GetMapping("/")
	public String homePage(HttpServletRequest req, HttpServletResponse res) {
        req.setAttribute("mostPopularContents", mostPopularContents());
        req.setAttribute("newContents", newContents());
        req.setAttribute("comingSoonContents", comingSoonContents());
		return "home";
	}
	
	//Calcola i contenuti più popolari prelevandoli dal db e inserendoli in una lista.
	public List<Contenuto> mostPopularContents(){
		List<Contenuto> contents =  new ArrayList<Contenuto>(10);
		
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		
		return contents;
	}
	
	//Calcola i contenuti nuovi prelevandoli dal db e inserendoli in una lista.
	public List<Contenuto> newContents(){
		List<Contenuto> contents =  new ArrayList<Contenuto>(10);
		
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		
		return contents;
	}
	
	//Calcola i contenuti che stanno per uscire prelevandoli dal db e inserendoli in una lista.
	public List<Contenuto> comingSoonContents(){
		List<Contenuto> contents =  new ArrayList<Contenuto>(10);
		
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		contents.add(new Contenuto());
		
		return contents;
	}
}
