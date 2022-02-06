<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "Assets/medhublogo.png">
<link rel="stylesheet" href="Assets/css/adminHome.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<title>AdminHome</title>
<script>
    history.forward();
</script>

</head>

<body>

<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

	<div class="container-fluid p-0">
		<div id="navigation" >
			<ul >
				<li><a  href="allUsers">All Users</a></li>
				<li><a  href="adminAllProducts">All Products</a></li>
				<li><a  href="addProduct.jsp">Add Products</a></li>
				<li><a  href="salesReports.jsp">Sales Reports</a></li>		
				<li id="logout"><a href="index.jsp">Logout</a></li>
				</ul>
		</div>
		
		
		<h3>Welcome Admin</h3>
	</div>
	
	<script src="Assets/javascript/popupMessages.js"></script>	
	<c:if test="${param.loginstatus!=null}">
	<script type="text/javascript"> showMessage("loginSucess")</script>
	</c:if>
	
</body>
</html>