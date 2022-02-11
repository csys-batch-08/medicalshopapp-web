<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="assets/images/medhublogo.png">
<link rel="stylesheet" href="assets/css/allUser.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>All Users</title>
<script>
    history.forward();
</script>
</head>
<body>

	<div id="container">
		<div id="navigation">
			<ul>
				<li><a href="allUser.jsp">All Users</a></li>
				<li><a href="adminAllProducts">All Products</a></li>
				<li><a href="addProduct.jsp">Add Products</a></li>
				<li><a href="salesReports.jsp">Sales Reports</a></li>
				<li id="logout"><a href="index.jsp">Logout</a></li>
			</ul>
		</div>

	</div>
	<div>


		<div id="allusers">
			<table class="table table-striped" aria-describedby="buy Products">
				<thead class="table table-dark">
					<tr>
						<th id="userId">USER ID</th>
						<th id="funnName">FULL NAME</th>
						<th id="address">ADDRESS</th>
						<th id="email">EMAIL</th>
						<th id="mobile">MOBILE</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.userId}</td>
							<td>${user.getUserName()}</td>
							<td>${user.address}</td>
							<td>${user.userMail }</td>
							<td>${user.userMobile}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>