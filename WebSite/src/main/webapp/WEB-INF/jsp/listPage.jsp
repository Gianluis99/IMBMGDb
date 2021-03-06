<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
	
		<title> Le tue liste </title>
	
	    <meta charset="utf-8">
	    
	    <link rel="stylesheet" href="css/listPageCSS.css">
	    <script type="text/javascript" src="../js/listHandler.js"></script>
	</head>
	
	<body onload = "loadLists('${username}')">
		
		<%@ include file="navBar.jsp" %>
		<div class = "split left">
			
			<ul>
				<li><button class = "operationButton" onclick = "addList('${username}')">Add</button></li>
				<li><button class = "operationButton" onclick = "deleteList('${username}')">Delete</button></li>
			</ul>
		
			<div class="container centered" id = "listContainer"> </div>
		</div>
		
		<div class = "split right">
			<div class="container centered" id = "contentContainer"></div>
		</div>
		
	</body>
	
</html>