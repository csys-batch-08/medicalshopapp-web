package com.medhub.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.interfaces.AdminDAO;
import com.medhub.model.Admin;
import com.medhub.util.ConnectionUtil;




public class AdminDaoImpl implements AdminDAO{
	

	public Admin login(Admin admin) throws SQLException 
	{
		Admin adminmodule=null;
		String check="select admin_name,age,admin_password,admin_email,admin_mobile from admin a where admin_email=? and admin_password=?";
		Connection con = null;
		PreparedStatement ps=null;
	
			
		try {
			con=ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(check);
			ps.setString(1, admin.getAdminMail());
			ps.setString(2, admin.getAdminPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				adminmodule=new Admin(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getLong(5));
				return adminmodule;
			}
			return adminmodule;
			} catch (SQLException e) {
				e.printStackTrace();
			}
				finally
				{
					if(ps!=null) {
						ps.close();     	
						}
					if(con !=null) {
						con.close();
						}
					
				}
			return adminmodule;
		}
}
