
window.addEventListener("load", function() {

	getMovieByGenres();


});
/*

/*
https://api.themoviedb.org/3/discover/movie?api_key=
ad6f11886b4ff2413c3f2b47f875e24a&
language=en-US&sort_by=popularity.desc&with_genres=14&
with_watch_monetization_types=flatrate


*/



function getMovieByGenres() {
	var container = document.querySelector("#filmContainer");


	const genre = document.querySelector("#genreId").title;
	console.log(genre);
	const KEY = "ad6f11886b4ff2413c3f2b47f875e24a";
	const URL = "https://api.themoviedb.org/3/discover/movie?api_key=";
	const QUERY = "&language=en-US&with_genres=";
	var allUrl = URL + KEY + QUERY + genre;

	console.log(allUrl);

	$(document).ready(function() {

		$.getJSON(allUrl, function(res) {

			$.each(res.results, function(i, item) {
				console.log(item);

				/*
								var divItem = document.createElement("div");
									var aImg = document.createElement("a");
									   var imgMovie = document.createElement("img");
						
									var divDown = document.createElement("div");
									var aTitle = document.createElement("a");
									
									var divVoti = document.createElement("div");
									   var imgStar = document.createElement("img");
									   var pVoto = document.createElement("p");
						
				
				container.appendChild(a);
				*/
				
				$(container).append(`
				<div class="movie">
					<a href=""> <img id="imgMovie" class="img"
					src="url">
					</a>
					
					<div class="down">
						<a href="nome" class="title">`+item.title+` nome </a>
						<div class="divVoti">
						<img class="iconStar" src="immagini/starIcon.png">
						<p class="voti">7.7</p>

						</div>
					</div>
				</div>	
				`)
	
			});

		});
	})
}