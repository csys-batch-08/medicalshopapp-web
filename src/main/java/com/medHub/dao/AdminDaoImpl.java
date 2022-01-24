package com.medHub.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.interfaces.AdminDAO;
import com.medHub.model.Admin;
import com.medHub.util.ConnectionUtil;




public class AdminDaoImpl implements AdminDAO{
	

	public Admin login(Admin admin) throws SQLException
	{
		Admin adminmodule=null;
		String check="select admin_name,age,admin_password,admin_email,admin_mobile from admin where admin_email=? and admin_password=?";
		ConnectionUtil conn= new ConnectionUtil();
		Connection con=conn.getDBconnect();	
		PreparedStatement ps = con.prepareStatement(check);
		ps.setString(1, admin.getAdminMail());
		ps.setString(2, admin.getAdminPassword());
		ResultSet rs = ps.executeQuery();
	
		if(rs.next()) {
			adminmodule=new Admin(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getLong(6));
			return adminmodule;
		}
		return adminmodule;
		
		}




	
	
}
