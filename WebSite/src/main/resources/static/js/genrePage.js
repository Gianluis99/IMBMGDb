
window.addEventListener("load", function() {

	getMovieByGenres();


});



function getMovieByGenres() {
	var container = document.querySelector("#filmContainer");


	const genre = document.querySelector("#genreId").title;
	console.log(genre);
	const KEY = "ad6f11886b4ff2413c3f2b47f875e24a";
	const URL = "https://api.themoviedb.org/3/discover/movie?api_key=";
	const QUERY = "&language=en-US&with_genres=";
	const IMG = "https://image.tmdb.org/t/p/w500";

	var allUrl = URL + KEY + QUERY + genre;

	console.log(allUrl);

	$(document).ready(function() {

		$.getJSON(allUrl, function(res) {

			$.each(res.results, function(i, item) {
				console.log(item);

				$(container).append(`
				<div class="movie">
					<a href="movie_`+ item.id +`"> <img id="imgMovie" class="img"
					src="`+ IMG + item.poster_path + `">
					</a>
					
					<div class="down">
						<a href="movie_`+ item.title + `?id=`+ item.id +`" class="title">` + item.title + `</a>
						<div class="divVoti">
						<img class="iconStar" src="immagini/starIcon.png">
						<p class="voti">`+ item.vote_average + ` Imdb</p>

						</div>
					</div>
				</div>	
				`)

			});

		});
	})

}




