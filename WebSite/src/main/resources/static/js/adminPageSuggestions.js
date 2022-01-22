




window.addEventListener("load", function() {
	eventAutocomplite();
	assignRole();
	/*doBan();
	doUnBan();*/
	searchTable();
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
	var textMessagePopUp = document.querySelector("#message");
	var table = document.querySelector("#usersTable");

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

							textMessagePopUp.innerHTML = xhr.responseText;
							modal.style.display = "block";
						}

					});


				},
				cancel: function() {
					$.alert('Canceled!');
				}
			}
		});



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

/*
function doBan() {
	const btn = document.querySelector("#btnBan-gianni");


	btn.addEventListener("click", function() {
		$.confirm({
			title: 'Confirm!',
			content: 'Are you sure you want to ban this user?',
			buttons: {
				confirm: function() {
				var utente = new Utente("gianni", null, false);
					$.ajax({
						type: "POST",
						url: "/banOrUnbanUser",
						contentType: "application/json",
						data: JSON.stringify(utente),
						success: function(risposta) {
							console.log(risposta);
							$.alert(risposta);
						}

					});

				},
				cancel: function() {
					$.alert('Canceled!');
				},
				
			}
		});

	});
}

function doUnBan() {
	const btn = document.querySelector("#btnUnban-gigi1");


	btn.addEventListener("click", function() {
		$.confirm({
			title: 'Confirm!',
			content: 'Are you sure you want to Unban this user?',
			buttons: {
				confirm: function() {
				var utente = new Utente("gigi1", null, true);
					$.ajax({
						type: "POST",
						url: "/banOrUnbanUser",
						contentType: "application/json",
						data: JSON.stringify(utente),
						success: function(risposta) {
							console.log(risposta);
							$.alert(risposta);
						}

					});

				},
				cancel: function() {
					$.alert('Canceled!');
				},
				
			}
		});

	});
}

*/

function prova() {
	$(document).ready(function() {
		$('#usersTable tr').click(function(event) {
			var elID = $(this).attr('id');
			console.log(elID);
		});
	});
}


function searchTable() {


		$("#inputText2").on("keyup", function() {
			var value = $(this).val().toLowerCase();
			$("#usersTable tbody tr").filter(function() {
				$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			});
		});
	

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