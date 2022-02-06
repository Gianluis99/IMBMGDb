var list; //La lista con cui lavoro 
var isSelected = false; //Per capire se ho selezionato una lista

var previousSelected; //La lista selezionata precedentemente
var currentSelected; //La lista selezionata attualmente

/*Quando seleziono un elemento, questo deve cambiare colore*/
function listClick(selected){
	currentSelected = selected;
	list = document.getElementById(currentSelected);
	reset();
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
function reset(){
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
				url: "/addList_"+username+"_"+name
			});
			
			var container = document.getElementById("listContainer");
			container.innerHTML += "<a class = 'containerItem' id = '" + name + "' onclick = " + "listClick('" + name + "')" + ">" + name + "</a>";
		}
	}
}

/*Per eliminare una lista mi prendo l'ultima lista selezionata e la rimuovo */
function deleteList(){
	var toDelete = document.getElementById(currentSelected);
    toDelete.remove(); 
}

