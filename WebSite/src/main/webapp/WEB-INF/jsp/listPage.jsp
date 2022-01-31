<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
	
		<title> Le tue liste </title>
	
	    <meta charset="utf-8">
	    
	    <link rel="stylesheet" href="css/splittedPageCSS.css">
	    <link rel="stylesheet" href="css/listBoxCSS.css">
	    
	    
	</head>
	
	<body>
		
		<%@ include file="navBar.jsp" %>
		 
		<div class="split">
			
			<br></br>
			<h2 class = "text">Le mie liste</h2>
			
			<!--  		    
			<ul class = "buttonsContainer">
				<li><button>Add</button></li>
				<li><button>Edit</button></li>
				<li><button>Remove</button></li>
			</ul>
			-->
					  
			<ul class="listsContainer">
				 <li class = "listBox"> Lista 6 </li>
				 <li class = "listBox"> Lista 6 </li>
				 
			</ul>
		</div>
			
			
		<div class="split">
			    
		</div>
		
	</body>
		
</html>