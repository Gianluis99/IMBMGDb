
<!-- inclusione JSTL -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--importazione Jquery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<html>

	<head>
	
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
	
		<link rel="stylesheet" type="text/css" href="/css/modalStyle.css">
		<link rel="stylesheet" type="text/css" href="/css/adminPageCSS.css">
		
		<title>Admin Page - imdb</title>
		
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
			crossorigin="anonymous"
		>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous">
		</script>
		
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
		
		<script src="../js/adminPageSuggestions.js"></script>
		<script src="../js/modelloDati.js"></script>
		
	</head>
	
	<body>
	
		<div class="infoContainer">
			<h1 id="typePage">
				<c:if test="${tipo==1}"> Admin </c:if>
				<c:if test="${tipo==2}"> Moderator </c:if>
				page
			</h1>
	
		</div>
	
	
		<c:if test="${tipo==1}">
			<div class="assignRoleContainer shadow-lg">
				<h1>Assign or remove role</h1>
				<p>An Admin, can create/remove moderators, can publish new polls, can ban/unbann  users/moderators and can delete user reviews.</p>
				<p>A Moderator, can publish new poll, ban/unbann users and delete user reviews.</p>
	
				<div class="info-container">
	
					<select class="userType shadow" id="userType1" name="userType1">
						<option value="Admin">Admin</option>
						<option value="Moderator">Moderator</option>
						<option value="Remove">Remove</option>
	
	
					</select> <input type="text" id="inputText1"
						class="inputText  form-control-sm shadow border-0 "
						placeholder="Select User Here...">
	
					<button class="btn shadow" id="btn1">Add</button>
				</div>
	
			</div>
		</c:if>
	
		<div class="assignRoleContainer shadow-lg">
			<h1>Ban / Unbann users</h1>
			<p>Here you can see all user in the system and banning them.</p>
			<div class="info-container">
	
				<select class="userType shadow" id="userType2" name="userType2">
					<option value="All">All</option>
					<option value="Admin">Admin</option>
					<option value="Moderator">Moderator</option>
					<option value="Banned">Banned</option>
	
				</select> <input type="text" id="inputText2"
					class="inputText form-control-sm shadow border-0 "
					placeholder="Search User Here...">
	
			</div>
	
			<div class="tableBox">
				<table id="usersTable" class="shadow">
					<thead>
						<tr>
							<th>Username</th>
							<th>Email</th>
							<th>Role</th>
							<th>Banned</th>
							<th>Ban/Unban</th>
	
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usersList}" var="user">
							<tr id="row-${user.username}">
								<td id="${user.username}">${user.username}</td>
								<td>${user.email}</td>
	
								<td id="role-${user.username}"><c:if test="${user.tipo==0}">
										Basic
									</c:if> <c:if test="${user.tipo==1}">
										Admin
									</c:if> <c:if test="${user.tipo==2}">
										Moderator
									</c:if></td>
	
								<c:if test="${user.username != username}">
									<c:if test="${user.abilitato}">
										<td id="is-${user.username}"></td>
									</c:if>
									<c:if test="${!user.abilitato}">
										<td id="is-${user.username}">Banned</td>
									</c:if>
								</c:if>
	
								<c:if test="${user.username == username}">
									<td>you
									<td>
								</c:if>
	
								<c:if test="${user.username != username}">
									<td>
										<button
											<c:if test="${!user.abilitato}">style="background: #02908B;"</c:if>
											id="${user.username}" class="btnBan">
											<c:if test="${user.abilitato}">Ban</c:if>
											<c:if test="${!user.abilitato}">Unban</c:if>
										</button>
									</td>
	
								</c:if>
	
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	
		<div id="myModal" class="modal">
	
			<div class="modal-content">
				<div class="modal-header">
					<span class="close">&times;</span>
					<h2 class="title-header">Attention!</h2>
				</div>
				<p id="message"></p>
			</div>
	
		</div>
		
	</body>

</html>