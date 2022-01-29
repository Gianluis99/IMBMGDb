
<!-- includiamo JSTL -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>

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
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/reviewCSS.css">
<link rel="stylesheet" href="css/myReviewCSS.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

		<hr class=rounded>


	</div>

	<div class="reviewsBox">
		<hr style="border: 3px solid #f1f1f1">

		<span> 21 Reviews <i class="fas fa-atlas"></i></span>

		<div class="myReviewBox">
			<span class="fa fa-star checked"></span> <span
				class="fa fa-star checked"></span> <span class="fa fa-star checked"></span>
			<span class="fa fa-star"></span> <span class="fa fa-star"></span>

			<div class="reviewTextArea">
				<form action="/action_page.php">
					<div class="row">
						<div class="col-75">
							<textarea placeholder="Write here your review..."
								class="myReviewBoxTextArea" style="height: 200px"></textarea>
						</div>
					</div>
					<div class="row">
						<input type="submit" value="Submit">
					</div>
				</form>
			</div>
		</div>





	</div>

</body>

</html>