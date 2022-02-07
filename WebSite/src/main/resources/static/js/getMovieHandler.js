
window.addEventListener("load", function() {

	getMovieNewReleases();
	getMovieTop();

});



function getMovieNewReleases() {
	var container = document.querySelector("#filmContainer");


	const KEY = "ad6f11886b4ff2413c3f2b47f875e24a";
	const URL = "https://api.themoviedb.org/3/movie/upcoming?api_key=";
	const QUERY = "&language=en-US&page=1";
	const IMG = "https://image.tmdb.org/t/p/w500";

	var allUrl = URL + KEY + QUERY;

	console.log(allUrl);

	$(document).ready(function() {

		$.getJSON(allUrl, function(res) {

			$.each(res.results, function(i, item) {

				$(container).append(`
				<div id="movieItem" class="movie">
					<a href="movie_?id=`+ item.id +`"> <img id="imgMovie" class="img"
					src="`+ IMG + item.poster_path + `">
					</a>
					

				</div>	
				`)

			});

		});
	})

}


function getMovieTop() {
	var container = document.querySelector("#filmContainerTop");


	const KEY = "ad6f11886b4ff2413c3f2b47f875e24a";
	const URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=";
	const QUERY = "&language=en-US&page=1";
	const IMG = "https://image.tmdb.org/t/p/w500";

	var allUrl = URL + KEY + QUERY;

	console.log(allUrl);

	$(document).ready(function() {

		$.getJSON(allUrl, function(res) {

			$.each(res.results, function(i, item) {

				$(container).append(`
				<div id="movieItem" class="movie">
					<a href="movie_?id=`+ item.id +`"> <img id="imgMovie" class="img"
					src="`+ IMG + item.poster_path + `">
					</a>
					

				</div>	
				`)

			});

		});
	})

}

