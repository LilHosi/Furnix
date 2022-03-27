<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="home.jsp">FURNIX</a>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			
			
			<li class="nav-item">
        <a class="nav-link" href="ListProduct?selectCategory=1">
          | Kitchen
        </a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="ListProduct?selectCategory=2">
          | Bedroom
        </a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="ListProduct?selectCategory=3">
          | Study
        </a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="ListProduct?selectCategory=4">
          | Outdoor
        </a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="information.jsp">
          | About us
        </a>
        </li>
  
		
				
			</ul>
			
			
      <form action="SearchServlet" method="get">
      <input style="width: 400px; background-color: #f5f5f5" class="click" type="text" placeholder="Search product ..." name="search">
      <button class="click-white" type="submit"><i class="fa fa-search"></i></button>
 </form>
 
			<c:if
						test="${not empty sessionScope.me}">
						<div class="dropdown show" style="margin: 0 10px;">
  <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Welcome, ${sessionScope.me.firstName} 
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="profile.jsp"><i class="fa-solid fa-user"></i> | Profile </a>
    <a class="dropdown-item" href="OrderServlet"><i class="fa-solid fa-clock-rotate-left"></i> | Purchase History </a>
    <a class="dropdown-item" href="LoginServlet?command=logout"><i class="fa-solid fa-arrow-right-from-bracket"></i> | Logout </a>
  </div>
</div>
						<%-- <a class="nav-link" href="LoginServlet?command=logout">|
							Logout, ${sessionScope.me.firstName} </a> --%>
					</c:if> <c:if test="${empty sessionScope.me}">
						<a class="nav-link" href="LoginServlet?command=login" target="_blank">Login <i class="fa-solid fa-arrow-right-to-bracket"></i></a>
					</c:if>
			<a href="CartServlet?command=VIEW_CART">| <i class="fa-solid fa-cart-shopping"></i>  (${sessionScope.cart.products.size()})</a>
		</div>
	</nav> 