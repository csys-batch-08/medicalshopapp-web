<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="assets/images/medhublogo.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/salesReports.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Sales Report</title>
<script>
    history.forward();
</script>


</head>
<body>

	<div id="container">
		<div id="navigation">
			<ul>
				<li><a href="allUsers">All Users</a></li>
				<li><a href="adminAllProducts">All Products</a></li>
				<li><a href="addProduct.jsp">Add Products</a></li>
				<li><a href="salesReports.jsp">Sales Reports</a></li>
				<li id="logout"><a href="index.jsp">Logout</a></li>
			</ul>
		</div>

	</div>
	<div class="searchDate">
		<form action="filterOrder">
			<label>From</label> <input type="date" id="startDate"
				name="startDate"> <label class="max">To</label> <input
				class="max" type="date" id="maxDate" name="endDate">

			<button type="submit" class="btn btn-success">View Sales</button>
		</form>
	</div>

	<div></div>
</body>
<script src="assets/javascript/salesReport.js"></script>
</html>