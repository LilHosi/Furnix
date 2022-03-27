<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/ProjectDemo/style-home.css">
<title>About us</title>
</head>

<body>
<jsp:include page="navigationBar.jsp"></jsp:include>
<header id="landingPage" style="background-image: url('image/room.jpg');">
		<div class="landingPageContent">
			<div class="container">
				<div class="row">
					<div class="col-6">
						<h1>
							About Us
						</h1>
						<p>“What I do is about living the best life you can and enjoying the fullness of the life around you. From what you wear to the way you live to the way you love.”</p>
						
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<div class="row information section-p1">
	<div class="col-md-6 col-sm-12 col-12">
	<div onclick="location.href='https://goo.gl/maps/FwFoW26JqcVv9nBL7';" style="cursor:pointer;" class="content click">
	<h2>FURNIX SYDNEY FLAGSHIP</h2>
	<H4>227 Elizabeth st, Sydney NSW 2000</H4>
	</div>
	
	<!-- <a href="https://goo.gl/maps/FwFoW26JqcVv9nBL7"> -->
	<div onclick="location.href='https://goo.gl/maps/QRMf2c7Mo9oZ96Dr9';" style="cursor:pointer;" class="content click">
	<h2>FURNIX CABRAMATTA</h2>
	<H4>Dutton Ln, Cabramatta NSW 2166</H4>
	</div>
	<!-- </a> -->
	</div>
	<div class="col-md-6 col-sm-12 col-12">
	<iframe src="https://www.google.com/maps/d/u/0/embed?mid=1XSMF_wX_wKy3zE0R0U6tNRVEOiaeVdnM&ehbc=2E312F" width="640" height="480"></iframe>
	</div>
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>