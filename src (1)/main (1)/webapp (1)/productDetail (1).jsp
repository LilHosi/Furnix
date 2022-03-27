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
<title>Product Details</title>
</head>

<body>
	<jsp:include page="navigationBar.jsp"></jsp:include>
	<c:if test="${empty productDetail}">
	<jsp:include page="header.jsp"></jsp:include>
	</c:if>

	<!-- CATEGORY BUTTONS -->
	<div id="product-page" style="padding-top: 20px">
	
<!-- 	FILTER -->
		<aside id="byCategory">
		
			<!-- LIST CATEGORIES -->
			<h3>CATEGORY</h3>
			<hr>
			<div class="click-black" onclick="location.href='HomeServlet'">All Products</div>
			<c:forEach items="${categories}" var="category">
				<div class="click"
					onclick="location.href='ListProduct?selectCategory=${category.id}'">
					${category.name}<br />
				</div>
			</c:forEach>
			<!-- END OF LIST CATEGORIES -->
			<!-- FILTER -->
			<c:if test="${selectCategory == null}">
<h3><i class="fa-solid fa-filter"></i> | FILTER ALL PRODUCT</h3>
<hr>

<form action="HomeServlet" method="get">
<table style="max-width: 25vw">
  <tr>
  <td>Products Per Page</td>
 <td> <select class="click-black" style="width: 250px;" name="selectView">
  	<option value="6">6 Products</option>
  	<option value="9">9</option>
  	<option value="12">12</option>
  </select>
  </td>
  </tr>
  </table>


<a class="click-black" style="display: block;"
					data-toggle="collapse" href="#collapseFilter" role="button"
					aria-expanded="true" aria-controls="collapseFilter"><i class="fa-solid fa-filter"></i> | More Filters</a>
<div class="collapse" id="collapseFilter">
<table style="max-width: 25vw">
<tr>
<td>By Brand</td>
<td> <select class="click-black" style="width: 250px;" name="selectBrand">
 	<option value="default">Show all brand</option>
  <c:forEach items="${brand}" var="brand">
    <option value="${brand}">${brand}</option>
  </c:forEach>
  </select> </td>
</tr>
<tr>
 <td>By Price</td>
 <td> <select class="click-black" style="width: 250px;" name="selectPrice">
  	<option value="default">Show all price</option>
    <option value="0/50">$0 - $50</option>
    <option value="51/200">$51 - $200</option>
    <option value="201/3000">Over $200</option>
  </select> </td>
</tr>
<tr>
<td>Sort - Order</td>
  <td>  <select class="click-black" style="width: 250px;" name="selectSort">
  	<option value="default">Default view</option>
    <option value="price in ascending order">Low to High</option>
    <option value="price in descending order">High to Low</option>
    <option value="name from A to Z">A to Z</option>
    <option value="name from Z to A">Z to A</option>
  </select></td>
  </tr>
</table>

</div>
<button class="click" type="submit"> Check option </button>
</form>

</c:if>

<c:if test="${selectCategory != null}">
<h3>FILTER BY - ${categoryName}</h3>
<hr>

<form action="ListProduct" method="get">
  <input name = "selectCategory" value= "${selectCategory}" hidden="true">
 <%-- <select name="selectCategory">
<option value="${selectCategory}">${categoryName}</option>
 </select> --%>
 <table style="max-width: 25vw">
 <tr> <td>Products Per Page</td>
 	  <td> <select class="click-black" style="width: 250px;" name="selectView">
  	<option value="6">6 Products</option>
  	<option value="9">9</option>
  	<option value="12">12</option>
  </select>
 	 </td>
</tr>

<tr> <td colspan="2">
<a class="click-black" style="display: block;"
					data-toggle="collapse" href="#collapseFilter" role="button"
					aria-expanded="true" aria-controls="collapseFilter">More Filter</a>
</td>
</tr>
</table>
<div class="collapse" id="collapseFilter">
<table style="max-width: 25vw">
<tr>
 	<td>By brand</td>
 	<td><select class="click-black" style="width: 250px;" name="selectBrand">
 	<option value="default">Show all brand</option>
  <c:forEach items="${brand}" var="brand">
    <option value="${brand}">${brand}</option>
  </c:forEach>
  </select></td>
