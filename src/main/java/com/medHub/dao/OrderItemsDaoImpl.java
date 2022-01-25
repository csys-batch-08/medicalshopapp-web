package com.medHub.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.interfaces.OrderItemDAO;
import com.medHub.model.OrderItems;
import com.medHub.model.Order;
import com.medHub.model.Product;
import com.medHub.model.User;
import com.medHub.util.ConnectionUtil;

public class OrderItemsDaoImpl implements OrderItemDAO {
//	currentUser,buyProducts,buyProductQuantity, totalPrice
	public int insertOrders(OrderItems oi) {
		// TODO Auto-generated method stub
		String orderQuery = "insert into order_items(user_id,order_id,product_id,quantity,unit_price,total_price) values(?,?,?,?,?,?)";
		Connection con = ConnectionUtil.getDBconnect();

		int res = 0;
		try {
			PreparedStatement pst = con.prepareStatement(orderQuery);
			pst.setInt(1, oi.getUser().getUserId());
			pst.setInt(2, oi.getOrderId());
			pst.setInt(3, oi.getProduct().getProductId());
			pst.setInt(4, oi.getQuantity());
			pst.setDouble(5, oi.getUnitPrice());
			pst.setDouble(6, oi.getTotalPrice());
			res = pst.executeUpdate();
			pst.executeUpdate("commit");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return res;

	}

	public List<OrderItems> ViewMyOrders(User currentUser) {
		// TODO Auto-generated method stub
		List<OrderItems> myOrderList = new ArrayList<OrderItems>();
		Order order = new Order();
		Product product = new Product();
		OrderItems orderItems;
		String qwery = "select p.product_name,p.points_per_unit,oi.quantity,oi.unit_price,oi.total_price,oi.order_id,p.product_img,p.description,p.offer,p.product_id,o.order_date,o.order_status\r\n"
				+ "from order_items oi \r\n" + "inner join orders o on oi.order_id=o.order_id\r\n"
				+ "inner join products p on oi.product_id=p.product_id where oi.user_id = ? order by oi.order_id desc";
		Connection con = ConnectionUtil.getDBconnect();
		try {
			PreparedStatement ps = con.prepareStatement(qwery);
			ps.setInt(1, currentUser.getUserId());
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{
				orderItems = new OrderItems(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4),
						rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10),
						rs.getDate(11).toLocalDate(), rs.getString(12));
				myOrderList.add(orderItems);
			}
			return myOrderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myOrderList;

	}

	public boolean cancelDate(LocalDate date, int orderid) {
		// TODO Auto-generated method stub
		String query = "select * from orders where order_id=? and ?+1 >= sysdate";
		Connection con = ConnectionUtil.getDBconnect();
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, orderid);
			ps.setDate(2, java.sql.Date.valueOf(date));
			ResultSet rs = ps.executeQuery();

			if (rs.next())

			{
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	public ResultSet salesReport(String fromDate, String toDate) {
				
				List<OrderItems> salesReport = new ArrayList<OrderItems>();
				OrderItems orderItem;
				LocalDate startDate = LocalDate.parse(fromDate);
				LocalDate endDate = LocalDate.parse(toDate);
				
				String query = "select trunc(o.order_date),p.product_name,sum(oi.quantity) as quantity,oi.unit_price as price, (sum(oi.quantity)*oi.unit_price) as totalPrice from order_items oi "
								+ "join orders o on o.order_id = oi.order_id join products p on p.product_id = oi.product_id where trunc(o.order_date) between ? and ? group by(trunc(o.order_date),"
								+ "p.product_name,oi.unit_price,o.order_status) having o.order_status=?";
				Connection con = ConnectionUtil.getDBconnect();
				boolean flag = false;
				PreparedStatement ps;
				ResultSet rs = null;
				try {
					 ps = con.prepareStatement(query);
					 ps.setDate(1, java.sql.Date.valueOf(startDate));
					 ps.setDate(2, java.sql.Date.valueOf(endDate));
					 ps.setString(3, "order placed");
					 rs = ps.executeQuery();
					
					while(rs.next())

					{
						return rs;
					}
						
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					
						return rs;
				
					}

}
