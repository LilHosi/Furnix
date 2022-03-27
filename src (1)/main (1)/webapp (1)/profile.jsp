<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<script src="https://kit.fontawesome.com/76af9337dc.js" crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style-home.css">
<title>Account Profile</title>
</head>
<jsp:include page="navigationBar.jsp"></jsp:include>
<body>
	<section style="padding: 50px 100px; width: 80%;
display: flex">
		<div class="title section-p1">
			<h1>Customer Information:</h1>
		</div>

		<div class="container" style="width: 80%">
			<form action="LoginCheckout" method="post">
				<div class="detail">
					<div class="input-box">
						

						<span class="text">Pronounce</span> 
							<select class="click-white" name="pronounce">
<option value="mr">Mr</option>
<option value="mrs">Mrs</option>
<option value="ms">Ms</option>
<option value="miss">Miss</option>
<option value="dr">Dr</option>
</select>
					</div>
					<div class="input-box">
						<span class="text">Username</span> <input class="click-white"
							type="text" name="username" placeholder="${sessionScope.me.firstName}">
					</div>

					<div class="input-box">
						<span class="text">Preferred Name</span> <input class="click-white"
							type="text" name="preferredName" placeholder="not yet">
					</div>
					
					<div class="input-box">
						<span class="text">Email</span> <input class="click-white"
							type="text" name="email" placeholder="${sessionScope.me.email}">
					</div>
					
					<div class="input-box">
						<span class="text">Password</span> <input class="click-white"
							type="password" name="password" placeholder="${sessionScope.me.password}">
					</div>
					
					<div class="input-box">
						<span class="text">Phone Number</span> <input class="click-white"
							type="text" name="phone" placeholder="not yet">
					</div>
					
				</div>
				<div class="space">
					<input class="click-black" type="submit" value="Update Information">
				</div>
				<div class="modal-footer">
					<!--         <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Login</button> -->
				</div>
			</form>
		</div>
		<!-- <h2>
			<a href="OrderServlet">Order history</a>
		</h2> -->
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>