</tr>
<tr>
  	<td>By price</td>
 	<td> <select class="click-black" style="width: 250px;" name="selectPrice">
  	<option value="default">Show all price</option>
    <option value="0/50">$0 - $50</option>
    <option value="51/200">$51 - $200</option>
    <option value="201/3000">Over $200</option>
  </select> </td>
</tr>
<tr>
 	<td> Sort</td>
 	<td> <select class="click-black" style="width: 250px;" name="selectSort">
  	<option value="default">Default view</option>
    <option value="price in ascending order">Low to High</option>
    <option value="price in descending order">High to Low</option>
    <option value="name from A to Z">A to Z</option>
    <option value="name from Z to A">Z to A</option>
  </select> </td>
 </tr>
   </table>
 </div>

<button class="click" type="submit"> Check option </button>
</form>

</c:if>
<!-- END OF FILTER -->

	</aside>

	<section id="productList" class="container">
	
	<!-- PRODUCT ALL  -->
	<c:if test="${not empty productA}">
<!-- NEW ARRIVAL -->
<h2>NEW ARRIVAL:</h2>
			<div class="pro-container section-p1">
				<c:forEach items="${newA}" var="productDetail">
					<div class="pro"
						onclick="location.href='ListProduct?productDetailId=${productDetail.id}'"
						style="cursor: pointer;">
						<img src="${productDetail.imageCode}">
						<div class="des">
							<c:if test="${empty productDetail.brand}">
								<h6>ZANUI</h6>
							</c:if>
							<h6>${productDetail.brand }</h6>
							<h3>${productDetail.name}</h3>
							<h5>${productDetail.price }AUD</h5>
						</div>
					</div>
				</c:forEach>
			</div>
			<hr>
<!-- END OF NEW ARRIVAL -->
<%-- <h4>${filterHeader}</h4> --%>



<h5>${filterMes}</h5>
<div class="pro-container section-p1">
				<c:forEach items="${productA}" var="productDetail">
					<div class="pro"
						onclick="location.href='ListProduct?productDetailId=${productDetail.id}'"
						style="cursor: pointer;">
						<img src="${productDetail.imageCode}">
						<div class="des">
							<c:if test="${empty productDetail.brand}">
								<h6>ZANUI</h6>
							</c:if>
							<h6>${productDetail.brand }</h6>
							<h3>${productDetail.name}</h3>
							<h5>${productDetail.price }AUD</h5>
						</div>
					</div>
				</c:forEach>
			</div>


<c:if test="${selectBrand != null && selectPrice != null && selectSort != null && selectView != null}">
<div>
	<ul>
		<c:if test="${tagA > 1}">
		<a href="HomeServlet?selectBrand=${selectBrand}&selectPrice=${selectPrice}&selectSort=${selectSort}&selectView=${selectView}&index=${tagA-1}">Previous</a>
		</c:if>
			<c:forEach begin="1" end="${endPA}" var="i">
			<a class="${tagA == i?"active":""}" href="HomeServlet?selectBrand=${selectBrand}&selectPrice=${selectPrice}&selectSort=${selectSort}&selectView=${selectView}&index=${i}">${i}</a>	
			</c:forEach>
		<c:if test="${tagA < endPA}">
		<a href="HomeServlet?selectBrand=${selectBrand}&selectPrice=${selectPrice}&selectSort=${selectSort}&selectView=${selectView}&index=${tagA+1}">Next</a>
		</c:if>
	</ul>
</div> 
</c:if>
<c:if test="${selectBrand == null && selectPrice == null && selectSort == null}">
<div>
	<ul>
		<c:if test="${tagA > 1}">
		<a href="HomeServlet?index=${tagA-1}">Previous</a>
		</c:if>
			<c:forEach begin="1" end="${endPA}" var="i">
			<a class="${tagA == i?"active":""}" href="HomeServlet?index=${i}">${i}</a>	
			</c:forEach>
		<c:if test="${tagA < endPA}">
		<a href="HomeServlet?index=${tagA+1}">Next</a>
		</c:if>
	</ul>
