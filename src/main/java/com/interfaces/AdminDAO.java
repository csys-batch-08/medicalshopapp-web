package com.interfaces;

import java.sql.SQLException;

import com.medhub.model.Admin;

public interface AdminDAO {
	
	public Admin login(Admin admin) throws SQLException;

}
