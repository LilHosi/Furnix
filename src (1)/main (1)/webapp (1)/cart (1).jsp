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
<title>Cart Summary</title>
</head>
	<jsp:include page="navigationBar.jsp"></jsp:include>
<body>
<section style="padding: 50px 100px;
">
	<div class="title section-p1">
		<h1>Cart Summary:</h1>
	</div>

	<c:if test="${cart.getProducts().size() < 1}">
	<c:if test="${not empty confirmation}">
		<div class="container section p1">
		<i class="fa-solid fa-clipboard-check" style="font-size: 80px;"></i> <br>
		<H2>ALL DONE!</H2>
		<P> Thank you, your order has been made. <br>
		Please check your email for receipt confirmation.</P>
		
		<br>
					<a class="click-black" href="HomeServlet">CONTINUE SHOPPING</a>
		
		</div>
	</c:if>
	<c:if test="${empty confirmation}">
		<div class="container section-p1">
			<h5>There is no item in cart at the moment.</h5>
			<br>
			<br>
			<a class="click-black" href="HomeServlet">CONTINUE SHOPPING</a>

		</div>
		</c:if>
	</c:if>

<div class="modal fade" id="guestModal" tabindex="-1"
										role="dialog" aria-labelledby="productModal"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Checkout as Guest</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
<c:set var="check" value="false"></c:set>
													<div class="container">
													<div class="section-m1" id="smart-button-container">
		<div style="text-align: center;">
			<div id="paypal-button-container"></div>
		</div>
	</div>
	<script
		src="https://www.paypal.com/sdk/js?client-id=ARnhNKZ7-8euw3i01bAF_pR5uI6qZCJR-cWfbaluo1IeIm4Mpoi1cOb4OvZICCLycn-UvbWrMbVg04xA&currency=USD"
		data-sdk-integration-source="button-factory"></script>
	<script>
		function initPayPalButton() {
			paypal.Buttons({style : {
									shape : 'pill',
									color : 'white',
									layout : 'vertical',
									label : 'paypal',},
			createOrder : function(data, actions) {
			return actions.order.create({
			purchase_units : [ {
				"amount" : {
				"currency_code" : "USD",
				"value" : 0.01
								}
								} ]
							});
					},
			onApprove : function(data, actions) {
			return actions.order
					.capture()
					.then(
					function(orderData) {
					// Full available details
			console
				.log(
					'Capture result',
					orderData,
			JSON
				.stringify(
					orderData,
					null,
					2));
				// Show a success message within this page, e.g.
				const element = document
				.getElementById('paypal-button-container');
				element.innerHTML = '';
				element.innerHTML = '<h3>Thank you for your payment!</h3>';
// Or go to another URL:  actions.redirect('thank_you.html');
				});
					},
					onError : function(err) {
							console.log(err);
							}
						}).render('#paypal-button-container');
		}
		initPayPalButton();
	</script>
			</div>
															
													</div>
												</div>

											</div>
										</div>
									</div>
<div class="modal fade" id="loginModal" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Sign In <i class="fa-solid fa-right-to-bracket"></i></h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">

													<div class="container">
														<form action="LoginCheckout" method="post">
															<div class="detail">
																<div class="input-box">
																	<span class="text">Username</span> <input class="click-white" type="text"
																		name="username" placeholder="Enter your Username">
																</div>

																<div class="input-box">
																	<span class="text">Password</span> <input
																		class="click-white"
																		type="password" name="password"
																		placeholder="Enter your Password">
																</div>
															</div>
															<div class="space">
																<input class="click-black" type="submit" name="status" value="CURRENT CUSTOMER">
																</div>
																<div class="modal-footer">
																	<!--         <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Login</button> -->
																</div>
																<a class="text" href="forgotpass.jsp"
																	style="color: #DAA853;">Forgot password?</a>
															

														</form>
														<a href="register.jsp" style="color: grey;">Don't have
															account? - Register</a>
													</div>
												</div>

											</div>
										</div>
									</div>
		
		
