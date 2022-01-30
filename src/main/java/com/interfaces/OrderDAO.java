package com.interfaces;

import java.sql.SQLException;

import com.medhub.model.Order;
import com.medhub.model.User;

public interface OrderDAO {

	public int  getByOrderId() throws SQLException;
	public  boolean  orders(Order order,User currentUser) throws SQLException;
	public boolean deleteProduct(int orderId) throws SQLException;
	public boolean checkStatus(int orderId) throws SQLException;
}
