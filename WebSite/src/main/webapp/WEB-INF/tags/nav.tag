

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
<link rel="stylesheet" href="/css/indexCSS.css">
<link rel="stylesheet" href="/css/commonCSS.css">
</head>

<body>
	<nav>
		<ul>
			<c:if test="${username != null}">
				<li>
					<div class="dropdown">
						${username}
						<div class="dropdown-content">
							<a class="item left"> Poll </a> <a class="item center"> Lists
							</a> <a class="item right" href="doLogout"> Logout </a>
						</div>
					</div>
				</li>
			</c:if>
			<c:if test="${username == null}">
				<li><a href="loginPage">Login</a></li>
			</c:if>

			<li><a>Home</a></li>
			<li><a>Movies</a></li>
			<li><a>Book</a></li>
			<li><a>Music</a></li>
			<li><a>Games</a></li>
		</ul>

		<div class="rightContainer">
			<button type="submit" name="searchButton">Search</button>
			<input type="text" placeholder="Type something.." name="searchField">
		</div>
	</nav>

</body>
</html>