<div class="modal fade" id="addressModal" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Enter Shipping Address to Continue <i class="fa-solid fa-address-card"></i></h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">

													<div class="container">
														<form action="CartServlet" method="post">
														<input hidden="true" name="command" value = "SUBMIT_CART">
															<div class="detail">
																<div class="input-box">
																	<span class="text">Shipping Address</span> 
																	<input class="click-white"
																style="width: 400px;"
																	 type="text"
																		name="address" placeholder="Enter your Shipping Address">
																</div>

																
															</div>
															
																
																
																<input class="click-submit" type="submit" name="status" value="CURRENT CUSTOMER"> 
															
															
																
														</form>
														
													</div>
												</div>

											</div>
										</div>
									</div>
																

	<c:if test="${not empty cart && cart.getProducts().size()>0}">
		<div id="cart" class="section-p1">
			<form method="get" action="CartServlet">
				<div class="detail">
					<!-- <input hidden="true" name ="command" value="SUBMIT_CART"> -->
<table>
							<tr>
								<th colspan=3>Item</th>
								<th class="center">Quantity</th>
								<th class="center">Price</th>
							</tr>
							
					<c:forEach var="item" items="${cart.getProducts()}"
						varStatus="status">

					
							<tr class="border">
								<td>${status.count}</td>
								<td><img src="${item.key.imageCode}" style="width: 50px">
								</td>
								<td style="width: 400px;"><h3>${item.key.name}</h3>
								<br/> ${item.key.color}
								</td>
								<td style="display: flex;justify-content: center;">
								<table style="width: 120px">
								<tr class="center" style="height: 50px;">
								<td ><c:if test="${item.value == 1}">
										<a class="click-black-small" href="CartServlet?command=REMOVE&productId=${item.key.id}"
											onclick="if (!(confirm('Do you want to remove this item: ${item.key.name}?'))) return false;">
											- </a>
									</c:if> <c:if test="${item.value > 1}">
										<a class="click-black-small"
											href="CartServlet?command=DECREASE&productId=${item.key.id}">
											- </a>
									</c:if></td> 
									<td>${item.value} </td>
									<td><a class="click-black-small"
									href="CartServlet?command=INCREASE&productId=${item.key.id}">
										+ </a></td>
									</tr>
									
									<tr>
									<td colspan="3" class="right"><a
									href="CartServlet?command=REMOVE&productId=${item.key.id}"
									onclick="if (!(confirm('Do you want to remove this item: ${item.key.name}?'))) return false;">
										<span class="click-black">Remove</span>
								</a></td>
									</tr>
								</table>
										</td>
								<td class="center" style="width: 100px;">${item.key.price}</td>
								
							</tr>

	

					</c:forEach>
					</table>
				</div>
					<input hidden="true" name="command" value="DISCOUNT">
						
				<div class="summary">
					<h2>Order Summary</h2>
					<table>
						<tr>
						<th colspan="2"> 
						<br>
						</th>
						
						</tr>
						<tr>
							<td class="left"><h4>Subtotal</h4></td>
							<td class="right"><h4>${subtotal}</h4>
						</tr>
							
						<tr>
						<td><input class="click-white" type="text" placeholder="discount"  name="discountCode"></td>
						
						<td><button type="submit" class="click-black">Get Discount</button>
						</tr>
						
						<tr>
						<td colspan="2"><hr></td>
						</tr>
						
						<tr>
							<td><h3>Total</h3></td>
							<c:if test="${empty total }">
							<td class="right">${subtotal }</td>
							</c:if>
							
							<c:if test="${not empty total }">
							<td class="right">${total }</td>
							</c:if>
							
						</tr>

						<tr>
							<td colspan="2"><c:if test="${empty sessionScope.me}">
									<div class="click-submit" style="display: block;"
										data-toggle="collapse" href="#collapseCheckout" role="button"
										aria-expanded="true" aria-controls="collapseCheckout">CHECK
										OUT AS <i class="fa-solid fa-arrow-right"></i>
										</div>
									<div class="collapse" id="collapseCheckout">
										<div style="display: flex; justify-content: space-around">
											<a class="click-black" class="click-submit"
												data-toggle="modal" data-target="#guestModal">Guest</a>
											<!-- <a  class="click-submit" data-toggle="modal" data-target="loginModal">Current Customer</a> 
 -->
											<button type="button" class="click-submit"
												data-toggle="modal" data-target="#loginModal">
												Current Customer</button>
										</div>
									</div>							
								</c:if> <c:if test="${not empty sessionScope.me}">
								<button type="button" class="click-submit"
												data-toggle="modal" data-target="#addressModal">
												CHECK OUT</button>
									
								</c:if></td>
						</tr>
					</table>
				</div>
				<!-- <input type="button" value="Check out"></input> -->
			</form>
		</div>
	</c:if>

	<!-- <h2 style="text-align: center;">
		<a href="OrderServlet">Order history</a>
	</h2> -->
</section>
<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>