<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="" href="Assets/Images/medhublogo.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="Assets/css/salesReports.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Sales Report</title>
<script>
    history.forward();
</script>


</head>
<body>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

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
<script>
today();
function today(){
  
var currentTime = new Date() 
var maxDate = new Date(currentTime.getFullYear(), currentTime.getMonth(), + currentTime.getDate()+1); //max date current date
console.log(maxDate);
let date = JSON.stringify(maxDate)
date = date.slice(1,11)
console.log(date)
document.getElementById("maxDate").setAttribute("max",date);
document.getElementById("startDate").setAttribute("max",date);

}

</script>
</html>