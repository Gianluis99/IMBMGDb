package com.imbmgdb.other;

import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.imbmgdb.model.Contenuto;
import com.imbmgdb.model.TipoContenuto;

public class ContentFromAPi {

	// prendo i dati del  contenuto tramite api utilizzando l'id
	public static Contenuto getContenutoFromAPi(String id) {
		String URL = "https://api.themoviedb.org/3/movie/";
		String KEY = "?api_key=ad6f11886b4ff2413c3f2b47f875e24a";
		String allUrl = URL + id + KEY;
		String IMG = "https://image.tmdb.org/t/p/w500";

		String URL_TRAILER = "/videos?api_key=ad6f11886b4ff2413c3f2b47f875e24a&language=en-US";
		String youtube_Trailer = "https://www.youtube.com/embed/";
		String allUrlTrailer = URL + id + URL_TRAILER;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(youtube_Trailer);

		Contenuto contenuto = new Contenuto();
		contenuto.setUrlTrailer(stringBuilder.toString());

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
			// System.out.println(obj.getInt("popularity"));

			JSONArray arr = obj.getJSONArray("genres");
			if (arr != null) {
				ArrayList<String> genres = new ArrayList<String>();
				for (int i = 0; i < arr.length(); i++) {
					String genre = arr.getJSONObject(i).getString("name");
					genres.add(genre);
				}
				contenuto.setCategorie(genres);
			}

			arr = obj.getJSONArray("production_companies");
			String nameP = null;
			if (arr != null)
				for (int i = 0; i < arr.length(); i++) {
					nameP = arr.getJSONObject(i).getString("name");

				}
			contenuto.setProduttore(nameP);

			urll = new URL(allUrlTrailer);
			tokener = new JSONTokener(urll.openStream());
			obj = new JSONObject(tokener);


			JSONArray array = obj.getJSONArray("results");
			String key_Trailer = null;
			if (array != null) {
				for (int i = 0; i < array.length(); i++) {
					key_Trailer = array.getJSONObject(i).getString("key");

				}
				stringBuilder.append(key_Trailer);
			}

			contenuto.setUrlTrailer(stringBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contenuto;

	}
	
}
