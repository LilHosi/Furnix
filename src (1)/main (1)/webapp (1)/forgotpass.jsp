<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<title>Forget Password</title>
</head>
<body>

<div class="container">
<form action = "ForgetPass" method="post">
<div class="detail">
<div class="input-box">
<span class="text">Username</span>
<input type="text" name="username" placeholder="Enter your Username">
</div>
${mes}
<div class="input-box">
<span class="text">Email</span>
<input type="text" name="email" placeholder="Enter your Email">
</div>
</div>
<div class="space">
<input type="submit" value="GET YOUR PASSWORD">
</div>
</form>
<!-- <a class="click-white" href="login.jsp" style="color: grey;">LOGIN</a>

 -->
 <h6><a href="login.jsp" style="color: grey;">Login</a></h6>
 <h6><a href="home.jsp" style="color: grey;">Back to HomePage</a></h6>
</div>


</body>
</html>