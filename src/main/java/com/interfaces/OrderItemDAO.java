package com.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.medhub.model.OrderItems;
import com.medhub.model.User;

public interface OrderItemDAO {

	public  int  insertOrders(OrderItems oi);
	public List<OrderItems> ViewMyOrders(User currentUser);
	public boolean cancelDate(LocalDate date,int orderid);
}
