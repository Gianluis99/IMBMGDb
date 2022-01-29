<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8" />
		
		<link rel="stylesheet" href="/css/navBarCSS.css">
		<link rel="stylesheet" href="/css/commonCSS.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	</head>

	<body>
		<!-- Nella topnav vengono interrogati gli attributi degli scoped obj (tipo le req). jstl cerca un attributo che si chiama username. -->
		<div class="topnav">
			<c:if test="${username != null}">
				<div class="dropdown">
					${username}
					<div class="dropdown-content">
						<a class="item left" href="listPage"> MyArea </a> 
						
						<c:if test="${tipo == 1}">
							<a class="item right" href="adminPage">Admin</a>
						</c:if>
	
						<c:if test="${tipo == 2}">
							<a class="item right" href="adminPage">Moderator</a>
						</c:if>
						
						<a class="item right" href="doLogout"> Logout </a>
					</div>
				</div>
			</c:if>
			
			<c:if test="${username == null}">
				<a href="loginPage">Login</a>
			</c:if>
	
			<a href="/">Home</a> <a>Movie</a> <a>Game</a> <a>Book</a> <a>Music</a>
			 
			<div class="search-container">
				<form method = "POST" action = "/resultsPage">
					<input type="text" placeholder="Search.." name = "searchField">
					<button type="submit"> Search </button>
					<!--  
					<div class = "dropdownFilter">
						More
						<div class = "dropdown-option">
							<a class="option" > Logout </a>
						</div>
					</div>
					-->
				</form>
			</div>
				
		</div>
	</body>

</html>