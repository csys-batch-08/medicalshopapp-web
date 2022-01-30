<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>checkMobile</title>
</head>
<body>
<%
String mobile =request.getParameter("mobile"); 

try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
PreparedStatement ps=con.prepareStatement("select * from users where user_mobile=? ");  
ps.setString(1,mobile);  
ResultSet rs=ps.executeQuery();  
if(rs.next())
{
	PrintWriter Write = response.getWriter();
   Write.println("Already Registered number");
	

}  
}
catch(Exception e)
{
	e.printStackTrace(); 
	System.out.println("chechking"+e);

}
%>


</body>
</html>