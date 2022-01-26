
<!-- includiamo JSTL !-->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8" />
<title>Genre</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>


<link rel="icon" href="" type="image/x-icon" />

<link href="css/genrePageCSS.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="../js/genrePage.js"></script>

</head>

<body>

	

	<header></header>



	<div class="top">

		<h2>Movie</h2>


		<h1 id="genreId" title="${genreId}">${genreName}</h1>
	</div>


	<div class="filmContainer" id="filmContainer">

		<!--  
		<div class="movie">
			<a href=""> <img id="imgMovie" class="img"
				src="https://i.pinimg.com/originals/e7/4d/55/e74d559716dc999fe06d887b843689c7.jpg">
			</a>
			<div class="down">

				<a href="${prova.nome}" class="title"> nome </a>
				<div class="divVoti">
					<img class="iconStar" src="immagini/starIcon.png">
					<p class="voti">7.7</p>

				</div>
			</div>
		</div>
-->


	</div>




	<footer></footer>
</body>


</html>