</div> 
</c:if>
</c:if>
<!-- END OF PRODUCT END -->

	<!-- PRODUCT SEARCH -->
 <c:if test="${not empty productS}">
 <h2>PRODUCT SEARCH</h2>
 <div class="pro-container section-p1">
				<c:forEach items="${productS}" var="productDetail">
					<div class="pro"
						onclick="location.href='ListProduct?productDetailId=${productDetail.id}'"
						style="cursor: pointer;">
						<img src="${productDetail.imageCode}">
						<div class="des">
							<c:if test="${empty productDetail.brand}">
								<h6>ZANUI</h6>
							</c:if>
							<h6>${productDetail.brand }</h6>
							<h3>${productDetail.name}</h3>
							<h5>${productDetail.price }AUD</h5>
						</div>
					</div>
				</c:forEach>
			</div>
 <div>
	<ul>
		 <c:if test="${tagS > 1}">
		<a href="SearchServlet?search=${textSearch}&index=${tagS-1}">Previous</a>
		</c:if>
			<c:forEach begin="1" end="${endPS}" var="i">
			<a  class="${tagS == i?"active":""}" href="SearchServlet?search=${textSearch}&index=${i}">${i}</a>	
			</c:forEach>
		<c:if test="${tagS < endPS}">
		<a href="SearchServlet?search=${textSearch}&index=${tagS+1}">Next</a>
		</c:if>
	</ul>
</div>
</c:if>
<!-- END OF PRODUCT SEARCH -->

<!-- PRODUCT FILTER CHECK -->
<c:if test="${not empty productC}">
<h5>${filterMes}</h5>
<div class="pro-container section-p1">
				<c:forEach items="${productC}" var="productDetail">
					<div class="pro"
						onclick="location.href='ListProduct?productDetailId=${productDetail.id}'"
						style="cursor: pointer;">
						<img src="${productDetail.imageCode}">
						<div class="des">
							<c:if test="${empty productDetail.brand}">
								<h6>ZANUI</h6>
							</c:if>
							<h6>${productDetail.brand }</h6>
							<h3>${productDetail.name}</h3>
							<h5>${productDetail.price }AUD</h5>
						</div>
					</div>
				</c:forEach>
			</div>

<c:if test="${selectBrand != null && selectPrice != null && selectSort != null && selectView != null}">
<div>
	<ul>
		<c:if test="${tagA > 1}">
		<a href="ListProduct?selectCategory=${selectCategory}&selectBrand=${selectBrand}&selectPrice=${selectPrice}&selectSort=${selectSort}&selectView=${selectView}&index=${tagA-1}">Previous</a>
		</c:if>
			<c:forEach begin="1" end="${endPA}" var="i">
			<a class="${tagA == i?"active":""}" href="ListProduct?selectCategory=${selectCategory}&selectBrand=${selectBrand}&selectPrice=${selectPrice}&selectSort=${selectSort}&selectView=${selectView}&index=${i}">${i}</a>	
			</c:forEach>
		<c:if test="${tagA < endPA}">
		<a href="ListProduct?selectCategory=${selectCategory}&selectBrand=${selectBrand}&selectPrice=${selectPrice}&selectSort=${selectSort}&selectView=${selectView}&index=${tagA+1}">Next</a>
		</c:if>
	</ul>
</div> 
</c:if>
<c:if test="${selectBrand == null && selectPrice == null && selectSort == null}">
<div>
	<ul>
		<c:if test="${tagA > 1}">
		<a href="ListProduct?selectCategory=${selectCategory}&index=${tagA-1}">Previous</a>
		</c:if>
			<c:forEach begin="1" end="${endPA}" var="i">
			<a class="${tagA == i?"active":""}" href="ListProduct?selectCategory=${selectCategory}&index=${i}">${i}</a>	
			</c:forEach>
		<c:if test="${tagA < endPA}">
		<a href="ListProduct?selectCategory=${selectCategory}&index=${tagA+1}">Next</a>
		</c:if>
	</ul>
</div> 
</c:if>
</c:if>

<!-- END OF PRODUCT FILTER CHECK -->


