
<!-- includiamo JSTL -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>

<html>

<head>

<title>${contentName}</title>

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


</head>

<body>

	<header> </header>

	<nav>
		<ul>
			<li><a>Home</a></li>
			<li><a>Movies</a></li>
			<li><a>Books</a></li>
			<li><a>Music</a></li>
			<li><a>Games</a></li>

		</ul>

		<div class="rightContainer">
			<form>
				<button type="submit" name="searchButton">Search</button>
				<input type="text" placeholder="Type something.." name="searchField">
				<button type="submit" name="loginButton">Login</button>
			</form>
		</div>
	</nav>



	<div class="contentContainer">

		<h1 id="contentTitle">${contentMovie.titolo}</h1>

		<div class="infoBox">
				
			<i class="fas fa-clock"></i>
			<p class="infoText"> ${contentMovie.durata} min</p>
			
			<i class="fas fa-star"></i>
			<p class="infoText"> ${contentMovie.voto} Imdb</p>



		</div>


		<div class="multimediaContainer">
			<img class="imgMultimedia" id="imgMultimedia"
				src="${contentMovie.urlImg}">
			<iframe class="videoMultimedia" id="videoMultimedia"
				src="https://www.youtube.com/embed/tgbNymZ7vqY"> </iframe>
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

	<div class="reviewBox">
		<h3>Reviews</h3>
	</div>

</body>

</html>