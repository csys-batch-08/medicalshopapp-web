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
		PreparedStatement pst=null;
		try {
			String insertProduct = "insert into cart (product_id,user_id,unit_price,qty,total_price) values (?,?,?,?,?)";
				con=ConnectionUtil.getDBconnect();
				pst = con.prepareStatement(insertProduct);
				pst.setInt(1, cart.getProduct().getProductId());
				pst.setInt(2, cart.getUser().getUserId());
				pst.setDouble(3, cart.getProduct().getUnitPrice());
				pst.setInt(4, cart.getQty());
				pst.setDouble(5, cart.getTotalPrice());
				pst.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pst!=null) {
					pst.close();     	
				}
				if(con !=null) {
					con.close();
				}
					
				}	
		
		}

	
						//list of cart items
	public List<Cart> viewCart(User currentUser) throws SQLException {

		Connection con =null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		List<Cart> allCartItems = new ArrayList<Cart>();
		ProductDaoImpl proDao = new ProductDaoImpl();
		try 
		{
		String query = "select qty,unit_price,total_price,product_id  from cart where user_id= ? ";
		con=ConnectionUtil.getDBconnect();
		pst = con.prepareStatement(query);
		pst.setInt(1, currentUser.getUserId()); 
		rs = pst.executeQuery();
		
		
		while (rs.next()) 
		{
			Product product = proDao.findProductByProductId(rs.getInt(4));
			Cart cart = new Cart(product, currentUser, rs.getInt(1), rs.getDouble(2), rs.getDouble(3));
			allCartItems.add(cart);
		}
		return allCartItems;
		}
		catch (SQLException e1) 
		{
		e1.printStackTrace();
		}finally {
		if(pst!=null) {
			pst.close();     	
		}
		if(con !=null) {
			con.close();
		}
			
		}
		
		return allCartItems;
	}
	
	

							//get product quantity
	public int productexist(Cart cart) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
		String query = "select qty from cart where product_id in ? and user_id in ?";
		con=ConnectionUtil.getDBconnect();
		pst = con.prepareStatement(query);
		pst.setInt(1, cart.getProduct().getProductId());
		pst.setInt(2, cart.getUser().getUserId());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			if(pst!=null) {
				pst.close();     	
				}
			if(con !=null) {
				con.close();
				}
				
		}
		return -1;
	}

	
						//get product price
	public int productexist1(Cart cart) throws SQLException {
		
		
		Connection con = null;
		PreparedStatement pst =null;
		try {
		String query = "select total_price from cart where product_id in ? and user_id in ?";
		con=ConnectionUtil.getDBconnect();
		pst = con.prepareStatement(query);
		pst.setInt(1, cart.getProduct().getProductId());
		pst.setInt(2, cart.getUser().getUserId());
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			if(pst!=null) {
				pst.close();     	
				}
			if(con !=null) {
				con.close();
				}
		}
		
		return -1;
	}

	
							// update quantity:
	public int updatequantity(Cart cart) throws SQLException {
		Connection con =null; 
		PreparedStatement pst=null;
		int res = 0;
		try {
		String query = "update cart set qty = ?,total_price = ? where product_id = ? and user_id = ?";
		con=ConnectionUtil.getDBconnect();
		pst = con.prepareStatement(query);
		pst.setInt(1, cart.getQty());
		pst.setDouble(2, cart.getTotalPrice());
		pst.setInt(3, cart.getProduct().getProductId());
		pst.setInt(4, cart.getUser().getUserId());
		res = pst.executeUpdate();
		pst.executeUpdate("commit");
		return res;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			if(pst!=null) {
				pst.close();     	
				}
			if(con !=null) {
				con.close();
				}
				
		}
		
		return res;
	}

	
						//Delete items from cart
	public int removecartItems(Cart cart) throws SQLException {
		Connection con = null;
		PreparedStatement pst=null;
		int res=0;
		try {
				String query = "delete from cart where user_id=? and product_id=?";
				con=ConnectionUtil.getDBconnect();
				pst = con.prepareStatement(query);
				pst.setInt(1, cart.getUser().getUserId());
				pst.setInt(2, cart.getProduct().getProductId());
				res = pst.executeUpdate();
				pst.executeUpdate("commit");
				return res;
				}catch(SQLException e)
				{
					e.printStackTrace();
				}finally 
				{
					if(pst!=null) {
						pst.close();     	
					}
					if(con !=null) {
						con.close();
					}
				}
				
				return res;
			}
	
}
