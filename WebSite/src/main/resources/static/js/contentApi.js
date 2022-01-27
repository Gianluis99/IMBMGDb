

window.addEventListener("load", function() {
	selectType();
});


function selectType() {

}


function getMovie() {
	const KEY = "ad6f11886b4ff2413c3f2b47f875e24a";
	const URL = "https://api.themoviedb.org/3";

	const URL_search = "/search/movie?api_key="
	const QUERY = "&query=";


	var allUrl = URL + URL_search + KEY + QUERY + value;

	$.getJSON(allUrl, function(res) {

		$.each(res, function(index, item) {

			console.log(item);

		});

	});
}