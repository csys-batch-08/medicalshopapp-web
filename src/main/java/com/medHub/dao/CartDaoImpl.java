package com.medHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.medHub.model.Cart;
import com.medHub.model.Product;
import com.medHub.model.User;
import com.medHub.util.ConnectionUtil;

public class CartDaoImpl {



	public void insertProduct(Cart cart) {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getDBconnect();
		try {
		String insertProduct ="insert into cart (product_id,user_id,unit_price,qty,total_price) values (?,?,?,?,?)"; 
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(insertProduct);
			pst.setInt(1,cart.getProduct().getProductId());
			pst.setInt(2, cart.getUser().getUserId());
			pst.setDouble(3, cart.getProduct().getUnitPrice());
			pst.setInt(4, cart.getQty());
			pst.setDouble(5, cart.getTotalPrice());
			int result=pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}


	public List<Cart> viewCart(User currentUser) {
		
		Connection con=ConnectionUtil.getDBconnect();
		String query= "select * from cart where user_id='"+currentUser.getUserId()+"'";
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1,currentUser.getUserId() );
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Cart> allCartItems=new ArrayList<Cart>();
		Statement smt = null;
		ResultSet rs= null;
		try {
			smt = con.createStatement();
			rs=smt.executeQuery(query);
			ProductDaoImpl proDao=new ProductDaoImpl();
			while(rs.next()) {
				
				Product product=proDao.findProductByProductId(rs.getInt(2));
				Cart cart=new Cart(product,currentUser,rs.getInt(5),rs.getDouble(4),rs.getDouble(6));
				allCartItems.add(cart);				
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return allCartItems;
	}
	
	
	
	public int productexist(Cart cart) throws SQLException {
		Connection con=ConnectionUtil.getDBconnect();
		String query = "select qty from cart where product_id in ? and user_id in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, cart.getProduct().getProductId());
		statement.setInt(2, cart.getUser().getUserId());
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}
	
	
	
	
	public int productexist1(Cart cart) throws SQLException {
		Connection con=ConnectionUtil.getDBconnect();
		String query = "select total_price from cart where product_id in ? and user_id in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, cart.getProduct().getProductId());
		statement.setInt(2, cart.getUser().getUserId());
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}
	
	//update quantity:
	
	public int updatequantity(Cart cart) throws SQLException {
		Connection con=ConnectionUtil.getDBconnect();
		String query = "update cart set qty = ?,total_price = ? where product_id in ? and user_id in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, cart.getQty());
		statement.setDouble(2, cart.getTotalPrice());
		statement.setInt(3, cart.getProduct().getProductId());
		statement.setInt(4, cart.getUser().getUserId());
		int res = statement.executeUpdate();
		statement.executeUpdate("commit");
		return res;
	}

	public int removecartItems(Cart cart) throws SQLException {
		Connection con=ConnectionUtil.getDBconnect();
		String query = "delete from cart where user_id=? and product_id=?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, cart.getUser().getUserId());
		statement.setInt(2, cart.getProduct().getProductId());
		int res = statement.executeUpdate();
		statement.executeUpdate("commit");
		return res;
		}
}
