<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="assets/images/medhublogo.png">
<link rel="stylesheet" href="assets/css/salesReports2.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<title>Sales Report</title>



</head>
<body>
	<%-- <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
 --%>
	<div id="container">
		<div id="navigation">
			<ul>
				<li><a href="allUsers">All Users</a></li>
				<li><a href="adminAllProducts">All Products</a></li>
				<li><a href="addProduct.jsp">Add Products</a></li>
				<li><a href="salesReports.jsp">Sales Reports</a></li>
				<li id="home"><a class="navbar-brand" href="index.jsp">Logout</a></li>
			</ul>
		</div>

	</div>
	<div class="searchDate">
		<form action="filterOrder">
			<label>From</label> <input type="date" id="startDate"
				name="startDate" required> <label class="max">To</label> <input
				class="max" type="date" id="maxDate" name="endDate" required>
			<button type="submit" class="btn btn-success">View Sales</button>
		</form>
	</div>

	<div>
		<c:set var="totalAmt" value="0" />
		<div id="allusers">
			<c:if test="${empty sessionScope.invalidDate}">

				<table class="table table-striped table table-hover"
					aria-describedby="Sales report" id="table_id">
					<thead>
						<tr>
							<th id="Order Date">Order Date</th>
							<th id="Product Name">Product Name</th>
							<th id="Quantity">Quantity</th>
							<th id="Unit Price">Unit Price</th>
							<th id="Total Price">Total Price</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach items="${salesReport}" var="salesReport">
							<tr>
								<fmt:parseDate value="${salesReport.getOrderdate()}"
									pattern="yyyy-MM-dd" var="orderDate" type="date" />
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${orderDate}" /></td>
								<td>${salesReport.getProduct().getProductName()}</td>
								<td>${salesReport.getQuantity() }</td>
								<td>${salesReport.getUnitPrice()}</td>
								<td>${salesReport.getTotalPrice()}</td>

							</tr>
							<c:set var="totalAmt"
								value="${totalAmt+salesReport.getTotalPrice()}" />
						</c:forEach>

						<tr>
							<th colspan="4" id="totalPrice">Total Price</th>
							<th id="totalAmt">${totalAmt}</th>
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>

		<c:if test="${not empty sessionScope.invalidDate}">

			<h1 class="dateExp">${sessionScope.invalidDate}</h1>
		</c:if>


	</div>

</body>
<script src="assets/javascript/salesReport2.js"></script>
</html>