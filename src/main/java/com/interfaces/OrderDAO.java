package com.interfaces;

import java.sql.SQLException;

import com.medhub.model.Order;
import com.medhub.model.User;

public interface OrderDAO {

	public int  getByOrderId();
	public  boolean  orders(Order order,User currentUser);
	public boolean deleteProduct(int orderId) throws SQLException;
	public boolean checkStatus(int orderId);
}
