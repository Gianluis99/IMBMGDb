window.addEventListener("load", function() {
	doReview();

});


function doReview() {
	var btn = document.querySelector("#subReviewBtn");
	var username = document.querySelector("#usernameReview");

	btn.addEventListener("click", function() {
		var radios = document.querySelectorAll('input[type="radio"]:checked');
		var text = document.querySelector("#myReviewBoxTextArea");

		var textReview = text.value;
		var user = username.innerHTML;
		console.log(radios.length);

		var alert = document.querySelector("#errorBox");
		if (radios.length < 1) {

			$('#errorText').html('Insert almost one star!')

			if (window.getComputedStyle(alert).display === "none") {
				alert.style.display = "block";
			}

			return;
		}

		if (textReview.length < 30) {


			$('#errorText').html('Insert almost 30 characters!')

			if (window.getComputedStyle(alert).display === "none") {
				alert.style.display = "block";
			}

			return;
		}


		var vote;

		if(document.getElementById('star-5').checked)
			vote=5;

		else if (document.getElementById('star-4').checked)
			vote=4;
			
		else if (document.getElementById('star-3').checked)
			vote=3;
			
		else if (document.getElementById('star-2').checked)
			vote=2;
		
		else if (document.getElementById('star-1').checked)
			vote=1;
			
			console.log(vote);
			
			var recensione=new Recensione(user, textReview, vote);

		$.ajax({
			type: "POST",
			url: "/addReview",
			contentType: "application/json",
			data: JSON.stringify(recensione),
			success: function(risposta) {
				//status = 200
				console.log(risposta);
				


			},
			error: function(xhr) {
				console.log(xhr);
				
			}
		});


	});

}