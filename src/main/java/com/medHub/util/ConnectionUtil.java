package com.medHub.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectionUtil{
	
public static Connection getDBconnect() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("Driver Not Found");
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to get Connection");
		}  
		
		return con;
	}

}

