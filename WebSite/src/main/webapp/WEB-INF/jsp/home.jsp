<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
	
		<title> MyWebSite </title>
	
	    <meta charset="utf-8" />
	    
	    <link rel="stylesheet" href="/css/indexCSS.css">
	    <link rel="stylesheet" href="/css/commonCSS.css">
	    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
	    
	    <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
	   
	</head>
	
	<body>
	
		<header>
		</header>
		
		<!-- Nella nav vengono interrogati gli attributi degli scoped obj (tipo le req). jstl cerca un attributo che si chiama username. -->
		<nav>
			<ul>
				<c:if test = "${username != null}">
					<li>
						<div class = "dropdown"> ${username} 
							<div class = "dropdown-content">
								<a class = "item left"> Poll </a>
								<a class = "item center"> Lists </a>
								<a class = "item right" href = "doLogout"> Logout </a>
							</div>
						</div>
					</li>
				</c:if>
				<c:if test = "${username == null}">
					<li><a href = "loginPage">Login</a></li>
				</c:if>
				
      			<li><a>Home</a></li>
      			<li><a>Movies</a></li>
      			<li><a>Book</a></li>
     			<li><a>Music</a></li>
     			<li><a>Games</a></li>
    		</ul>
    		
    		<div class = "rightContainer">
	    		<button type="submit" name = "searchButton"> Search </button>
	      		<input type="text" placeholder="Type something.." name="searchField">
    		</div>
		</nav>
			
		<!--  
		<section class = "swiperSection">
			<h2 class="titleSection">Popular movies now</h2>
			<div class="tilesSection swiper">
			  <div class="swiper-wrapper">
			    <c:forEach items = "${mostPopularContents}" var = "content">
				  	<div class="swiper-slide">
				  		<a href = "registrationPage.html">
	                    	<img class="imageSection"
	                         src="https://occ-0-1433-1432.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUqwomVyMFsby9zeXLLnkfv744mKCzQDWL7rUDhbwg89bpT-V7qYoW-NNfjFaG3nFcDWu-U49vpUFB_L4njc2GFl6l60Efb4oT-_0e3oi3Dh8nwyLZhG2ciBHGUnRMB_J-D2jQk2Qz_WM4n8A_8b8ZqFDpj80B6KJ9T2bXR7rYcl0M8MaDCsR68.jpg?r=93f"
	                        >
	                    </a>
				  	</div> 
			  	</c:forEach>
			  </div>
			  <div class="swiper-button-prev"></div>
			  <div class="swiper-button-next"></div>
			</div>		
        </section>
        
        <section class = "swiperSection">
			<h2 class="titleSection">News</h2>
			<div class="tilesSection swiper">
			  <div class="swiper-wrapper">
			    <c:forEach items = "${newContents}" var = "content">
				  	<div class="swiper-slide">
				  		<a href = "registrationPage.html">
	                    	<img class="imageSection"
	                         src="https://occ-0-1433-1432.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUjsKDiaKwLmrV662pwmVKEtRmbJI-s8M9ojCqr2QEdnPUJPX86RP-n9IGXxGcaHWkTf-cwz5e4kBLN3jYLM7HuBfYA.webp?r=01d"
	                        >
	                    </a>
				  	</div> 
			  	</c:forEach>
			  </div>
			  <div class="swiper-button-prev"></div>
			  <div class="swiper-button-next"></div>
			</div>		
        </section>
        
        <section class = "swiperSection">
			<h2 class="titleSection">Coming soon</h2>
			<div class="tilesSection swiper">
			  <div class="swiper-wrapper">
			    <c:forEach items = "${comingSoonContents}" var = "content">
				  	<div class="swiper-slide">
				  		<a href = "registrationPage.html">
	                    	<img class="imageSection"
	                         src="https://occ-0-1433-1432.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUqwomVyMFsby9zeXLLnkfv744mKCzQDWL7rUDhbwg89bpT-V7qYoW-NNfjFaG3nFcDWu-U49vpUFB_L4njc2GFl6l60Efb4oT-_0e3oi3Dh8nwyLZhG2ciBHGUnRMB_J-D2jQk2Qz_WM4n8A_8b8ZqFDpj80B6KJ9T2bXR7rYcl0M8MaDCsR68.jpg?r=93f"
	                        >
	                    </a>
				  	</div> 
			  	</c:forEach>
			  </div>
			  <div class="swiper-button-prev"></div>
			  <div class="swiper-button-next"></div>
			</div>		
        </section>
        
		<footer>
		</footer>
		
		<script>
			var mySwiper = new Swiper('.swiper', {
				// Optional parameters
				spaceBetween: 5,
				slidesPerView: 2,
				loop: true,
				freeMode: true,
				loopAdditionalSlides: 5,
				speed: 500,
				// Navigation arrows
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				},
				breakpoints: {
				// when window width is >= 640px
					640: {
					slidesPerView: 5,
					slidesPerGroup: 5,
					freeMode: false
					}
				}
			})
    	</script>
    	-->
	   
	</body>

</html>