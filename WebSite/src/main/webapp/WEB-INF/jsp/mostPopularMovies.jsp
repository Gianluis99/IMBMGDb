<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	
	<head>
	
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    
	    <link rel="stylesheet" href="/css/movieCarousel.css">
	    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
	    
	    <script type='text/javascript' src="/js/movieCarousel.js"></script>
	    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	    
	</head>

	<body>
	
		<!-- Slider main container -->
		<div class="swiper">
			<!-- Additional required wrapper -->
			<div class="thumbTiles swiper-container">
				<div class="swiper-wrapper" id = "mostPopularMovies"> <!-- Slides --> </div>
			
				<!-- If we need navigation buttons -->
				<div class="swiper-button-prev"></div>
				<div class="swiper-button-next"></div>
			</div>
		</div>
		
	</body>
	
	<script>
		var swiper = new Swiper('.swiper-container', {
			// Optional parameters
			loop: true,
			slidesPerView: 2,
			
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