package com.medHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.interfaces.OrderDAO;
import com.medHub.model.Order;
import com.medHub.model.Product;
import com.medHub.model.User;
import com.medHub.util.ConnectionUtil;

public class OrderDaoImpl implements OrderDAO{
	

	public  boolean  orders(Order order,User currentUser) {
		
		String orderQuery="insert into orders (user_id,price) values(?,?)";
		Connection con = ConnectionUtil.getDBconnect();
		try {
			PreparedStatement pst = con.prepareStatement(orderQuery);
			pst.setInt(1,currentUser.getUserId() );
			pst.setDouble(2, order.getPrice());
			pst.executeUpdate();
			pst.executeUpdate("commit");
			int result = pst.executeUpdate();
			if(result>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			}
		return false;
	}
	
	public int  getByOrderId()
	{
		String qwery="select max(order_id) from orders";
		Connection con = ConnectionUtil.getDBconnect();
		Order order= null;
		int orderId=0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qwery);
			
			if(rs.next())
			{
			orderId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return orderId;
		
	}

	public boolean deleteProduct(int orderId) throws SQLException
	{
		boolean flag=false;
		String qwery="update orders set order_status='cancelled' where order_id =?";
		Connection con = ConnectionUtil.getDBconnect();
		PreparedStatement pst=con.prepareStatement(qwery);
		pst.setInt(1, orderId);
		int res=pst.executeUpdate();
		pst.executeUpdate("commit");

		if(res>0)
		{
			flag=true;
			return flag;
		}
		con.close();
		pst.close();
		return flag;
		
	}

	public boolean checkStatus(int orderId)
	{	
		try {
			String status;
		String qwery="select order_status from orders where order_id='"+orderId+"'";
		Connection con = ConnectionUtil.getDBconnect();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(qwery);
		if(rs.next())
		{
			
		status=rs.getString(1).toLowerCase();
		if(!status.equals("cancelled"))
		{
			return true;

		}

		}
		}
		catch(Exception e)
		{
		}
		return false;
	}

	


	
	


}
