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

<body>
<jsp:include page="navigationBar.jsp"></jsp:include>
<div class="title section-p1">
<h1>Order History:</h1>
</div>

<div class="section-m1 section-p1">
<%-- <table>
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
</table> --%>
<c:if test="${empty orderDetails }">
<table style="width: 100%;">
<tr class="border">
<th>Order number</th>
<th>Date of Order</th>
<th>Total Price</th>
</tr>
<c:forEach items="${orders}" var="order">
<tr onclick="location.href='OrderServlet?orderId=${order.id}'" style="cursor:pointer;" class="click-white">
<td>${order.id}</td> 
<td>${order.submitDate}</td>
<td>${order.price}</td>
</tr>
</c:forEach>
</table>
</c:if>

<c:if test="${not empty orderDetails }">
<table style="width: 100%;">
<tr class="border">
<th>Order number</th>
<th>Product ID</th>
<th>Total Price</th>
</tr>
<c:forEach items="${orderDetails}" var="orderDetail">
<tr>
<td>${orderDetail.orderId}</td> 
<td onclick="location.href='ListProduct?productDetailId=${orderDetail.productId}'" class="click-black" target="_blank">${orderDetail.productId}</td>
<td>${orderDetail.quantity}</td>
</tr>
</c:forEach>
</table>
</c:if>
</div>
</body>
</html>