/*
function loadResults(text){
	var title = text;
	
	$.get("https://api.themoviedb.org/3/search/movie?api_key=3c080aad495fd1f1b4eb93dd3dde7ab3&query=" + title, "" , function(response){
		var count = Object.keys(response.results).length;
		alert(count);
		for(let i = 0; i < count; i++){
			var id = response.results[i].id;
			var title = response.results[i].original_title;
			var year = response.results[i].release_date;
			var plot = response.results[i].overview;
			
			var movie = new Movie(id, title, year, plot);
			
			$.ajax({
				type: "POST",
				url: "/calculateResults",
				contentType: "application/json",
				data: JSON.stringify(movie),
				success: function(res) {},
				error: function(xhr){ alert("FAIL"); }
			});
		}
	});
	alert("OK");
	$.ajax({
		type: "POST",
		url: "/sendResults",
		contentType: "application/json",
		success: function(res) {
				alert("OK");
		},
		error: function(xhr){
				alert("FAIL");
		}
	});
}
*/

function loadResults(title, content, release, rating, startDate, endDate){
	var title = title;
	var content = content;
	var release = release;
	var rating =  rating;
	var startDate = startDate;
	var endDate = endDate;
	
	console.log("title: " + title);
	console.log("content: " + content);
	console.log("release: " + release);
	console.log("rating: " + rating);
	console.log("start date: " + startDate);
	console.log("end date: " + endDate);
	
	$.get("https://api.themoviedb.org/3/search/movie?api_key=3c080aad495fd1f1b4eb93dd3dde7ab3&query=" + title, "" , function(response){
		var count = Object.keys(response.results).length;
		
		for(let i = 0; i < count; i++){
			var id = response.results[i].id;
			var title = response.results[i].original_title;
			var year = response.results[i].release_date;
			var plot = response.results[i].overview;
			var vote = response.results[i].vote_average;
			
			if(compareDate(year, startDate) && compareDate(endDate, year)){
				var today = new Date();
				if((release === "released" && compareDate(today, year) == true) || (release === "not released" && compareDate(today, year) == false) || (release === "all")){
					if(vote >= rating){
						var movie = new Movie(id, title, year, plot);
						addContentInTable(movie);
					}
				}
			}
				
		}
	});
}

function addContentInTable(movie){
	var tableElement = document.querySelector("#resultsTable tbody");
	var row = tableElement.insertRow(-1);
	row.setAttribute("id", movie.id);
	row.setAttribute("type", "submit");
	
	
	var v = "<a href=" + "'movie_" + movie.title + "?id="+ "'"+ movie.id + "'" + " class='view''> " + movie.title + "" + "</a>";
	
	
	row.setAttribute("onclick", "showContent(" + movie.id + ")");
	row.innerHTML = "<td>" + movie.id + "</td>" +
					"<td>" + movie.title + "</td>" +
					"<td>" + movie.year + "</td>"+
				    "<td>" + movie.plot + "</td>" + 
					"<td>" + v + "</td>";
}

function compareDate(data1, data2){
	var d1 = new Date(data1);
	var d2 = new Date(data2);
	
	var d1Y = d1.getFullYear()
	var d1M = d1.getMonth() + 1;
	var d1D = d1.getDate();
	
	var d2Y = d2.getFullYear()
	var d2M = d2.getMonth() + 1;
	var d2D = d2.getDate();

    
    if(d1Y != d2Y){ return d1Y > d2Y; }
    else if(d1M != d2M){ return d1M > d2M; }
	else if(d1D != d2D){ return d1D > d2D; }
	
	return true;
}


/*
function showContent(id){
	alert(id);
}
*/



