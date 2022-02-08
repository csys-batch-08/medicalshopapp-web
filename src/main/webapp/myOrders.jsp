<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/Images/medhublogo.png">
<link rel="stylesheet" href="Assets/css/myOrders.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<title>My Orders</title>

</head>

<body>

	<div id="container">

		<div class="nav" class="container-fluid p-0">

			<nav class="list">
				<ul>
					<li><a href="index.jsp"><label>SignOut</label></a></li>
					<li><a href="showCartServlet"><label>Cart</label></a></li>
					<li><a href="showUserProfile"><label>MyProfile</label></a></li>
					<li><a
						href="myOrdersServlet?orderId=0&totalPrice=0&quantity=0&points=0&productId=0"><label>MyOrders</label></a></li>
					<li><a href="aboutUs.jsp"><label>About-Us</label></a></li>
					<li><a href="userHomeServlet"><label>Home</label></a></li>
				</ul>
				<div class="logo">
					<img
						src="https://uxwing.com/wp-content/themes/uxwing/download/21-medical-science-lab/healthcare.png"
						alt="logo">
				</div>
			</nav>
		</div>

		<script src="Assets/javascript/popupMessages.js"></script>
		<c:choose>
			<c:when test="${param.orderStatus!=null}">
				<script type="text/javascript"> showMessage('orderSucess')</script>
			</c:when>
		</c:choose>

		<div id="footer"></div>


		<jsp:useBean id="orderItem" class="com.medhub.dao.OrderItemsDaoImpl" />
		<jsp:useBean id="orderDao" class="com.medhub.dao.OrderDaoImpl" />
		<c:forEach items="${myOrders}" var="myAllOrders">



			<div id="product">
				<div id="img">
					<img
						src="Assets/Images/${myAllOrders.getProduct().getProductImg()}"
						alt="horlicks">
					<h3>${myAllOrders.getProduct().getProductName()}</h3>
				</div>
				<div id="details">

					<fmt:parseDate value="${myAllOrders.getOrderdate()}"
						pattern="yyyy-MM-dd" var="orderDate" type="date" />

					<h3>
						Order Date :
						<fmt:formatDate pattern="dd/MM/yyyy" value="${orderDate}" />
					</h3>
					<h3>Description : ${myAllOrders.getProduct().getDescription()}
					</h3>
					<h3>price : ${myAllOrders.getUnitPrice()}rs</h3>
					<h3>Offer Applied: ${myAllOrders.getProduct().getOffer() }%</h3>

					<h3 name="points">Points :
						${myAllOrders.getProduct().getPoints() }</h3>

					<h3 name="quantity">Total Quantity:
						${myAllOrders.getQuantity() }</h3>
					<h3 name="totalPrice">Total Amt :
						${myAllOrders.getTotalPrice() }rs</h3>
					<h3>Order Status :
						${myAllOrders.getOrderModel().getOrderStatus() }</h3>

					<h3 name="productId" id="productId">Order Date :
						${myAllOrders.getProduct().getProductId() }</h3>



				</div>
				<c:if
					test="${orderItem.cancelDate(myAllOrders.getOrderdate(),myAllOrders.getOrderModel().getOrderId())and orderDao.checkStatus(myAllOrders.getOrderModel().getOrderId())}">
					<div id="btn">
						<button>
							<a id="cancel" onclick="check()"
								href="cancelOrderServlet?orderId=${myAllOrders.getOrderModel().getOrderId()}&quantity=${myAllOrders.getQuantity()}
							&totalPrice=${myAllOrders.getTotalPrice()} &points=${myAllOrders.getProduct().getPoints()}&productId=${myAllOrders.getProduct().getProductId()}">Cancel
								Order</a>
						</button>
						<br>
					</div>
				</c:if>

			</div>

			<br>
			<br>
		</c:forEach>

	</div>




</body>
<script src="Assets/javascript/myOrders.js"></script>


</html>
