window.onload = function () {
	const APIpopular = "https://api.themoviedb.org/3/movie/popular?api_key=3c080aad495fd1f1b4eb93dd3dde7ab3&language=en-US&page=1";
	const APInew = "https://api.themoviedb.org/3/movie/now_playing?api_key=3c080aad495fd1f1b4eb93dd3dde7ab3&language=en-US&page=1";
	const APIupcoming = "https://api.themoviedb.org/3/movie/upcoming?api_key=3c080aad495fd1f1b4eb93dd3dde7ab3&language=en-US&page=1";
	
	loadMovies(APIpopular, "mostPopularMovies");
	/*
	loadMovies(APInew, "newMovies");
	loadMovies(APIupcoming, "upcomingMovies");
	*/
}

function loadMovies(API, slider) {
	var posters = [];
	
	$.get(API, "" , function(response){
		var count = Object.keys(response.results).length;
			
		for(let i = 0; i < count; i++){
			posters[i] = response.results[i];
		}
		
		addInSliderMovies(posters, slider);
	});
	
}

function addInSliderMovies(posters, slider) {
	let result = "";
	const IMG = "https://image.tmdb.org/t/p/w500";
	
	/*
	"<a class = 'link' href = 'https://stackoverflow.com/questions/44574072/set-active-slide-in-modal-click-on-swiper-slider'>"
	*/
	
	posters.forEach(function (item) {
		result += "<div class='swiper-slide'>" +
				  "<a class = 'link' href = " + "'movie_" + item.id + "'" + ">"+
		          "<img class = 'poster' src="+ IMG + item.poster_path + ">" +
				  "</a>"+
 				  "</div>";
	});
	
	document.getElementById(slider).innerHTML = result;
	swiper.update();
}


