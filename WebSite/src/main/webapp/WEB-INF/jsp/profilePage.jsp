
<!-- inclusione JSTL -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--importazione Jquery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<html>

	<head>
	
		<meta charset="utf-8">
		
		<title>My profile - imdb</title>
		
		<link rel="stylesheet" href="css/profileCSS.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	</head>
	
	<body>
			
		<%@ include file="navBar.jsp" %>
		
		<br></br>
		<br></br>
		
		<div class="infoContainer">
			<h1 id="my-profile">
				My profile
			</h1>
		</div>
		
		<div>
			<a id="list-btn" class="list-btn" href="listPage">Lists Section</a>
		</div>
		
		<br></br>
		<br></br>
		
		<div class="personalInfoContainer shadow-lg">
			
			<h1 id="PersonalInfo">Personal info:</h1>
			
			<table id="personalInfoTable" class="shadow">
				<thead>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>	
					</tr>
				</thead>
				<tbody>
					<tr id="row-username">
						<td id="td-username">
							<h1>Username:</h1>
						</td>
						<td id="td-actualUsername">
							<p>${username}</p>
						</td>
						<td id="td-newUsername">
							<form id="usernameForm" method="post" action="changeUsername">
								<input type="text" placeholder="New username.." name="newUsername">
							</form>	
						</td>
						<td id="td-newUsername-btn">
							<button type="submit" form="usernameForm">Change username</button>
						</td>
					</tr>
					<tr id="row-email">
						<td id="td-email">
							<h1>Email:</h1>
						</td>
						<td id="td-actualEmail">
							<p>${email}</p>
						</td>
						<td id="td-newEmail">
							<form id="emailForm" method="post" action="changeEmail">
								<input type="text" placeholder="New email.." name="newEmail">
							</form>	
						</td>
						<td id="td-newEmail-btn">
							<button type="submit" form="emailForm">Change email</button>
						</td>
					</tr>
					<tr id="row-usertype">
						<td id="td-usertype">
							<h1>User Type:</h1>
						</td>
						<td id="td-actualUsertype">
							<p>
								<c:if test="${tipo==0}"> Standard User </c:if>
								<c:if test="${tipo==1}"> Admin </c:if>
								<c:if test="${tipo==2}"> Moderator </c:if>
							</p>
						</td>
					</tr>
				</tbody>
			</table>
			
		</div>
		
	</body>
	
</html>