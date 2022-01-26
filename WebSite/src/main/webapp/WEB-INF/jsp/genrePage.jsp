
<!-- includiamo JSTL !-->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8" />
<title>Genre</title>
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
	
	
	<div class="filmContainer">

			<div class="movie">
				<a href="${prova.nome}"> <img id="imgMovie" class="img"
					src="${prova.url}"> 
				</a>
				<div class="down">
				
					<a href="${prova.nome}" class="title"> nome </a>
					<div class="divVoti">
						<img class="iconStar" src="immagini/starIcon.png">
						<p class="voti">7.7</p>

					</div>
				</div>
			</div>

	</div>
	



	<footer></footer>
</body>


</html>