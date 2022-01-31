<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

	<head>
		
		<link rel="stylesheet" href="/css/navBarCSS.css">
		<link rel="stylesheet" href="/css/commonCSS.css">
		<link rel="stylesheet" href="/css/dropdownFilterCSS.css">
	</head>

	<body>

		<div class = "dropdownFilter">
			More
			<div class = "dropdown-option">
				<a class = "option">
				    <label>Content:</label>
					<select name = "content">
						<option value = "movie">Movie</option>
						<option value = "book">Book</option>
						<option value = "music">Music</option>
						<option value = "game">Game</option>
						<option value = "all">All</option>
					</select>
				</a>
				<a> 
					<label>Release:</label>
					<select name = "release">
						<option value = "all">All</option>
						<option value = "released">Rel</option>
						<option value = "not released">Not rel</option>
					</select>
				</a>
				<a>
					<label>Rating >=:</label>
					<select name = "rating">
						<option value = "0"> 0 </option>
						<option value = "1"> 1 </option>
						<option value = "2"> 2 </option>
						<option value = "3"> 3 </option>
						<option value = "4"> 4 </option>
						<option value = "5"> 5 </option>
						<option value = "6"> 6 </option>
						<option value = "7"> 7 </option>
						<option value = "8"> 8 </option>
						<option value = "9"> 9 </option>
						<option value = "10"> 10</option>
					</select>
				</a>
				<a>
					<label>Date:</label>
					<input class = "date" type="date" value = "1900-01-01" name="startDate">
					<input class = "date" type="date" value = "2100-11-01" name="endDate">
				</a>
			</div>
		</div>
	</body>

</html>