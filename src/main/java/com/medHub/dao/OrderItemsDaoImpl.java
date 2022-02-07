package com.medhub.dao;

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
import com.medhub.model.OrderItems;
import com.medhub.model.Order;
import com.medhub.model.Product;
import com.medhub.model.User;
import com.medhub.util.ConnectionUtil;

public class OrderItemsDaoImpl implements OrderItemDAO {
	
	
								//	currentUser,buyProducts,buyProductQuantity, totalPrice
	public int insertOrders(OrderItems oi){
		Connection con = null;
		PreparedStatement pstmt=null;
		int res = 0;
		try {
			String orderQuery = "insert into order_items(user_id,order_id,product_id,quantity,unit_price,total_price) values(?,?,?,?,?,?)";
			con=ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(orderQuery);
			pstmt.setInt(1, oi.getUser().getUserId());
			pstmt.setInt(2, oi.getOrderId());
			pstmt.setInt(3, oi.getProduct().getProductId());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setDouble(5, oi.getUnitPrice());
			pstmt.setDouble(6, oi.getTotalPrice());
			res = pstmt.executeUpdate();
			pstmt.executeUpdate("commit");

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		return res;

	}

	public List<OrderItems> ViewMyOrders(User currentUser) {
		
		List<OrderItems> myOrderList = new ArrayList<OrderItems>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		OrderItems orderItems;
		try {
			
			String qwery = "select p.product_name,p.points_per_unit,oi.quantity,oi.unit_price,oi.total_price,oi.order_id,p.product_img,p.description,p.offer,p.product_id,o.order_date,o.order_status\r\n"
					+ "from order_items oi \r\n" + "inner join orders o on oi.order_id=o.order_id\r\n"
					+ "inner join products p on oi.product_id=p.product_id where oi.user_id = ? order by oi.order_id desc";
			con=ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(qwery);
			pstmt.setInt(1, currentUser.getUserId());
			rs = pstmt.executeQuery();

			while (rs.next())

			{
				orderItems = new OrderItems(rs.getString("product_name"), rs.getInt("points_per_unit"), rs.getInt("quantity"), rs.getDouble("unit_price"),
						rs.getDouble("total_price"), rs.getInt("order_id"), rs.getString("product_img"), rs.getString("description"), rs.getInt("offer"), rs.getInt("product_id"),
						rs.getDate("order_date").toLocalDate(), rs.getString("order_status"));
				myOrderList.add(orderItems);
			}
			return myOrderList;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(pstmt,con,rs);
			}
			return myOrderList;
	
	}

	public boolean cancelDate(LocalDate date, int orderid) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		boolean flag = false;
		try {
			
			String query = "select order_id from orders where order_id=? and ?+1 >= sysdate";
			con=ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderid);
			pstmt.setDate(2, java.sql.Date.valueOf(date));
			rs = pstmt.executeQuery();

			if (rs.next())

			{
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con,rs);
		}
		return flag;

	}

	public List<OrderItems> salesReport(String fromDate, String toDate) {
				
				List<OrderItems> salesReport = new ArrayList<>();
				OrderItems orderItem;
				LocalDate startDate = LocalDate.parse(fromDate);
				LocalDate endDate = LocalDate.parse(toDate);
				Connection con = null;
				boolean flag = false;
				PreparedStatement pstmt=null;
				ResultSet rs = null;
				try {
					String query = "select trunc(o.order_date),p.product_name,sum(oi.quantity) as quantity,oi.unit_price as price, (sum(oi.quantity)*oi.unit_price) as totalPrice from order_items oi "
							+ "join orders o on o.order_id = oi.order_id join products p on p.product_id = oi.product_id where trunc(o.order_date) between ? and ? group by(trunc(o.order_date),"
							+ "p.product_name,oi.unit_price,o.order_status) having o.order_status=?";
					 con=ConnectionUtil.getDBconnect();
					 pstmt = con.prepareStatement(query);
					 pstmt.setDate(1, java.sql.Date.valueOf(startDate));
					 pstmt.setDate(2, java.sql.Date.valueOf(endDate));
					 pstmt.setString(3, "order placed");
					 rs = pstmt.executeQuery();
					
					while(rs.next())

					{
					 orderItem = new OrderItems(rs.getDate("trunc(o.order_date)").toLocalDate(),rs.getString("product_name"),rs.getInt("quantity"),rs.getDouble("price"),rs.getDouble("totalPrice"));
					 salesReport.add(orderItem);
					}
					return salesReport;
					} catch (SQLException e) {
					e.printStackTrace();
					}finally {
						ConnectionUtil.close(pstmt,con,rs);
					}
				return salesReport;
					
						
	}
	
	

}
