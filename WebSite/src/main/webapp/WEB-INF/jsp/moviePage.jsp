<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>

<title>Movies - IMBMGDb</title>

<meta charset="utf-8" />

<link rel="stylesheet" href="/css/commonCSS.css">
<link rel="stylesheet" href="/css/moviePageCSS.css">
<link rel="stylesheet" type="text/css" href="/css/itemContent.css">

<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<script type="text/javascript" src="../js/movieGenres.js"></script>
<script type="text/javascript" src="../js/getMoviehandler.js"></script>
</head>

<body>

	<%@ include file="navBar.jsp"%>
	<div class="categoriesContainer" id="cat-container"></div>
	<%@ include file="movieCarousel.jsp"%>


	<div class="titleSection">Upcoming Movies</div>

	<div class="filmContainer" id="filmContainer"></div>

	<div class="titleSection">Top Rated</div>
	<div class="filmContainer" id="filmContainerTop"></div>


</body>

</html>