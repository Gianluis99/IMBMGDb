package com.example.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.imbmgdb.model.Contenuto;
import com.imbmgdb.model.TipoContenuto;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

@Controller
public class ContentController {

	@GetMapping("/movie_{contentName}")
	public String handContentMovie(@PathVariable String contentName, @RequestParam String id, HttpServletRequest req) {
		req.setAttribute("contentName", contentName);

		req.setAttribute("contentMovie", getContenutoFromAPi(id));
		Contenuto c = getContenutoFromAPi(id);
		return "contentPage";
	}
	
	
	

	// prendo il contenuto tramite api
	private Contenuto getContenutoFromAPi(String id) {
		String URL = "https://api.themoviedb.org/3/movie/";
		String KEY = "?api_key=ad6f11886b4ff2413c3f2b47f875e24a";
		String allUrl = URL + id + KEY;
		String IMG = "https://image.tmdb.org/t/p/w500";

		System.out.println(allUrl);

		Contenuto contenuto = new Contenuto();

		java.net.URL urll;
		try {
			urll = new URL(allUrl);
			JSONTokener tokener = new JSONTokener(urll.openStream());
			JSONObject obj = new JSONObject(tokener);

			contenuto.setTitolo(obj.getString("title"));
			contenuto.setUrlImg(IMG + obj.getString("poster_path"));
			contenuto.setDescrizione(obj.getString("overview"));
			contenuto.setData(obj.getString("release_date"));
			contenuto.setTitolo(obj.getString("title"));
			contenuto.setTipoContenuto(TipoContenuto.MOVIE);
			contenuto.setVoto(obj.getDouble("vote_average"));
			contenuto.setDurata(obj.getInt("runtime"));
			//System.out.println(obj.getInt("popularity"));

			JSONArray arr = obj.getJSONArray("genres");
			ArrayList<String> genres = new ArrayList<String>();
			for (int i = 0; i < arr.length(); i++) {
				String genre = arr.getJSONObject(i).getString("name");
				genres.add(genre);
			}
			contenuto.setCategorie(genres);

			arr = obj.getJSONArray("production_companies");
			String nameP = null;
			for (int i = 0; i < 1; i++) {
				nameP = arr.getJSONObject(i).getString("name");

			}
			contenuto.setProduttore(nameP);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contenuto;

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
