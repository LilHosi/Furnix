<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

</head>
<body>
    <div class="title">
        <h1>REGISTER FORM</h1>
        <p>For new member</p>
    </div>
    <div class="container">


        <form action="RegisterServlet" method="post" class="form" id="myForm">
            <div class="detail">
                <p> ${mes}</p>
                <div class="input-box">
                    <span class="text">What should I call you</span>
                    <select class="pronounce" name="pronounce" id="pronounce" onblur="validatePronounce()">
                    	<option value="">Choose an option</option>
                        <option value="mr">Mr</option>
                        <option value="mrs">Mrs</option>
                        <option value="ms">Ms</option>
                        <option value="miss">Miss</option>
                        <option value="dr">Dr</option>
                        <option value="na">Do not want to answer</option>
                    </select>
                    <span class="helper-text"></span>

                </div> 

                <div class="input-box">
                    <span class="text">First Name</span>
                    <input type="text" name="firstName" placeholder="Enter your First Name" id="firstName" onfocusout="validateFirstName()">
                    <span class="helper-text"></span>
                </div>

                <div class="input-box">
                    <span class="text">Last Name</span>
                    <input type="text" name="lastName" placeholder="Enter your Last Name" id="lastName" onfocusout="validateLastName()">
                    <span class="helper-text"></span>                        
                </div>

                <div class="input-box">
                    <span class="text">Preferred Name</span>               
                    <input type="text" name="preferredName" placeholder="Enter your Preferred Name" id="preferredName" onfocusout="validatePreferredName()">
                    <span class="helper-text"></span>
                </div>

                <div class="input-box">
                    <span class="text">Username</span>
                    <input type="text" name="username" placeholder="Enter your Username" id="username" onfocusout="validateUserName()">
                    <span class="helper-text"></span>
                </div>

                <div class="input-box">
                    <span class="text">Email</span>
                    <input type="text" name="email" placeholder="Enter your email" id="email" onfocusout="validateEmail()">
                    <span class="helper-text"></span>
                </div>

                <div class="input-box">
                    <span class="text">Password</span>
                    <input type="password" name="password" placeholder="Enter your Password" id="password" onfocusout="validatePassword()">
                    <span class="helper-text"></span>
                 
                </div>

                <div class="input-box">
                    <span class="text">Confirm Password</span>
                    <input type="password" name="password_confirmation" placeholder="Confirm your password" id="password_confirmation" onfocusout="validateConfirmPassword()">
                    <span class="helper-text"></span>
                </div>


                 <div class="input-box">
                    <span class="text">Contact Number</span>
                    <input type="text" name="number" placeholder="0123 456 789">
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                  
                </div> 





               <div class="agree">
                    <span class="text">Are you agree with the terms and private policies provided by GDPR as a part of
                        the requirement in the register process?</span><br>
                    <input type="checkbox" class="btn-check" id="btn-check-outlined" autocomplete="off" required>
                    <label class="btn btn-outline-warning" for="btn-check-outlined">Agree</label><br />

                </div> 
            </div>
            <div class="space">
                <button type="submit" class="btn btn-warning">Submit</button>
 </div>
        </form>
    </div>

    <script src="validate.js"></script>

</body>
</html>