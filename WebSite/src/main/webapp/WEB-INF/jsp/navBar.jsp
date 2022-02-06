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
		
		<div class="topnav">
			<c:if test="${username != null}">
				<div class="dropdownUser">
					${username}
					<div class="dropdownItems">
						<a class="item itemLeft" href="myAreaPage"> MyArea </a> 
						
						<c:if test="${tipo == 1}">
							<a class="item itemRight" href="adminPage">Admin</a>
						</c:if>
	
						<c:if test="${tipo == 2}">
							<a class="item itemRight" href="adminPage">Moderator</a>
						</c:if>
						
						<a class="item itemRight" href="doLogout"> Logout </a>
					</div>
				</div>
			</c:if>
			
			<c:if test="${username == null}">
				<a href="loginPage"> Login </a>
			</c:if>
	
			<a href="/"> Home </a> 
			<a href = "/MoviePage">Movie</a> 
			<a>Game</a> 
			<a>Book</a> 
			<a>Music</a>
			 
			<div class="searchContainer">
				<form method = "POST" action = "/resultsPage">
					<input type="text" placeholder="Search.." name = "searchField" class = "searchField">
					<%@ include file="dropdownFilter.jsp" %>
					<button type="submit" class = "searchButton"> Search </button>
				</form>
			</div>
		</div>
	 
	</body>

</html>