<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Check out</title>
</head>
<body>
<jsp:include page="navigationBar.jsp"></jsp:include>
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
</body>
</html>