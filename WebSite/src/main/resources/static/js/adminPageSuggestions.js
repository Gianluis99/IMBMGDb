




window.addEventListener("load", function() {
	eventAutocomplite();
	assignRole();
});


function eventAutocomplite() {
	$(function() {
		$(".inputText").autocomplete({
			source: "/searchUser"
		});
	});
}


function assignRole() {

	const btn = document.querySelector("#btn1");
	var modal = document.getElementById("myModal");
	var span = document.getElementsByClassName("close")[0];
	var textMessagePopUp= document.querySelector("#message");

	btn.addEventListener("click", function() {
		const userType = document.querySelector("#userType1");
		const usernameText = document.querySelector("#inputText1");

		const type = userType.value;
		var username = usernameText.value;
		usernameText.value = "";
		var numtype;
		if (type === "Admin")
			numtype = 1;
		else
			numtype = 2;

		var utente = new Utente(username, numtype, true);
		$.ajax({
			type: "POST",
			url: "/assignRole",
			contentType: "application/json",
			data: JSON.stringify(utente),
			success: function(risposta) {
				console.log(risposta);
			textMessagePopUp.innerHTML=risposta;
			}


		});

		modal.style.display = "block";
		



	});

	span.onclick = function() {
		modal.style.display = "none";
	}

//quando si clicca sullo schermo il popup se ne va
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}

}