<!-- PRODUCT DETAILS -->
<c:if test="${not empty productDetail}">
			<form method="get" action="CartServlet">
				<input hidden="true" name="productId" value="${productDetail.id}">
				<input hidden="true" name="command" value="ADD_TO_CART"> <input
					hidden="true" name="categoryId" value="${productDetail.categoryId}">
				<section class="product section-p1">
					<div class="row">
					<div class="col-md-10 col-sm-12 col-12">
						<h2>${productDetail.name}</h2>
							<p>${productDetail.description}</p>
					</div>
						<div class="col-lg-7 col-md-12 col-12">
							<img class="img-fluid" src="${productDetail.imageCode}">
						</div>
						<div class="col-lg-4 col-md-12 col-12 info">
							<!-- <h6>Home / Clothes</h6> -->
						
						
							<h4>Size</h4>
							<h5>${productDetail.size}</h5>
							<br>

							<h4>Color</h4>
							<h5>${productDetail.color}</h5>
							<br>

							<h4>Country</h4>
							<h5>${productDetail.country}</h5>
							<br>
							<h4>Material</h4>
							<h5>${productDetail.material}</h5>
							<br>
							<hr>
							<h3>${productDetail.price}</h3>
							<input class="click-white" type="number" value="1" name="quantity">
							<div class="space">
								<%-- <a href="CartServlet?command=ADD_TO_CART&productId=${productDetail.id}&categoryId=${cateId}"> --%>
								
								<button type="button" class="click-submit" 
												data-toggle="modal" data-target="#productModal">
												<i class="fa-solid fa-cart-shopping"></i>  ADD TO CART</button>
								
								<!-- CART SUMMARY MODAL -->
<div class="modal fade" id="productModal" tabindex="-1"
										role="dialog" aria-labelledby="productModal"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Your current bill is  <%-- ${cart.getProducts().size()} items in your Cart --%>: $${subtotal + Float.parseFloat(productDetail.price)}</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
<c:set var="check" value="false"></c:set>
													<div class="container">
													<div style="display: flex; margin: 10px 0;">
														<img src="${productDetail.imageCode}" style="width: 50px; object-fit: scale-down;"> 
														<div style="padding-left: 10px;">
														<h5>${productDetail.name}</h5>
														<h3>${productDetail.price}</h3>
														</div>
														</div>
														
														<h6 style="text-align: center;"><i class="fa-solid fa-angle-down"></i></h6>
														
														
														<c:forEach var="item" items="${cart.getProducts()}"
						varStatus="status">
						
															<div style="display: flex; margin: 10px 0;">
														<img src="${item.key.imageCode}" style="width: 50px; object-fit: scale-down;"> 
														<div style="padding-left: 10px;">
														<h5>${item.key.name}</h5>
														
															<h6>Qty: ${item.value}</h6>
															
														</div>
														</div>
			</c:forEach>
			<c:if test="${check.equals('false')}">
			
			</c:if>
															<!-- <div class="space">
																<input class="click-black" type="submit" value="Login">
																</div> -->
														
																<div class="modal-footer" style="display: flex; justify-content:space-around; ">
																	<!-- <button class="click-white">CONTINUE SHOPPING</button> -->
																	<%-- <a class="click-white" href="CartServlet?location=HOME">CONTINUE SHOPPING</a>
																	<a class="click-black" href="CartServlet?command=ADD_TO_CART&productId=${productDetail.id}&categoryId=${productDetail.categoryId}&location=CART">GO TO CART</a>
																	<a class="click-submit" href="CartServlet?command=ADD_TO_CART&productId=${productDetail.id}&categoryId=${cateId}">CHECKOUT</a> --%>
																	<input type="submit" class="click-black"  name="location" value="CONTINUE SHOPPING">
									
									
																	<input type="submit" class="click-black"  name="location" value="GO TO CART">
																	<!-- <button class="click-black" onclick="window.location.href='cart.jsp'"><i class="fa-solid fa-cart-shopping"></i>  GO TO CART</button>
																	<button class="click-submit">CHECKOUT</button> -->
																</div>
															
													</div>
												</div>

											</div>
										</div>
									</div>
									

									
<!-- END OF CART SUMMARY MODAL -->
								
								
								<!-- </a> -->
							</div>
						</div>

					</div>
				</section>
			</form>
		</c:if>
<!-- END OF PRODUCT DETAILS -->
	</section>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>