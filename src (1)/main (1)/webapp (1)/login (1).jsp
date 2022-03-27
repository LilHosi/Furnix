<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

</head>
<body>
<%-- <%
String me = (String)session.getAttribute("username");
 if (me != null) {
	response.sendRedirect("home.jsp");
}
 %>
 --%>
 
 <c:if test="${not empty sessionScope.username}">
 <c:redirect url="home.jsp"></c:redirect>
 </c:if>
<div class="title">
<h1>LOGIN</h1>
<p></p>
</div>

<div class="container">
<form action = "LoginServlet?command=login" method="post">
<div class="detail">
<div class="input-box">
<span class="text">Username</span>
<input type="text" name="username" placeholder="Enter your Username">
</div>

<div class="input-box">
<span class="text">Password</span>
<input type="password" name="password" placeholder="Enter your Password">
</div>
</div>
<div class="space">
<input type="submit" value="Login">
<a class="text" href="forgotpass.jsp" style="color: #DAA853;">Forgot password?</a>
</div>
</form>
<a href="register.jsp" style="color: grey;">Don't have account? - Register</a>
</div>
</body>
</html>