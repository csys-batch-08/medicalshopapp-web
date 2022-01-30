package com.interfaces;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.medhub.model.OrderItems;
import com.medhub.model.User;

public interface OrderItemDAO {

	public  int  insertOrders(OrderItems oi) throws SQLException;
	public List<OrderItems> ViewMyOrders(User currentUser) throws SQLException;
	public boolean cancelDate(LocalDate date,int orderid) throws SQLException;
}
