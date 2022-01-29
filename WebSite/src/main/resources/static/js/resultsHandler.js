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

function loadResults(text){
	var title = text;
	
	$.get("https://api.themoviedb.org/3/search/movie?api_key=3c080aad495fd1f1b4eb93dd3dde7ab3&query=" + title, "" , function(response){
		var count = Object.keys(response.results).length;
		/*alert(count);*/
		for(let i = 0; i < count; i++){
			var id = response.results[i].id;
			var title = response.results[i].original_title;
			var year = response.results[i].release_date;
			var plot = response.results[i].overview;
			
			var movie = new Movie(id, title, year, plot);
			addContentInTable(movie);
			
		}
	});
}

function addContentInTable(movie){
	var tableElement = document.querySelector("#resultsTable tbody");
	var row = tableElement.insertRow(-1);
	row.setAttribute("id", movie.id);
	row.setAttribute("type", "submit");
	
	row.setAttribute("onclick", "showContent(" + movie.id + ")");
	row.innerHTML = "<td>" + movie.id + "</td>" +
					"<td>" + movie.title + "</td>" +
					"<td>" + movie.year + "</td>"+
				    "<td>" + movie.plot + "</td>" + 
					"<td>" + "<a onclick = '' class = 'view'> VIEW </a>" + "</td>";
}

/*
function showContent(id){
	$.get("contentPage", function(data){
  			load(data);
			alert
	});
*/


