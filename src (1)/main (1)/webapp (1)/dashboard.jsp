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
<title>Dashboard</title>

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
<%-- There are ${countCategory} categories <br/>
There are ${countProduct} products <br/>
There are ${countAccount} accounts <br/> --%>
<%-- main dashboard area (show statistics) --%>
      <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">
          <div onclick="window.location.href='CategoryBOServlet'" class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--3-col mdl-grid">
            <div class="number">
            <h2>${countCategory}</h2>
            <h3>Categories</h3>
            </div>
             <div class="dashboard-icon">
            <i class="fa-solid fa-list"></i>
            </div>
          </div>
           <div onclick="window.location.href='ProductBOServlet'" class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--3-col mdl-grid">
            <div class="number">
            <h2>${countProduct}</h2>
            <h3>Products</h3>
            </div>
             <div class="dashboard-icon">
           <i class="fa-solid fa-couch"></i>
            </div>
          </div>
           <div onclick="window.location.href='AccountBOServlet'" class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--3-col mdl-grid">
            <div class="number">
            <h2>${countAccount}</h2>
            <h3>Customers</h3>
            </div>
             <div class="dashboard-icon">
           <i class="fa-solid fa-user-group"></i>
            </div>
          </div>
          
           <div onclick="window.location.href='OrderBOServlet'" class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--3-col mdl-grid">
            <div class="number">
            <h2>${countOrder}</h2>
            <h3>Orders</h3>
            </div>
             <div class="dashboard-icon">
            <i class="fa-solid fa-cart-shopping"></i>
            </div>
          </div>
          
          <%-- best seller --%>
 <%-- <h1>Best Seller Products This Month</h1>
<c:forEach var="bestSeller" items="${bestSeller}">
Product Image: <img src="${bestSeller.productImage}">
Product Name: ${bestSeller.productName} <br/>
</c:forEach>  --%>
<%-- end of best seller --%>

<%-- income each month --%>
 <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--6-col mdl-grid">
            <div class="number">
            <h2>$${income}</h2>
            <h3>Income This Month</h3>
            </div>
             <div class="dashboard-icon">
            <i class="fa-solid fa-coins"></i>
            </div>
          </div>


<%-- end of income --%>
       	
         <!-- <!--  <div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">
            <svg fill="currentColor" viewBox="0 0 500 250" class="demo-graph">
              <use xlink:href="#chart" />
            </svg>
            <svg fill="currentColor" viewBox="0 0 500 250" class="demo-graph">
              <use xlink:href="#chart" />
            </svg>
          </div>
          <div class="demo-cards mdl-cell mdl-cell--4-col mdl-cell--8-col-tablet mdl-grid mdl-grid--no-spacing">
            <div class="demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop">
              <div class="mdl-card__title mdl-card--expand mdl-color--teal-300">
                <h2 class="mdl-card__title-text">Updates</h2>
              </div>
              <div class="mdl-card__supporting-text mdl-color-text--grey-600">
                Non dolore elit adipisicing ea reprehenderit consectetur culpa.
              </div>
              <div class="mdl-card__actions mdl-card--border">
                <a href="#" class="mdl-button mdl-js-button mdl-js-ripple-effect">Read More</a>
              </div>
            </div>
            <div class="demo-separator mdl-cell--1-col"></div>
            <div class="demo-options mdl-card mdl-color--deep-purple-500 mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--3-col-tablet mdl-cell--12-col-desktop">
              <div class="mdl-card__supporting-text mdl-color-text--blue-grey-50">
                <h3>View options</h3>
                <ul>
                  <li>
                    <label for="chkbox1" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                      <input type="checkbox" id="chkbox1" class="mdl-checkbox__input">
                      <span class="mdl-checkbox__label">Click per object</span>
                    </label>
                  </li>
                  <li>
                    <label for="chkbox2" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                      <input type="checkbox" id="chkbox2" class="mdl-checkbox__input">
                      <span class="mdl-checkbox__label">Views per object</span>
                    </label>
                  </li>
                  <li>
                    <label for="chkbox3" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                      <input type="checkbox" id="chkbox3" class="mdl-checkbox__input">
                      <span class="mdl-checkbox__label">Objects selected</span>
                    </label>
                  </li>
                  <li>
                    <label for="chkbox4" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                      <input type="checkbox" id="chkbox4" class="mdl-checkbox__input">
                      <span class="mdl-checkbox__label">Objects viewed</span>
                    </label>
                  </li>
                </ul>
              </div>
              <div class="mdl-card__actions mdl-card--border">
                <a href="#" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-color-text--blue-grey-50">Change location</a>
                <div class="mdl-layout-spacer"></div>
                <i class="material-icons">location_on</i>
              </div> 
            </div>
          </div>
        </div> -->
      </main>
    </div>


<%-- end of main dashboard area --%>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>