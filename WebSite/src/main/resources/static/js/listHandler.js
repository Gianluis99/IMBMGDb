
//Carica tutte le liste dell'utente quando la pagina viene aperta
function loadLists(username){
	user = username;
	$.ajax({
		type: "GET",
		url: "/getLists_"+username,
		success: function (response) {
			var count = Object.keys(response).length;
			for(let i = 0; i < count; i++){
				showList(response[i]);
			}
		}
	});
}

var user;
var list; //La lista con cui lavoro 
var isSelected = false; //Per capire se ho selezionato una lista

var previousSelected; //La lista selezionata precedentemente
var currentSelected; //La lista selezionata attualmente

/*Quando seleziono un elemento, questo deve cambiare colore*/
function listClick(selected){
	currentSelected = selected;
	list = document.getElementById(currentSelected);
	
	resetListContainer();
	loadContents();
	
	if(previousSelected != currentSelected){			//Caso in cui sto selezionando un elemento diverso da quello precedente
		list.style.backgroundColor = "#B4FBF8";
		isSelected = true;
		previousSelected = currentSelected;
	}
	else if(isSelected == false){                       //Caso in cui seleziono un elemento
		list.style.backgroundColor = "#B4FBF8";
		isSelected = true;
	}
	else{
		list.style.backgroundColor = "#02908B";         //Caso in cui deseleziono un elemento
		isSelected = false;
		previousSelected = currentSelected;
	}
}

/*Ogni volta che seleziono un elemento diverso dal precedente devo settare il collore delle altre liste*/
function resetListContainer(){
	var container = document.getElementById("listContainer");
	const nodeList = container.querySelectorAll(".containerItem");
	
	for (let i = 0; i < nodeList.length; i++) {
	  nodeList[i].style.backgroundColor = "#02908B";
	}
}

/*Per aggiungere una lista mi prendo il contenitore che le contiene e poi inserisco una nuova lista*/
function addList(username){
	var name = prompt("Insert list name: ");
	
	if(username != null){
		if(name != null && name != ""){
			$.ajax({
				type: "POST",
				url: "/addList_" + username + "_" + name
			});
			
			showList(name);
		}
	}
}

/*Si occupa di mostrare nel contenitore delle liste la lista passata come parametro*/
function showList(name){
	var container = document.getElementById("listContainer");
	container.innerHTML += "<a class = 'containerItem' id = '" + name + "' onclick = " + "listClick('" + name + "')" + ">" + name + "</a>";
}

/*Per eliminare una lista mi prendo l'ultima lista selezionata e la rimuovo */
function deleteList(username){
	$.ajax({
		type: "POST",
		url: "/deleteList_" + username + "_" + currentSelected
	});
	var toDelete = document.getElementById(currentSelected);
    toDelete.remove(); 
}

//Per aggiungere un contenuto nella lista
function addContent(username, id){
	var listname = prompt("insert list: ");
	console.log(listname);
	if(listname != "" && listname != null){
		$.ajax({
			type: "POST",
			url: "/addInList_"+username + "_" + listname + "_" + id,
		});
	}
}

//Per eliminare elementi
function deleteContent(username, id){
	var listname = prompt("insert list: ");
	
	if(listname != "" && listname != null){
		$.ajax({
			type: "POST",
			url: "/deleteFromList_"+username + "_" + listname + "_" + id,
		});
	}
}

//Per caricare tutti i contenuti inerenti ad una lista quando una lista viene selezionata
function loadContents(){
	resetContentContainer1();
	
	$.ajax({
		type: "GET",
		url: "/getContents_" + user + "_" + currentSelected,
		success: function (lists) {
			var count = Object.keys(lists).length;
			for(let i = 0; i < count; i++){
				$.get(" https://api.themoviedb.org/3/movie/" + lists[i] + "?api_key=3c080aad495fd1f1b4eb93dd3dde7ab3&language=en-US", "" , function(response){
					showContent(lists[i], response.title);
				});
			}
		}
	});
}

//Quando seleziono un'altra lista i contenuti devono cambiare
function resetContentContainer1(){
	document.getElementById("contentContainer").innerHTML = '';
}

//Per mostrare il contenuto nella lista
function showContent(id, name){
	var container = document.getElementById("contentContainer");
	//container.innerHTML += "<a class = 'containerItem' id = '" + id + "' onclick = " + "contentClick()" + ">" + name + "</a>";

	container.innerHTML += "<a class = 'containerItem' id = '" + id + "'" +
	                        "href = " + "'movie_?id=" + id + "'" + name + "'"  + ">" + name + "</a>";
}





