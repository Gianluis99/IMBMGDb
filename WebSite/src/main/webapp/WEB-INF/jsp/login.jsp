<html>

	<head>
		<link rel="stylesheet" href="/css/loginCSS.css">
		<link rel="stylesheet" href="/css/commonCSS.css">
	</head>

	<body>
	<div class="formContainer">
		<form method = "post" action = "doLogin">
			<div class="container">
		   		<label for="username">Username</label>
		   		<input type="text" placeholder="Enter Username" name="username" required>
		    			
	  			<label for="password">Password</label>
	    		<input type="password" placeholder="Enter Password" name="password" required>
	  		</div>
		  			
	  		<div class = "buttonContainer">
	  			<button type="submit">Login</button>
	 		</div>
	 		
	 		<a href="registration" class = "registration">create your account</a>
		</form>	
			
	</div>
				
	</body>

</html>