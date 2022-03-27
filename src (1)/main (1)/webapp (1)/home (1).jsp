<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<script src="https://kit.fontawesome.com/76af9337dc.js" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style-home.css">
<title>Home Page</title>
</head>


<body>
<!-- NAVIGATION BAR  -->
	<jsp:include page="navigationBar.jsp"></jsp:include>
	<header id="landingPage" style="background-image: url('image/room.jpg');">
		<div class="landingPageContent">
			<div class="container">
				<div class="row">
					<div class="col-6">
						<p>MINIMAL FURNITURE</p>
						<h1>
							WITHIN A SPACE,<br/>IT'S A LIFESTYLE
						</h1>
						<p>Interior design is all about bringing a better, more
							comfortable lifestyle into your area of living. It is not an easy
							work, but it is possible when we are here.</p>
							<br>
						<a class="click-white" href="#byRoom">Explore More </a>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div id="byRoom">
		<div class="container-fluid section-m1" style="
    display: grid;
    justify-content: center;
		">
				<div class="col-12">
					<h2>ALL PRODUCTS</h2>
					<br>
					<h4>
					<a href="ProductServlet">
						<span class="click-black">Learn more ></span>
						</a>
					</h4>
				</div>
			</div>

		<div class="rooms" onclick="location.href='ListProduct?selectCategory=1'" style="cursor: pointer;">
				<img src="./image/room1.jpg">
				<div class="content">
				<h2>
				<a href ="ListProduct?selectCategory=1">
					| KITCHEN</a></h2>
					<a class="click-white" href ="ListProduct?selectCategory=1">Explore More</a>			
				</div>
			</div>
		
			<div class="rooms" onclick="location.href='ListProduct?selectCategory=2'" style="cursor: pointer;">
				<img src="./image/room2.jpg">
				<div class="content">
				<h2>
				<a href ="ListProduct?selectCategory=2">
					| BEDROOM</a></h2>
					<a class="click-white" href ="ListProduct?selectCategory=2">Explore More</a>			
				</div>
			</div>
		
			<div class="rooms" onclick="location.href='ListProduct?selectCategory=3'" style="cursor: pointer;">
				<img src="./image/room3.jpg">
				<div class="content">
				<h2>
				<a href ="ListProduct?selectCategory=3">
					| OFFICE</a></h2>
					<a class="click-white" href ="ListProduct?selectCategory=3">Explore More</a>			
				</div>
			</div>
		
			<div class="rooms" onclick="location.href='ListProduct?selectCategory=4'" style="cursor: pointer;">
				<img src="./image/room4.jpg">
				<div class="content">
				<h2>
				<a href ="ListProduct?selectCategory=4">
					| OUTDOOR</a></h2>
					<a class="click-white" href ="ListProduct?selectCategory=4">Explore More</a>			
				</div>
			</div>
		
	<jsp:include page="footer.jsp"></jsp:include>
</html>