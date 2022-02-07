package com.medhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medhub.model.Cart;
import com.medhub.model.Product;
import com.medhub.model.User;
import com.medhub.util.ConnectionUtil;

public class CartDaoImpl {
	
	
						//insert product to cart
	public void insertProduct(Cart cart) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			String insertProduct = "insert into cart (product_id,user_id,unit_price,qty,total_price) values (?,?,?,?,?)";
				con=ConnectionUtil.getDBconnect();
				pstmt = con.prepareStatement(insertProduct);
				pstmt.setInt(1, cart.getProduct().getProductId());
				pstmt.setInt(2, cart.getUser().getUserId());
				pstmt.setDouble(3, cart.getProduct().getUnitPrice());
				pstmt.setInt(4, cart.getQty());
				pstmt.setDouble(5, cart.getTotalPrice());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(pstmt,con);
				}	
		
		}

	
						//list of cart items
	public List<Cart> viewCart(User currentUser) throws SQLException {

		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<Cart> allCartItems = new ArrayList<Cart>();
		ProductDaoImpl proDao = new ProductDaoImpl();
		try 
		{
		String query = "select qty,unit_price,total_price,product_id  from cart where user_id= ? ";
		con=ConnectionUtil.getDBconnect();
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, currentUser.getUserId()); 
		rs = pstmt.executeQuery();
		
		
		while (rs.next()) 
		{
			Product product = proDao.findProductByProductId(rs.getInt(4));
			Cart cart = new Cart(product, currentUser, rs.getInt("qty"), rs.getDouble("unit_price"), rs.getDouble("total_price"));
			allCartItems.add(cart);
		}
		return allCartItems;
		}
		catch (SQLException e1) 
		{
		e1.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con,rs);
			
		}
		
		return allCartItems;
	}
	
	

							//get product quantity
	public int productexist(Cart cart) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		String query = "select qty from cart where product_id in ? and user_id in ?";
		con=ConnectionUtil.getDBconnect();
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cart.getProduct().getProductId());
		pstmt.setInt(2, cart.getUser().getUserId());
		rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("qty");
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con,rs);		
		}
		return -1;
	}

	
						//get product price
	public int productexist1(Cart cart) throws SQLException {
		
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
		String query = "select total_price from cart where product_id in ? and user_id in ?";
		con=ConnectionUtil.getDBconnect();
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cart.getProduct().getProductId());
		pstmt.setInt(2, cart.getUser().getUserId());
		rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total_price");
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con,rs);
		}
		
		return -1;
	}

	
							// update quantity:
	public int updatequantity(Cart cart) throws SQLException {
		Connection con =null; 
		PreparedStatement pstmt=null;
		int res = 0;
		try {
		String query = "update cart set qty = ?,total_price = ? where product_id = ? and user_id = ?";
		con=ConnectionUtil.getDBconnect();
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cart.getQty());
		pstmt.setDouble(2, cart.getTotalPrice());
		pstmt.setInt(3, cart.getProduct().getProductId());
		pstmt.setInt(4, cart.getUser().getUserId());
		res = pstmt.executeUpdate();
		pstmt.executeUpdate("commit");
		return res;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);	
		}
		
		return res;
	}

	
						//Delete items from cart
	public int removecartItems(Cart cart) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt=null;
		int res=0;
		try {
				String query = "delete from cart where user_id=? and product_id=?";
				con=ConnectionUtil.getDBconnect();
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, cart.getUser().getUserId());
				pstmt.setInt(2, cart.getProduct().getProductId());
				res = pstmt.executeUpdate();
				pstmt.executeUpdate("commit");
				return res;
				}catch(SQLException e)
				{
					e.printStackTrace();
				}finally 
				{
					ConnectionUtil.close(pstmt,con);
				}
				
				return res;
			}
	
}
