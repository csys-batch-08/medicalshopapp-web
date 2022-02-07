package com.medhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.interfaces.OrderDAO;
import com.medhub.model.Order;
import com.medhub.model.Product;
import com.medhub.model.User;
import com.medhub.util.ConnectionUtil;

public class OrderDaoImpl implements OrderDAO{
	
						//make an order
	public  boolean  orders(Order order,User currentUser) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			String orderQuery="insert into orders (user_id,price) values(?,?)";
			con=ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(orderQuery);
			pstmt.setInt(1,currentUser.getUserId() );
			pstmt.setDouble(2, order.getPrice());
			pstmt.executeUpdate();
			pstmt.executeUpdate("commit");
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				return true;
			}
			} catch (SQLException e) {
			  e.getMessage();
			}finally {
				ConnectionUtil.close(pstmt,con);
			}
			return false;
	}
	
	
					//to get product object by productId
	public int  getByOrderId() throws SQLException 
	{
		
		Connection con = null;
		Order order= null;
		ResultSet rs =null;
		Statement stmt =null;
		int orderId=0;
		
		try {
			String qwery="select max(order_id) from orders";
			con=ConnectionUtil.getDBconnect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(qwery);
			
			if(rs.next())
			{
			orderId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}finally {
			ConnectionUtil.closeStatement(stmt,con,rs);
				
		}
		return orderId;
		
	}

	
							//cancel an order
	public boolean deleteProduct(int orderId) throws SQLException
	{
		
		boolean flag=false;
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
		String qwery="update orders set order_status= ? where order_id =?";
		con = ConnectionUtil.getDBconnect();
		pstmt=con.prepareStatement(qwery);
		pstmt.setString(1, "cancelled");
		pstmt.setInt(2, orderId);
		int res=pstmt.executeUpdate();
		pstmt.executeUpdate("commit");

		if(res>0)
		{
			flag=true;
			return flag;
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		return flag;
		
	}

						//to check order is cancelled
	public boolean checkStatus(int orderId) throws SQLException
	{	
		String status;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try {
		String qwery="select order_status from orders where order_id= ?";
		con = ConnectionUtil.getDBconnect();
		pstmt=con.prepareStatement(qwery);
		pstmt.setInt(1, orderId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			status=rs.getString("order_status").toLowerCase();
			if(!status.equals("cancelled"))
			{
				return true;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		return false;
	}

	
}
