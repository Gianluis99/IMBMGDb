<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
		<title> MyWebSite </title>
		<link rel="icon" type="image/x-icon" href="http://cdn.onlinewebfonts.com/svg/img_239039.png">
	
	    <link rel="stylesheet" href="/css/commonCSS.css">
	    <link rel="stylesheet" href="/css/resultsPageCSS.css">
	      
	    <script type='text/javascript' src="/js/modelloDati.js"></script>
	    <script type='text/javascript' src="/js/resultsHandler.js"></script>
	    <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	</head>

	<body onload = "myFunction()">
		<%@ include file="navBar.jsp" %>         
        
        <br></br>
        <h1 class = "resultsFor"> Results for ${title}</h1>
      
        <table id = "resultsTable" class="table table-hover">
	    	<thead>
	        	<tr>
	            	<th>ID</th>
	                <th>TITLE</th>
	                <th>YEAR</th>
	                <th>PLOT</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody> </tbody>
       	</table>
            
	</body>
	
	<script>
	    var title = "${title}";
	    var content = "${content}";
	    var release = "${release}";
	    var rating = "${rating}";
	    var startDate = "${startDate}";
	    var endDate = "${endDate}";
		function myFunction() { loadResults(title, content, release, rating, startDate, endDate); }
	</script>

</html>