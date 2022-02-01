
<!DOCTYPE html>
<!-- includiamo JSTL -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--importiamo Jquery-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<html>

<head>

<title>${contentMovie.titolo}-IMBMGDb</title>

<meta charset="utf-8">

<link rel="stylesheet" href="css/commonCSS.css">
<link rel="stylesheet" href="css/contentCSS.css">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.1.1.min.js">
	
</script>

<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>

<c:if test="${username != null}">
	<script type="text/javascript" src="../js/reviewHandler.js"></script>
	<script type="text/javascript" src="../js/modelloDati.js"></script>
</c:if>

<link rel="stylesheet" href="css/reviewCSS.css">
<link rel="stylesheet" href="css/myReviewCSS.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

</head>

<body>

	<header> </header>


	<div class="titleBox"
		style="background-image: url('${contentMovie.urlBackImg}');">
		<h1 id="contentTitle">${contentMovie.titolo}</h1>

	</div>

	<div class="contentContainer">


		<div class="infoBox">

			<i class="fas fa-clock"></i>
			<p class="infoText">${contentMovie.durata}min</p>



			<i class="fas fa-star"></i>
			<p class="infoText">${contentMovie.voto}Imdb</p>



		</div>


		<div class="multimediaContainer">
			<img class="imgMultimedia" id="imgMultimedia"
				src="${contentMovie.urlImg}">
			<iframe class="videoMultimedia" id="videoMultimedia"
				src="${contentMovie.urlTrailer}"> </iframe>
		</div>



		<div class="categorieContainer">
			<c:forEach items="${contentMovie.categorie}" var="categoria">

				<p class="categoriatext">${categoria}</p>
			</c:forEach>
		</div>


		<br>
		<p>${contentMovie.descrizione}</p>

		<hr class=rounded>
		<h3>Release Date:</h3>
		<p>${contentMovie.data}</p>

		<hr class=rounded>

		<h3>Production_company:</h3>

		<p>${contentMovie.produttore}</p>


	</div>

	<div class="reviewsBox">
		<hr style="border: 1px solid #f1f1f1">

		<span> <span id="numReview">${numReview}</span> - Reviews <i class="fas fa-users"></i></span>


		<div id="myReviewAllBox">

			<c:if test="${username != null && userReview!=null}">
				<div class="reviewBox">

					<c:if test="${userReview.voto == 1}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
					</c:if>
					<c:if test="${userReview.voto == 2}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
					</c:if>
					<c:if test="${userReview.voto == 3}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
					</c:if>
					<c:if test="${userReview.voto == 4}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star "></span>
					</c:if>
					<c:if test="${userReview.voto == 5}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
					</c:if>

					<div class="usernameReview">
						<i class="fas fa-user fa-sm"></i> ${userReview.nomeUtente}
					</div>
					<p class="textReview">${userReview.testo}</p>
				</div>

			</c:if>


			<c:if test="${username == null}">
				<div class="blockDiv">
					<span> You must be logged to post a review! <a
						href="loginPage"> <i class="fas fa-sign-in-alt"></i>
					</a>
					</span>
				</div>
			</c:if>



			<c:if test="${username != null && userReview==null}">
				<div class="myReviewBox" id="myReviewBox">

					<div class="stars">
						<form class=form id="formStars">
							<input class="star star-5" id="star-5" type="radio" name="star" />
							<label class="star star-5" for="star-5"></label> <input
								class="star star-4" id="star-4" type="radio" name="star" /> <label
								class="star star-4" for="star-4"></label> <input
								class="star star-3" id="star-3" type="radio" name="star" /> <label
								class="star star-3" for="star-3"></label> <input
								class="star star-2" id="star-2" type="radio" name="star" /> <label
								class="star star-2" for="star-2"></label> <input
								class="star star-1" id="star-1" type="radio" name="star" /> <label
								class="star star-1" for="star-1"></label>
						</form>
					</div>
					<div class="usernameReview">
						<i class="fas fa-user fa-sm"></i>
						<p id="usernameReview">${username}</p>
					</div>

					<div class="reviewTextArea">
						<div class="row">
							<div class="col-75">
								<textarea placeholder="Write here your review..."
									class="myReviewBoxTextArea" id="myReviewBoxTextArea"
									style="height: 200px"></textarea>
							</div>
						</div>
						<div class="row">
							<button type="submit" value="Submit" class="subBtn"
								id="subReviewBtn">submit</button>
						</div>
					</div>

					<div id="errorBox">
						<p id="errorText">inserisci almeno una parola!</p>
					</div>
				</div>
			</c:if>
		</div>



		<c:forEach items="${contentMovie.recensioni}" var="review">
			<c:if test="${userReview.nomeUtente != review.nomeUtente}">
				<div class="reviewBox">
					<c:if test="${review.voto == 1}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
					</c:if>
					<c:if test="${review.voto == 2}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
					</c:if>
					<c:if test="${review.voto == 3}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star "></span>
						<span class="fa fa-star "></span>
					</c:if>
					<c:if test="${review.voto == 4}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star "></span>
					</c:if>
					<c:if test="${review.voto == 5}">
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
						<span class="fa fa-star checked"></span>
					</c:if>

					<div class="usernameReview">
						<i class="fas fa-user fa-sm"></i> ${review.nomeUtente}
					</div>
					<p class="textReview">${review.testo}</p>
				</div>
			</c:if>

		</c:forEach>


	</div>

</body>

</html>