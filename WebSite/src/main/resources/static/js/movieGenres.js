

window.addEventListener("load", function() {
	setGenres();
});


const genres = [
	{
		"id": 28,
		"name": "Action"
	},
	{
		"id": 12,
		"name": "Adventure"
	},
	{
		"id": 16,
		"name": "Animation"
	},
	{
		"id": 35,
		"name": "Comedy"
	},
	{
		"id": 80,
		"name": "Crime"
	},
	{
		"id": 99,
		"name": "Documentary"
	},
	{
		"id": 18,
		"name": "Drama"
	},
	{
		"id": 10751,
		"name": "Family"
	},
	{
		"id": 14,
		"name": "Fantasy"
	},
	{
		"id": 36,
		"name": "History"
	},
	{
		"id": 27,
		"name": "Horror"
	},
	{
		"id": 10402,
		"name": "Music"
	},
	{
		"id": 9648,
		"name": "Mystery"
	},
	{
		"id": 10749,
		"name": "Romance"
	},
	{
		"id": 878,
		"name": "Science Fiction"
	},
	{
		"id": 10770,
		"name": "TV Movie"
	},
	{
		"id": 53,
		"name": "Thriller"
	},
	{
		"id": 10752,
		"name": "War"
	},
	{
		"id": 37,
		"name": "Western"
	}
]


function setGenres() {
	var container = document.querySelector("#cat-container");
	console.log(container);


	genres.forEach(genre => {
		var a = document.createElement("a");
		a.classList.add("categorytext");
		a.id = genre.id;
		var linkText = document.createTextNode(genre.name);
		a.appendChild(linkText);
		a.href = "GenrePage?id="+a.id+"&name="+genre.name;

		container.appendChild(a);


	})


}



function moviePopolar() {
	const KEY = "ad6f11886b4ff2413c3f2b47f875e24a";
	const URL = "https://api.themoviedb.org/3";

	const URL_search = "/search/movie?api_key="
	const QUERY = "&query=";


	var allUrl = URL + URL_search + KEY + QUERY + value;

	$.getJSON(allUrl, function(res) {

		$.each(res, function(index, item) {

			console.log(item);
			//$("<p>").text().appendTo($("#resultBox"));

		});

	});
}