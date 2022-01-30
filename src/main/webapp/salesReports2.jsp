<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>
<%@page import="com.exceptions.*"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
 <link rel = "icon" type = "" href = "Assets/medhublogo.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
<title>Sales Report</title>


<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background-image: url(Assets/homepage_img.jpg);
	background-size:cover;
	background-repeat: no-repeat;
	
}
#navigation{
   background: linear-gradient(to right, rgb(200, 47, 58) 0%,rgb(44, 169, 207) 100%);
}

#navigation ul li {
	list-style: none;
	padding: 20px;
	display: inline-block;
	margin-left: 60px;
}


#navigation ul li a {
	text-decoration: none;
	color: whitesmoke;
	display: inline;
}

#navigation ul li a:hover {
	color: black;
}

#navigation #logout a {
	position: relative;
	right: 10px;
}

#allusers table, th, tr, td {
	border: 2px solid black;
	border-collapse: collapse;
	
}

#allusers table th {
	border: 2px solid blue;
}

#allusers {
	position: absolute;
	left: 30%;
	top: 150px;
}

.searchDate{
position: absolute;
left:385px;
top:100px;
}

.max{
position: relative;
left: 60px;
}

.searchDate button{
position: relative;
left:80px;
outline: none;
border: none;
box-shadow: 0 0 5px black;
border-radius: 2px;
padding: 0px 10px;
background-color: yellowgreen;
height: 27px;
}

.searchDate button:hover{
box-shadow: 2px 2px 5px black;
transition-duration:0.2s;
color: white;
}

table 
{
	background-color: white;
	}

.dateExp{
position: relative;
left:350px;
top:70px;
color:red;
}

#totalPrice{
text-align: center;
}

</style>
</head>
<body>
<%-- <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
 --%>
	<div id="container" >
		<div id="navigation">
			<ul>
				<li><a href="allUsers">All Users</a></li>
				<li><a href="adminAllProducts">All Products</a></li>
				<li><a href="addProduct.jsp">Add Products</a></li>
				<li><a href="salesReports.jsp">Sales Reports</a></li>
				<li id="home" ><a class="navbar-brand" href="index.jsp">Logout</a></li>
			</ul>	
		</div>
		
	</div>
		<div class="searchDate" >
		<form action="filterOrder">
			<label>From</label>
			<input type="date" id="startDate" name="startDate" required>
			<label class="max">To</label>		
			<input class="max" type="date" id="maxDate" name="endDate" required>
			<button type="submit" class="btn btn-success"> View Sales</button>
			</form>
		</div>	
		
	 <div>
		<c:set var="totalAmt" value="0"/> 
		 <div id="allusers">
		   <c:if test="${empty sessionScope.invalidDate}"> 
		 
			<table class="table table-striped" >
				<thead class="table table-dark">
					<tr>
						<th>Order Date</th>
						<th>Product Name</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Total Price</th>
						
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${salesReport}" var="salesReport" >
					<tr>
					<fmt:parseDate value="${salesReport.getOrderdate()}" pattern="yyyy-MM-dd" var="orderDate" type="date"/>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${orderDate}"/></td> 
						<td>${salesReport.getProduct().getProductName()}</td>
						<td>${salesReport.getQuantity() }</td>
						<td>${salesReport.getUnitPrice()}</td>
						<td>${salesReport.getTotalPrice()}</td>
						
					</tr>
					<c:set var="totalAmt" value="${totalAmt+salesReport.getTotalPrice()}"/> 
					</c:forEach>
				
					<tr>
					<th colspan="4" id="totalPrice">Total Price</th>
					<th>${ totalAmt}</th>
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