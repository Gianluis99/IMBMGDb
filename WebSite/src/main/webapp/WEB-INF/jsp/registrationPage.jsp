
<!-- includiamo JSTL -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>

<meta name="google-signin-client_id"
	content="738852866172-uk89bsq1nevpskn0r5m82m5fev1mmrr1.apps.googleusercontent.com">

<meta charset="utf-8" />
<title>Registration - IMBMGDb</title>


<link href="css/registrationPageCSS.css" rel="stylesheet"
	type="text/css" />

<!--bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/googleLogin.js"></script>
</head>

<body>


	<header> </header>
	<div class="top">
		<h1>IMBMGDb</h1>
		<img alt="" src="">

	</div>


	<div class="formContainer">

		<div class="infoContainer">
			<h3>Create account</h3>
			<br>

			<c:if test="${error!=null}">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if>


			<form method="post" action="registrationService">
				<label for="username">Your username:</label><br> <input
					type="text" id="username" name="username" value="${username}"
					placeholder="enter username" required><br> <label
					for="email">Email:</label><br> <input type="email" id="email"
					name="email" value="${email}" placeholder="enter email" required>
				<label for="Password">Password:</label><br> <input
					type="password" id="password" name="password" value="${password}"
					placeholder="at least 6 characters" required><br> <label
					for="Password">Re-enter password:</label><br> <input
					type="password" id="rePassword" name="rePassword"
					value="${rePassword}" required><br> <br> <input
					type="submit" value="Create your IMBMGDb account">


			</form>
			<hr class="solid">
			
			<p>
			
				Already have an account? <a href="loginPage">Sign-In</a>
			</p>


			<div class="g-signin2" data-onsuccess="onSignIn"></div>

		</div>
	</div>





	<footer> </footer>
</body>


</html>