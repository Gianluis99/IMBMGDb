<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>My profile</title>
	<link rel="stylesheet" href="css/commonCSS.css">
	<link rel="stylesheet" href="css/profileCSS.css">
	<link rel="stylesheet" href="css/reviewCSS.css">
	<link rel="stylesheet" href="css/myReviewCSS.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
		
	<%@ include file="navBar.jsp" %>
	
	<br></br>
	Il mio profilo
	
	<br></br>
	<br></br>
	<a class = "button" href = "listPage">List Section</a>
	<br></br>
	<br></br>
	
	<br/>
	<br/>

	<span class="heading">User Rating</span>
	<span class="fa fa-star checked"></span>
	<span class="fa fa-star checked"></span>
	<span class="fa fa-star checked"></span>
	<span class="fa fa-star checked"></span>
	<span class="fa fa-star"></span>
	<p>4.1 average based on 254 reviews.</p>
	<hr style="border:3px solid #f1f1f1">
	
	<div class="row">
	  <div class="side">
	    <div>5 star</div>
	  </div>
	  <div class="middle">
	    <div class="bar-container">
	      <div class="bar-5"></div>
	    </div>
	  </div>
	  <div class="side right">
	    <div>150</div>
	  </div>
	  <div class="side">
	    <div>4 star</div>
	  </div>
	  <div class="middle">
	    <div class="bar-container">
	      <div class="bar-4"></div>
	    </div>
	  </div>
	  <div class="side right">
	    <div>63</div>
	  </div>
	  <div class="side">
	    <div>3 star</div>
	  </div>
	  <div class="middle">
	    <div class="bar-container">
	      <div class="bar-3"></div>
	    </div>
	  </div>
	  <div class="side right">
	    <div>15</div>
	  </div>
	  <div class="side">
	    <div>2 star</div>
	  </div>
	  <div class="middle">
	    <div class="bar-container">
	      <div class="bar-2"></div>
	    </div>
	  </div>
	  <div class="side right">
	    <div>6</div>
	  </div>
	  <div class="side">
	    <div>1 star</div>
	  </div>
	  <div class="middle">
	    <div class="bar-container">
	      <div class="bar-1"></div>
	    </div>
	  </div>
	  <div class="side right">
	    <div>20</div>
	  </div>
	</div>
	
	<br/>
	<br/>
	
	<div class="myReviewBox">
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star"></span>
		<span class="fa fa-star"></span>
		<div> - Esattamente, il tuo nome.</div>
		
		<div class="reviewTextArea">
		  	<form action="/action_page.php">
			    <div class="row">
			      <div class="col-75">
			        <textarea placeholder="Write here your review..." class="myReviewBoxTextArea" style="height:200px"></textarea>
			      </div>
			    </div>
			    <div class="row">
			      <input type="submit" value="Submit">
			    </div>
		  	</form>
		</div>
	</div>
	
	<br/>
	<br/>
	
	<div class="reviewBox">
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star"></span>
		<div> - Antonella "a vicina tua".</div>
		
		<div class="reviewTextArea">
			<div class="row">
			  <div class="col-75">
			    <textarea readonly class="reviewBoxTextArea" style="height:200px">Che bel film! Quasi ottimo...</textarea>
			  </div>
			</div>
		</div>
	</div>
	
	<div class="reviewBox">
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<div> - Antonio del Fato.</div>
		
		<div class="reviewTextArea">
			<div class="row">
			  <div class="col-75">
			    <textarea readonly class="reviewBoxTextArea" style="height:200px">GuÃ , piÃ¹ o meno ci siamo... si poteva fare di piÃ¹, quello sicuro... perÃ², cioÃ¨... ci sta eh, perÃ² boh... VabbÃ¨ che lasciamo perdere... sennÃ² ci stiamo troppo... PerÃ² boh, vabbÃ¨... lasciamo perdere. E' ok.</textarea>
			  </div>
			</div>
		</div>
	</div>

	<div class="reviewBox">
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star"></span>
		<div> - Antonella (non la tua vicina).</div>
		
		<div class="reviewTextArea">
			<div class="row">
			  <div class="col-75">
			    <textarea readonly class="reviewBoxTextArea" style="height:200px">Adoro kek!</textarea>
			  </div>
			</div>
		</div>
	</div>
	
	
</body>
</html>