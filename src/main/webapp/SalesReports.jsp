<%@page import="java.sql.ResultSet"%>
<%@page import="com.medHub.model.*"%>
<%@page import="com.medHub.dao.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel = "icon" type = "" href = "Assets/medhublogo.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
<title>Sales Report</title>
<script>
    history.forward();
</script>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background-image: url(Assets/homepage_img.jpg);
	background-size: cover;
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

#navigation {
	background-color: rgb(83, 137, 168);
	align-items: center;
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
	padding: 10px;
}

#allusers table th {
	border: 2px solid blue;
}

#allusers {
	position: absolute;
	left: 18%;
	top: 100px;
}

.searchDate{
position: absolute;
left:420px;
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
color:white;
}

</style>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<div id="container" >
		<div id="navigation">
			<ul>
				<li><a href="AllUser.jsp">All Users</a></li>
				<li><a href="AdminAllProducts.jsp?deleteProductid=0">All Products</a></li>
				<li><a href="AddProduct.jsp">Add Products</a></li>
				<li><a href="SalesReports.jsp">Sales Reports</a></li>
				<li id="logout"><a href="Index.jsp">Logout</a></li>
		</div>
		</ul>
	</div>
		<div class="searchDate" >
		<form action="SalesReports2.jsp">
			<label>From</label>
			<input type="date" id="startDate" name="startDate">
			
			<label class="max">To</label>		
			<input class="max" type="date" id="maxDate" name="endDate">
			
			<button type="submit" class="btn btn-success"> View Sales</button>
			</form>
		</div>	
 		<% 
		ResultSet rs = (ResultSet)session.getAttribute("orders");
		%>
		
	 <div>
		<% 
		%>
		<%-- <div id="allusers">
			<table class="table table-striped">
				<thead class="table table-dark">
					<tr>
						<th >Order Date</th>
						<th>Product Name</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Total Price</th>
						
					</tr>
				</thead>

				<tbody>
					<%while(rs.next()){ %>
					<tr>
						<td><%=rs.getDate(1) %></td>
						<td><%=rs.getString(2)%></td>
						<td><%=rs.getInt(3) %></td>
						<td><%=rs.getDouble(4) %></td>
						<td><%=rs.getDouble(5)%></td>
						
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>  --%>
 
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