
window.addEventListener("load", function() {

getMovieByGenres();


});

function getMovieByGenres() {
	const genre = document.querySelector("#genreId").title;
	console.log(genre);
	const KEY = "ad6f11886b4ff2413c3f2b47f875e24a";
	const URL = "https://api.themoviedb.org/3/discover/movie?api_key=";
	const QUERY = "&language=en-US&with_genres=";
	var allUrl = URL + KEY + QUERY+ genre;

	console.log(allUrl);
	
	
	$.getJSON(allUrl, function(res) {

		$.each(res, function(i, item) {

			console.log(item);

		});

	});
}