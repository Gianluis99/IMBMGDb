window.addEventListener("load", function() {
	doReview();

});


function doReview() {
	var btn = document.querySelector("#subReviewBtn");
	var username = document.querySelector("#usernameReview");
	var boxMyReview = document.querySelector("#myReviewBox");
	var boxMyAllReview = document.querySelector("#myReviewAllBox");
	var numReview=document.querySelector("#numReview");

	console.log(numReview.innerHTML);
	
	btn.addEventListener("click", function() {
		var radios = document.querySelectorAll('input[type="radio"]:checked');
		var text = document.querySelector("#myReviewBoxTextArea");

		var textReview = text.value;
		var user = username.innerHTML;
		console.log(radios.length);

		var urlString = window.location.href;
		var url = new URL(urlString);
		var idContent = url.searchParams.get("id");
		console.log(idContent);



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

		if (document.getElementById('star-5').checked)
			vote = 5;

		else if (document.getElementById('star-4').checked)
			vote = 4;

		else if (document.getElementById('star-3').checked)
			vote = 3;

		else if (document.getElementById('star-2').checked)
			vote = 2;

		else if (document.getElementById('star-1').checked)
			vote = 1;

		console.log(vote);

		var recensione = new Recensione(user, textReview, vote, idContent);

		$.ajax({
			type: "POST",
			url: "/addReview",
			contentType: "application/json",
			data: JSON.stringify(recensione),
			success: function(risposta) {
				//status = 200
				$('#numReview').html(parseInt($('#numReview').html(), 10)+1)
				
				boxMyReview.style.display = "none";
				
			if(vote==1){
				$(boxMyAllReview).append(`
				<div class="reviewBox">
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star "></span> 
					<span class="fa fa-star "></span>
					<span class="fa fa-star "></span> 
					<span class="fa fa-star "></span>
		
					<div class="usernameReview">
						<i class="fas fa-user fa-sm"></i> `+user+`
					</div>
					<p class="textReview">`+textReview+`</p>
				</div>

				`)

			}
			
				else if(vote==2){
				$(boxMyAllReview).append(`
				<div class="reviewBox">
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star "></span>
					<span class="fa fa-star "></span> 
					<span class="fa fa-star "></span>
		
					<div class="usernameReview">
						<i class="fas fa-user fa-sm"></i> `+user+`
					</div>
					<p class="textReview">`+textReview+`</p>
				</div>

				`)

			}
			
			
				else if(vote==3){
				$(boxMyAllReview).append(`
				<div class="reviewBox">
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star "></span> 
					<span class="fa fa-star "></span>
		
					<div class="usernameReview">
						<i class="fas fa-user fa-sm"></i> `+user+`
					</div>
					<p class="textReview">`+textReview+`</p>
				</div>

				`)

			}
			
			
				else if(vote==4){
				$(boxMyAllReview).append(`
				<div class="reviewBox">
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star "></span>
		
					<div class="usernameReview">
						<i class="fas fa-user fa-sm"></i> `+user+`
					</div>
					<p class="textReview">`+textReview+`</p>
				</div>

				`)

			}
			
			
				else if(vote==5){
				$(boxMyAllReview).append(`
				<div class="reviewBox">
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span>
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span>
		
					<div class="usernameReview">
						<i class="fas fa-user fa-sm"></i> `+user+`
					</div>
					<p class="textReview">`+textReview+`</p>
				</div>

				`)

			}

			}
		});


	});

}