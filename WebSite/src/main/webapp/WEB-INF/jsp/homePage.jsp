<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
<title>Home - IMBMGDb</title>
<link rel="icon" type="image/x-icon"
	href="http://cdn.onlinewebfonts.com/svg/img_239039.png">

<meta charset="utf-8" />

<link rel="stylesheet" href="/css/commonCSS.css">
<link rel="stylesheet" href="/css/sectionCSS.css">
<link rel="stylesheet" type="text/css" href="/css/homeCSS.css">
<link rel="stylesheet" type="text/css" href="/css/itemContent.css">

<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>
<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<script type="text/javascript" src="../js/homeHandler.js"></script>
</head>

<body>

	<%@ include file="navBar.jsp"%>


	<div class="top">
		<h1>IMBMGDb</h1>
	</div>


	<div class="titleSection">From your List</div>
	<c:if test="${username == null}">
	<div class="listSection"><p>Sign in to access your list. <i class="fas fa-sign-in-alt"></i></p></div>
		
	</c:if>
	<c:if test="${username != null}">
		<div class="listSection"><a id="goListPage" href="listPage">Go to list Page <i class="fas fa-sign-in-alt"></i> </a> </div>
	</c:if>
	
	<%@ include file="movieCarousel.jsp"%>
	
	<div class="titleSection">Popular Person</div>
	<div class="filmContainer" id="popularPersonContainer"></div>
	
	<div class="titleSection">Featured today</div>
	<div class="filmContainer" id="trendingContentContainer"></div>
	
	
	

	



	


	






</body>

</html>