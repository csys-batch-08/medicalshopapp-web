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
		PreparedStatement pst=null;
		int res = 0;
		try {
			String orderQuery = "insert into order_items(user_id,order_id,product_id,quantity,unit_price,total_price) values(?,?,?,?,?,?)";
			con=ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(orderQuery);
			pst.setInt(1, oi.getUser().getUserId());
			pst.setInt(2, oi.getOrderId());
			pst.setInt(3, oi.getProduct().getProductId());
			pst.setInt(4, oi.getQuantity());
			pst.setDouble(5, oi.getUnitPrice());
			pst.setDouble(6, oi.getTotalPrice());
			res = pst.executeUpdate();
			pst.executeUpdate("commit");

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
				}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
				
		}
		return res;

	}

	public List<OrderItems> ViewMyOrders(User currentUser) {
		
		List<OrderItems> myOrderList = new ArrayList<OrderItems>();
		Connection con = null;
		PreparedStatement pst = null;
		OrderItems orderItems;
		try {
			
			String qwery = "select p.product_name,p.points_per_unit,oi.quantity,oi.unit_price,oi.total_price,oi.order_id,p.product_img,p.description,p.offer,p.product_id,o.order_date,o.order_status\r\n"
					+ "from order_items oi \r\n" + "inner join orders o on oi.order_id=o.order_id\r\n"
					+ "inner join products p on oi.product_id=p.product_id where oi.user_id = ? order by oi.order_id desc";
			con=ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(qwery);
			pst.setInt(1, currentUser.getUserId());
			ResultSet rs = pst.executeQuery();

			while (rs.next())

			{
				orderItems = new OrderItems(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4),
						rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10),
						rs.getDate(11).toLocalDate(), rs.getString(12));
				myOrderList.add(orderItems);
			}
			return myOrderList;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(pst!=null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}     	
					}
				if(con !=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
					
			}
			return myOrderList;
	
	}

	public boolean cancelDate(LocalDate date, int orderid) {
		Connection con = null;
		PreparedStatement pst=null;
		boolean flag = false;
		try {
			
			String query = "select * from orders where order_id=? and ?+1 >= sysdate";
			con=ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setInt(1, orderid);
			pst.setDate(2, java.sql.Date.valueOf(date));
			ResultSet rs = pst.executeQuery();

			if (rs.next())

			{
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;

	}

	public List<OrderItems> salesReport(String fromDate, String toDate) {
				
				List<OrderItems> salesReport = new ArrayList<OrderItems>();
				OrderItems orderItem;
				LocalDate startDate = LocalDate.parse(fromDate);
				LocalDate endDate = LocalDate.parse(toDate);
				Connection con = null;
				boolean flag = false;
				PreparedStatement pst=null;
				ResultSet rs = null;
				try {
					String query = "select trunc(o.order_date),p.product_name,sum(oi.quantity) as quantity,oi.unit_price as price, (sum(oi.quantity)*oi.unit_price) as totalPrice from order_items oi "
							+ "join orders o on o.order_id = oi.order_id join products p on p.product_id = oi.product_id where trunc(o.order_date) between ? and ? group by(trunc(o.order_date),"
							+ "p.product_name,oi.unit_price,o.order_status) having o.order_status=?";
					 con=ConnectionUtil.getDBconnect();
					 pst = con.prepareStatement(query);
					 pst.setDate(1, java.sql.Date.valueOf(startDate));
					 pst.setDate(2, java.sql.Date.valueOf(endDate));
					 pst.setString(3, "order placed");
					 rs = pst.executeQuery();
					
					while(rs.next())

					{
					 orderItem = new OrderItems(rs.getDate(1).toLocalDate(),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDouble(5));
					 salesReport.add(orderItem);
					}
					return salesReport;
					} catch (SQLException e) {
					e.printStackTrace();
					}finally {
						if(pst!=null){
							try {
								pst.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}     	
						}
						if(con !=null) {
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				return salesReport;
					
						
	}
	
	

}
