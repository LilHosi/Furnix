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
<title>Account</title>

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
        
        <h1>Account</h1>
        <a class="click-black" style="position: absolute; right: 10%;" href="account-add-form.jsp"><i class="fa-solid fa-plus"></i>ADD NEW ACCOUNT</a>
         <table class="mdl-data-table mdl-js-data-table">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Pronounce</th>
      <th class="mdl-data-table__cell--non-numeric">First Name</th>
      <th class="mdl-data-table__cell--non-numeric">Last Name</th>
      <th class="mdl-data-table__cell--non-numeric">Preferred Name</th>
      <th class="mdl-data-table__cell--non-numeric">Username</th>
      <th class="mdl-data-table__cell--non-numeric">Email</th>
      <th class="mdl-data-table__cell--non-numeric">Password</th>
      <th class="mdl-data-table__cell--non-numeric">Phone</th>
      <th colspan="2" style="text-align: center;" class="mdl-data-table__cell--non-numeric">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="account" items="${ACCOUNT_LIST}">
	<c:url var="updateLink" value="AccountBOServlet">
		<c:param name="command" value="LOAD"></c:param>
		<c:param name="id" value="${account.id}"></c:param>
	</c:url>
	
	<c:url var="deleteLink" value="AccountBOServlet">
		<c:param name="command" value="DELETE"></c:param>
		<c:param name="id" value="${account.id}"></c:param>
	</c:url>

    <tr>
      <td class="mdl-data-table__cell--non-numeric">${account.pronounce}</td>
		<td class="mdl-data-table__cell--non-numeric">${account.firstName}</td>
		<td class="mdl-data-table__cell--non-numeric">${account.lastName}</td>
		<td class="mdl-data-table__cell--non-numeric">${account.preferredName}</td>
		<td class="mdl-data-table__cell--non-numeric">${account.username}</td>
		<td class="mdl-data-table__cell--non-numeric">${account.email}</td>
		<td class="mdl-data-table__cell--non-numeric">${account.password}</td>
		<td class="mdl-data-table__cell--non-numeric">${account.phone}
      <td><a href="${updateLink}">Update</a></td>
		<td><a href="${deleteLink}" onclick="if (!(confirm('Delete this Account?'))) return false;">Delete</a></td>
    </tr>
    

  </c:forEach>  
  </tbody>
</table>

<a class="click-black" href="account-add-form.jsp"><i class="fa-solid fa-plus"></i>ADD NEW ACCOUNT</a>
        </div>
      </main>


<%-- end of main dashboard area --%>
<a href="https://github.com/google/material-design-lite/blob/mdl-1.x/templates/dashboard/" target="_blank" id="view-source" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored mdl-color-text--white">View Source</a>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>