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
<title>Insert title here</title>
</head>
<body>

<%
String email =request.getParameter("email"); 
try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
PreparedStatement ps=con.prepareStatement("select * from users where user_email=? ");  
ps.setString(1,email);  
ResultSet rs=ps.executeQuery();  
if(rs.next())
{
	
	PrintWriter Write = response.getWriter();
   Write.println("Already Registered Email");
	

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