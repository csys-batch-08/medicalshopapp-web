
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="assets/images/medhublogo.png">
<meta name="theme-color" content="#ba8f88">
<link rel="stylesheet" href="assets/css/userHome.css">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<title>User Home</title>

<script>
    history.forward();
</script>


</head>

<body>

	<%-- <%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>--%>



	<div class="container-fluid p-0">
		<div class="nav">

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
					<img src="assets/images/medhublogo.png" alt="logo">
				</div>
			</nav>
		</div>



		<%-- <%=currentUser.getName()%> --%>
		<h2 id="userName" class="animate__animated animate__bounceIn">
			Welcome
			<c:out value="${sessionScope.user.userName}" />
		</h2>
	</div>
	<br>
	<br>

	<form action="filterProductservlet" class="prodSearch" method="get">
		<input id="searchBar" type="text" name="ProductName"
			required="required" placeholder="Search By Products & categories">
		<button type="submit" id="searchBtn">&#128269;</button>
	</form>



	<c:forEach items="${allProducts}" var="products">

		<div id="product">
			<div id="img">
				<img src="assets/images/${products.getProductImg()}" alt="horlicks">
				<h3>${products.getProductName()}</h3>

			</div>
			<div id="details">
				<h3>Description : ${products.getDescription()}</h3>
				<h3>Price :${products.getUnitPrice()} rs</h3>
				<h3>Offer : ${products.getOffer()}%</h3>
				<h3>Points : ${products.getPoints()}</h3>
			</div>
			<div id="btn">
				<a><button>
						<a id="buynow"
							href="showBuyProduct?pid=${products.getProductId()} ">Buy Now</a>
					</button></a>

			</div>
		</div>

		<br>
		<br>
	</c:forEach>



	<script src="assets/javascript/popupMessages.js"></script>
	<c:if test="${param.loginstatus!=null}">
		<script type="text/javascript"> showMessage('loginSucess')</script>
	</c:if>

	<div id="footer"></div>
	<script>

</script>
</body>

</html>
