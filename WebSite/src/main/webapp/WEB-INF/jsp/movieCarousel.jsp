<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	
	<head>
	
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    
	    <link rel="stylesheet" href="/css/movieCarousel.css">
	    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
	    
	    <script type="text/javascript" src="../js/movieCarousel.js"></script>
	    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	    
	</head>

	<body>
	    <div class = "titleSection"> Most popular </div>
		<div class="slider">
		    
		    <div class="swiper swiper-container">
			      <div class="swiper-wrapper" id="mostPopularMovies">
			       
			      </div>
			      <div class="swiper-button-next"></div>
			      <div class="swiper-button-prev"></div>
		    </div>
	    </div>
	    
	    <!-- 
	    <div class="slider">
		    <h2>News</h2>
		    <div class="swiper swiper-container">
			      <div class="swiper-wrapper" id="newMovies" >
			        
			      </div>	     
			      <div class="swiper-button-next"></div>
			      <div class="swiper-button-prev"></div>
		    </div>
	    </div>
	    
	    
	    <div class="slider">
		    <h2>Coming soon</h2>
		    <div class="swiper swiper-container">
			      <div class="swiper-wrapper" id="upcomingMovies">
			        
			      </div>
			      <div class="swiper-button-next"></div>
			      <div class="swiper-button-prev"></div>
		    </div>
	    </div>
		-->
	</body>
	
	<script>
	
		const swiper = new Swiper('.swiper-container', {
			// Optional parameters
			
			// Navigation arrows
			navigation: {
			   nextEl: '.swiper-button-next',
			   prevEl: '.swiper-button-prev',
			},
	
			// Slider per group
		    breakpoints: {
	           640: {
	               slidesPerView: 10,
	               slidesPerGroup: 5,
	           }
	        }
		});
		
    </script>
	
</html>