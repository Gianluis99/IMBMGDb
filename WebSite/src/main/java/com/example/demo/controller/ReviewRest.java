package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Database;
import com.imbmgdb.model.Recensione;
import com.imbmgdb.other.Messages;

@RestController
public class ReviewRest {

	@PostMapping("/addReview")
	public String doReview(@RequestBody Recensione recensione, HttpServletResponse resp, HttpServletRequest req) {

		recensione.setId((long) 0);
		recensione.setTitolo("title"+recensione.getIdContenuto());
		long id=Database.getInstance().getRecensioneDao().saveOrUpdate(recensione);
			return Long.toString(id);
		
		
		

	}
	
	

	@PostMapping("/deleteReview")
	public String deleteReview(@RequestBody long id, HttpServletResponse resp, HttpServletRequest req) {

		
		
		if (Database.getInstance().getRecensioneDao().delete(id))
			return Messages.SUCCESS;
		else {
			return Messages.ERROR;
		}
		
		
	}

}
