
<!-- includiamo JSTL !-->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8" />
<title>Genre</title>
<link rel="icon" href="" type="image/x-icon" />

<link href="css/genrePageCSS.css" rel="stylesheet" type="text/css" />

</head>

<body>


	<header></header>



	<div class="top">

		<h2>Movie</h2>


		<h1>Avventura</h1>
	</div>
	
	
	<div class="filmContainer  mt-6 mb-5 ">

		<c:forEach items="${prove}" var="prova">
			<div class="movie m-2 mb-4">
				<a href="${prova.nome}"> <img id="imgMovie" class="img"
					src="${prova.url}"> <img class="iconAdd"
					src="immagini/iconAddToList.png">
				</a>
				<div class="down">
				
					<a href="${prova.nome}" class="title"> ${prova.nome} </a>
					<div class="divVoti">
						<img class="iconStar" src="immagini/starIcon.png">
						<p class="voti">7.7</p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	



	<footer></footer>
</body>


</html>