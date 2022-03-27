<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./material.min.css">
<script src="./material.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://kit.fontawesome.com/76af9337dc.js" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Update Account Information</title>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">


    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

   <!--  <link rel="shortcut icon" href="images/favicon.png"> -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="style-dash.css">
    
    <style>
    #view-source {
      position: fixed;
      display: block;
      right: 0;
      bottom: 0;
      margin-right: 40px;
      margin-bottom: 40px;
      z-index: 900;
    }
    </style>
</head>
<body>
<%-- header area --%>
 <jsp:include page="dashboard-header.jsp"></jsp:include> 
<%-- end of header area --%>

<%-- main dashboard area (show statistics) --%>
      <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">
        <div class="dash-content">
         <h1>Account</h1>
         
 		<h3>Update Account Information</h3>
        <form action="AccountBOServlet" method="GET">
<input type="hidden" name="command" value="UPDATE" />
<input type="hidden" name="id" value="${LOAD_ACCOUNT.id}" />

  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="sample3" name="pronounce" value="${LOAD_ACCOUNT.pronounce}">
    <label class="mdl-textfield__label" for="sample3">Pronounce</label>
  </div>
  <br/>
  	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="sample5" name="firstName"  value="${LOAD_ACCOUNT.firstName}"></input>
    <label class="mdl-textfield__label" for="sample5">First Name</label>
  </div>
  <br/>
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="sample5" name="lastName" value="${LOAD_ACCOUNT.lastName}"></input>
    <label class="mdl-textfield__label" for="sample5">Last Name</label>
  </div>
  <br/>
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="sample5" name="preferredName" value="${LOAD_ACCOUNT.preferredName}"></input>
    <label class="mdl-textfield__label" for="sample5">Preferred Name</label>
  </div>
  <br/>
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="sample5" name="username" value="${LOAD_ACCOUNT.username}"></input>
    <label class="mdl-textfield__label" for="sample5">Username</label>
  </div>
  <br/>
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text"  id="sample5" name="email" value="${LOAD_ACCOUNT.email}"></input>
    <label class="mdl-textfield__label" for="sample5">Email</label>
  </div>
  <br/>
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text"  id="sample5" name="password" value="${LOAD_ACCOUNT.password}"></input>
    <label class="mdl-textfield__label" for="sample5">Password</label>
  </div>
  <br/>
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text"  id="sample5" name="phone" value="${LOAD_ACCOUNT.phone}"></input>
    <label class="mdl-textfield__label" for="sample5">Phone</label>
  </div>
  <br/>
  <a class="click-black" href="AccountBOServlet"><i class="fa-solid fa-arrow-left"></i> Back to Account List</a>
  <input class="click-submit" type="submit" value="Save" />
  
</form>

</div>
        </div>
      </main>


<%-- end of main dashboard area --%>
<a href="https://github.com/google/material-design-lite/blob/mdl-1.x/templates/dashboard/" target="_blank" id="view-source" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored mdl-color-text--white">View Source</a>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>