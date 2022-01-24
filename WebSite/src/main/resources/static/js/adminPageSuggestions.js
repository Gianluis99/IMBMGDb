




window.addEventListener("load", function() {
	eventAutocomplite();
	assignRole();
	searchTable();
	banUser();
});


function eventAutocomplite() {
	$(function() {
		$(".inputText").autocomplete({
			source: "/searchUser"
		});
	});
}


function assignRole() {

	const textType = document.querySelector("#typePage").textContent;
	console.log(textType);

	if (textType.includes("Admin")) {


		const btn = document.querySelector("#btn1");
		var modal = document.getElementById("myModal");
		var span = document.getElementsByClassName("close")[0];
		var textMessagePopUp = document.querySelector("#message");

		btn.addEventListener("click", function() {
			const userType = document.querySelector("#userType1");
			const usernameText = document.querySelector("#inputText1");

			const type = userType.value;
			var username = usernameText.value;
			usernameText.value = "";
			var numtype;

			var message;

			console.log(type);
			if (type === "Admin") {
				numtype = 1;
				message = 'Are you sure to make ' + username + ' ' + type + ' ?';

			}
			else if (type === "Moderator") {
				numtype = 2;
				message = 'Are you sure to make ' + username + ' ' + type + ' ?';
			}
			else if (type === "Remove") {
				numtype = 0;
				message = 'Are you sure to Remove ' + username + ' ?';

			}

			$.confirm({
				title: 'Confirm!',
				content: message,
				buttons: {
					confirm: function() {
						var utente = new Utente(username, numtype, true);
						
						$.ajax({
							type: "POST",
							url: "/assignRole",
							contentType: "application/json",
							data: JSON.stringify(utente),
							success: function(risposta) {
								console.log(risposta);
								textMessagePopUp.innerHTML = risposta;
								modal.style.display = "block";
								var userNameRow = document.querySelector("#row-" + username);
								var userRole = userNameRow.querySelector("#role-" + username);

								if (type === "Remove")
									userRole.innerHTML = "Basic";
								else
									userRole.innerHTML = type;

							},
							error: function(xhr) {
							//Se si verifica un errore si vedrà solamente il mesaggio
								textMessagePopUp.innerHTML = xhr.responseText;
								modal.style.display = "block";
							}

						});


					},
					cancel: function() {
					}
				}
			});



		});

		span.onclick = function() {
			modal.style.display = "none";
		}

		//quando si clicca sullo schermo il popup se ne va (alternativa a jquery)
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	}
}





function banUser() {

	//ci prendiamo tutti i button presenti che hanno come id il nome utente in modo tale
	//che sappiamo a quale utente ci stiamo riferendo
	var btns = document.querySelectorAll(".btnBan");


	btns.forEach(function(btn) {

		btn.addEventListener("click", function() {
			console.log(btn.id);

			$.confirm({
				title: 'Confirm!',
				content: 'Are you sure you want to ' + btn.textContent + ' ' + btn.id + '?',
				buttons: {
					confirm: function() {

						var valueBan;
						if (btn.textContent.includes("Ban")) {
							valueBan = false;

						}
						else
							valueBan = true;
						var username = btn.id;
						var utente = new Utente(username, null, valueBan);
						$.ajax({
							type: "POST",
							url: "/banOrUnbanUser",
							contentType: "application/json",
							data: JSON.stringify(utente),
							success: function(risposta) {
								console.log(risposta);
								$.alert(risposta);

								var isType = document.querySelector("#is-" + username);
								console.log(isType);

								if (valueBan) {//true quando voglio sbannare il bottone diventa rosso
									btn.style.background = "#e45601";
									btn.textContent = "Ban";
									isType.innerHTML = "";
								}
								else {//false quando voglio bannare quindi il bottone diventa blu
									btn.style.background = "#02908B";
									btn.textContent = "Unban";
									isType.innerHTML = "Banned";


								}


							},
							error: function(xhr) {

								console.log(xhr.responseText);
								$.alert({
									title: 'Error!',
									content: xhr.responseText,

								});

							}


						});

					},
					cancel: function() {
					},

				}
			});

		});



	});

}


function searchTable() {

	//ricerca dinamica tramite jquery nella tabella tramite un valore inserito in input text
	$("#inputText2").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#usersTable tbody tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});


	//oppure ricerca tramite filtro
	$("#userType2").change(function() {

		var value = $(this).val().toLowerCase();

		if (value == "all") {
			$("#usersTable tbody tr").filter(function() {
				$(this).toggle($(this).text().toLowerCase().indexOf(" ") > -1)
			});

		}
		else
			$("#usersTable tbody tr").filter(function() {
				$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			});
	});

}