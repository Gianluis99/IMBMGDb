window.onload = function () {
	loadnewrMovies();
}


function loadNewMovies() {
	
	$.get("https://api.themoviedb.org/3/movie/popular?api_key=3c080aad495fd1f1b4eb93dd3dde7ab3&language=en-US&page=1", "" , function(response){
		var count = Object.keys(response.results).length;
			
		for(let i = 0; i < count; i++){
			addInSliderNewMovies(response.results[i].poster_path);
			console.log(response.results[i].id);		
		}
	
	});
	
}

function addInSliderNewMovies(link) {
	const IMG = "https://image.tmdb.org/t/p/w500";
	var slide = document.getElementById("mostPopularMovies");
	
	
	slide.innerHTML += "<div class=" + "'swiper-slide'" + ">"+
					   "<a class = 'link' href = 'https://stackoverflow.com/questions/44574072/set-active-slide-in-modal-click-on-swiper-slider'>"+
					   "<img class='poster' src= " + IMG + link + ">" + 
					   "<a>"+
					   "</div>";
	swiper.update();
}
