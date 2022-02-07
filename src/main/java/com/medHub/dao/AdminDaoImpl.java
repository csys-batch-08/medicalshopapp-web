package com.medhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.interfaces.AdminDAO;
import com.medhub.model.Admin;
import com.medhub.util.ConnectionUtil;

public class AdminDaoImpl implements AdminDAO {

	public Admin login(Admin admin) throws SQLException {
		Admin adminmodule = null;
		String check = "select admin_name,age,admin_password,admin_email,admin_mobile from admin a where admin_email=? and admin_password=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(check);
			pstmt.setString(1, admin.getAdminMail());
			pstmt.setString(2, admin.getAdminPassword());
			rs = pstmt.executeQuery();
		if (rs.next()) {
				adminmodule = new Admin(rs.getString("admin_name"), rs.getInt("age"), rs.getString("admin_password"),
						rs.getString("admin_email"), rs.getLong("admin_mobile"));
				return adminmodule;
			}
			return adminmodule;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pstmt, con, rs);

		}
		return adminmodule;
	}
}
