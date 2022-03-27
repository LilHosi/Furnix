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
<title>Product</title>

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
        
        <h1>Product</h1>
        <a class="click-black" style="position: absolute; right: 10%;" href="product-add-form.jsp"><i class="fa-solid fa-plus"></i>ADD PRODUCT</a>
        
        <c:if test="${empty LOAD_PRODUCT}">
        
         <table class="mdl-data-table mdl-js-data-table">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Image</th>
      <th class="mdl-data-table__cell--non-numeric">Name</th>
      <th class="mdl-data-table__cell--non-numeric">Price</th>
      <th class="mdl-data-table__cell--non-numeric">Category Id</th>
      <th class="mdl-data-table__cell--non-numeric">Brand</th>
      <th colspan="3" style="text-align: center;" class="mdl-data-table__cell--non-numeric">Action</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="product" items="${PRODUCT_LIST}">
	<c:url var="updateLink" value="ProductBOServlet">
		<c:param name="command" value="LOAD"></c:param>
		<c:param name="id" value="${product.id}"></c:param>
	</c:url>
	
	<c:url var="deleteLink" value="ProductBOServlet">
		<c:param name="command" value="DELETE"></c:param>
		<c:param name="id" value="${product.id}"></c:param>
	</c:url>
	
	<c:url var="viewDetail" value="ProductBOServlet">
		<c:param name="command" value="LOAD_DETAIL"></c:param>
		<c:param name="id" value="${product.id}"></c:param>
	</c:url>
    <tr>
    	<td class="mdl-data-table__cell--non-numeric"><img src="${product.imageCode}" style="max-width: 150px;"></td>
      <td class="mdl-data-table__cell--non-numeric">${product.name}</td>
      <td class="mdl-data-table__cell--non-numeric">${product.price}</td>
      <td class="mdl-data-table__cell--non-numeric">${product.categoryId}</td>
      <td class="mdl-data-table__cell--non-numeric">${product.brand}</td>
      <td><a class="click-white" href="${updateLink}">Update</a></td>
		<td><a class="click-white" href="${deleteLink}" onclick="if (!(confirm('Delete this Product?'))) return false;">Delete</a></td>
   		<td><a class="click-white" href="${viewDetail}">View Detail</a></td>
    </tr>
  </c:forEach>  
  </tbody>
</table>

<a class="click-black" href="product-add-form.jsp"><i class="fa-solid fa-plus"></i>ADD PRODUCT</a>
        </c:if>
        
        <c:if test="${not empty LOAD_PRODUCT}">
        <table class="mdl-data-table mdl-js-data-table" style="max-width: 100vw">
    <tr>
    </tr>

	<c:url var="updateLink" value="ProductBOServlet">
		<c:param name="command" value="LOAD"></c:param>
		<c:param name="id" value="${LOAD_PRODUCT.id}"></c:param>
	</c:url>
	
	<c:url var="deleteLink" value="ProductBOServlet">
		<c:param name="command" value="DELETE"></c:param>
		<c:param name="id" value="${LOAD_PRODUCT.id}"></c:param>
	</c:url>
	
    <tr>
     <th class="mdl-data-table__cell--non-numeric">Image</th>
    	<td class="mdl-data-table__cell--non-numeric"><img src="${LOAD_PRODUCT.image}" style="width: 100px"></td>
     </tr>
     <tr>
      <th class="mdl-data-table__cell--non-numeric">Name</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.name}</td>
      </tr>
      <tr>
       <th class="mdl-data-table__cell--non-numeric">Size</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.size}</td>
      </tr>
      <tr>
      <th class="mdl-data-table__cell--non-numeric">Color</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.color}</td>
      </tr>
      <tr>
       <th class="mdl-data-table__cell--non-numeric">Production Country</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.productCountry}</td>
      </tr>
      <tr>
      <th class="mdl-data-table__cell--non-numeric">Materials</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.materials}</td>
      <tr>
      <tr>
      <th class="mdl-data-table__cell--non-numeric">Description</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.description}</td>
      </tr>
      <tr>
      <th class="mdl-data-table__cell--non-numeric">Price</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.price}</td>
      </tr>
      <tr>
      <th class="mdl-data-table__cell--non-numeric">Category Id</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.categoryId}</td>
      </tr>
      <tr>
      <th class="mdl-data-table__cell--non-numeric">Category Name</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.categoryName}</td>
      </tr>
      <tr>
       <th class="mdl-data-table__cell--non-numeric">Category Description</th>
      
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.categoryDescription}</td>
     </tr>
     <tr>
     <th class="mdl-data-table__cell--non-numeric">Brand</th>
      <td class="mdl-data-table__cell--non-numeric">${LOAD_PRODUCT.brand}</td>
      </tr>
      <tr>
     
   <td>   <a class="click-white" href="${updateLink}">Update</a></td>
	<td><a class="click-white" href="${deleteLink}" onclick="if (!(confirm('Delete this Product?'))) return false;"><i class="fa-solid fa-x"></i>Delete</a></td>
   	</tr>	
   </table>


<a class="click-black" href="ProductBOServlet"><i class="fa-solid fa-arrow-left"></i>Back to Product List</a>
<a class="click-submit" href="product-add-form.jsp"><i class="fa-solid fa-plus"></i>ADD PRODUCT</a>
        
        </c:if>
        </div>
      </main>


<%-- end of main dashboard area --%>
<a href="#header" id="view-source" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored mdl-color-text--white">View Source</a>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>