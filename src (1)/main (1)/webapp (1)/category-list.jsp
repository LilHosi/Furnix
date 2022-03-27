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
<title>Category</title>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>Material Design Lite</title>

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
        
        <h1>Category</h1>
        <a class="click-black" style="position: absolute; right: 10%;" href="category-add-form.jsp"><i class="fa-solid fa-plus"></i>ADD CATEGORY</a>
         <table class="mdl-data-table mdl-js-data-table">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Name</th>
      <th class="mdl-data-table__cell--non-numeric">Description</th>
      <th colspan="2" style="text-align: center;" class="mdl-data-table__cell--non-numeric">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="category" items="${CATEGORY_LIST}">
	<c:url var="updateLink" value="CategoryBOServlet">
		<c:param name="command" value="LOAD"></c:param>
		<c:param name="id" value="${category.id}"></c:param>
	</c:url>
	
	<c:url var="deleteLink" value="CategoryBOServlet">
		<c:param name="command" value="DELETE"></c:param>
		<c:param name="id" value="${category.id}"></c:param>
	</c:url>
    <tr>
      <td class="mdl-data-table__cell--non-numeric">${category.name}</td>
      <td class="mdl-data-table__cell--non-numeric">${category.description}</td>
      <td><a href="${updateLink}">Update</a></td>
		<td><a href="${deleteLink}" onclick="if (!(confirm('Delete this category?'))) return false;">Delete</a></td>
    </tr>
    

  </c:forEach>  
  </tbody>
</table>

<a class="click-black" href="category-add-form.jsp"><i class="fa-solid fa-plus"></i>ADD CATEGORY</a>
        </div>
      </main>


<%-- end of main dashboard area --%>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>