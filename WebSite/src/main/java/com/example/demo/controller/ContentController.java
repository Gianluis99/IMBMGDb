package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Database;
import com.imbmgdb.model.Contenuto;
import com.imbmgdb.model.Recensione;
import com.imbmgdb.other.ContentFromAPi;

@Controller
public class ContentController {

	@GetMapping("/movie_")
	public String handContentMovie(@PathParam(value = "id") String id, HttpServletRequest req) {

		Contenuto contenuto = ContentFromAPi.getContenutoFromAPi(id);
		Long idL = Long.parseLong(id);
		
		List<Recensione>reviews=Database.getInstance().getRecensioneDao().findAll(idL);
		contenuto.setRecensioni(reviews);
		req.setAttribute("contentMovie", contenuto);

		HttpSession session = req.getSession(false);

		Recensione rece = null;
		if (session != null) {
			String username = session.getAttribute("username").toString();
			 rece = Database.getInstance().getRecensioneDao().findByUsername(idL, username);
		}
		req.setAttribute("userReview", rece);
		req.setAttribute("numReview", reviews.size());

		return "contentPage";
	}

	@GetMapping("/music_{contentName}")
	public String handContentMusic(@PathVariable String contentName, HttpServletRequest req) {
		System.out.println(contentName);
		req.setAttribute("contentName", contentName);

		return "contentPage";
	}

	@GetMapping("/book_{contentName}")
	public String handContentBook(@PathVariable String contentName, HttpServletRequest req) {
		System.out.println(contentName);
		req.setAttribute("contentName", contentName);

		return "contentPage";
	}

	@GetMapping("/game_{contentName}")
	public String handContentgame(@PathVariable String contentName, HttpServletRequest req) {
		System.out.println(contentName);
		req.setAttribute("contentName", contentName);

		return "contentPage";
	}

}
