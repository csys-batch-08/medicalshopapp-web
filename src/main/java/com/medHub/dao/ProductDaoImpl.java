package com.medhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.interfaces.ProductDAO;
import com.medhub.model.Product;
import com.medhub.util.ConnectionUtil;

public class ProductDaoImpl implements ProductDAO {
	
	  String commitQuery = "commit";
										//Show All Products
	public List<Product> viewProduts() {
		
		Connection con = null;
		PreparedStatement pstmt=null;
		List<Product> productList = new ArrayList<>();
		ResultSet rs =null;
		try 
		{
			String viewQuery = "select product_id,product_category,product_name,description,price,available_quantity,"
					 + " product_img,points_per_unit,status,offer from products where status= ? ";
			con=ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(viewQuery);
			pstmt.setString(1, "available");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"), rs.getString("status"), rs.getInt("offer"));
				productList.add(product);
			}
			return productList;

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con,rs);
		}

		return productList;
}
	

									// Insert Product By Admin
	public Boolean insertProduct(Product productModel){
		boolean flag = false;
		Connection con = null;ConnectionUtil.getDBconnect();
		PreparedStatement pstmt =null;
		try {
			String query = "insert into products (product_category,product_name,description,price,available_quantity,product_img,points_per_unit,offer) values (?,?,?,?,?,?,?,?)";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productModel.getProductCategory());
			pstmt.setString(2, productModel.getProductName());
			pstmt.setString(3, productModel.getDescription());
			pstmt.setDouble(4, productModel.getUnitPrice());
			pstmt.setInt(5, productModel.getQuantity());
			pstmt.setString(6, productModel.getProductImg());
			pstmt.setInt(7, productModel.getPoints());
			pstmt.setInt(8, productModel.getOffer());
			int result = pstmt.executeUpdate();

			if (result > 0) {
				flag = true;
				return flag;
			}

		}catch (SQLException e) {

			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		return false;
	}

										
												//Update Products By ADmin
	public int updateProducts(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result=0;

		try {
			String updateQwery = "update products set product_category=?,product_name=?,price=?,available_Quantity=?,product_img=?,points_per_unit=?,offer=?,description=?,status=? where product_id=?";
			con=ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(updateQwery);
			pstmt.setString(1, product.getProductCategory());
			pstmt.setString(2, product.getProductName());
			pstmt.setDouble(3, product.getUnitPrice());
			pstmt.setDouble(4, product.getQuantity());
			pstmt.setString(5, product.getProductImg());
			pstmt.setInt(6, product.getPoints());
			pstmt.setInt(7, product.getOffer());
			pstmt.setString(8, product.getDescription());
			pstmt.setString(9,"available");
			pstmt.setInt(10, product.getProductId());
			result = pstmt.executeUpdate();
			pstmt.executeUpdate(commitQuery);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		return result;
	}

												//Delete Product by admin
	public int deleteProduct(int productId) throws SQLException {
		
		int res=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		String qwery = "update products set status= ? where product_id=?";
		con = ConnectionUtil.getDBconnect();
		pstmt = con.prepareStatement(qwery);
		pstmt.setString(1, "unavailable");
		pstmt.setInt(2, productId);
		res = pstmt.executeUpdate();
		pstmt.executeUpdate(commitQuery);
		if (res > 0) {
			return res;
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
	
		return res;

	}
	
	

													//find Product By Name
	public Product findProductByName(String productName) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		Product product = null;
		ResultSet rs =null;
		try 
		{
			String query = "select product_id,product_category,product_name,description,price,available_quantity,"
					 + "product_img,points_per_unit from products where product_name= ? ";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,productName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"), rs.getDouble("price"),
						rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"));
				return product;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con,rs);
		}

		return product;
	}
	
	

								//find product by product Id
	public Product findProductByProductId(int id) {
		
		Connection con =null;
		PreparedStatement pstmt=null;
		Product product = null;
		try 
		{
			String query = "select product_id,product_category,product_name,description,price,available_quantity,"
					 + "product_img,points_per_unit,status,offer from products where product_id= ?";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"), rs.getDouble("price"),
						rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"), rs.getString("status"), rs.getInt("offer"));
				return product;
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}

		return product;
	}

	
									//update product quantity after a purchase
	public void updateProductQuantity(Product currentProduct, int qty) throws SQLException {
		
		PreparedStatement pstmt=null;
		Connection con = null;
		try {
			String updateQtyQuery = "update products set available_quantity = ? where product_id = ?";
			con=ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(updateQtyQuery);
			pstmt.setInt(1, qty);
			pstmt.setInt(2, currentProduct.getProductId());
			pstmt.executeUpdate();
			pstmt.executeUpdate(commitQuery);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}

	}

	
									// search product by user 
	public List<Product> searchProduct(String productName) {
		
		List<Product> findedProducts = new ArrayList<>();
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			String query = "select product_id,product_category,product_name,description,price,available_quantity,product_img,"
					+ "points_per_unit,status,offer from products where product_name like ? OR product_category like ?  ";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productName+"%");
			pstmt.setString(2, productName+"%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"), rs.getString("status"), rs.getInt("offer"));
				findedProducts.add(product);
			}
			return findedProducts;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		
		
		return findedProducts;
	}
	
	
		public List<Product> adminViewProduts() {
		
		Connection con = null;
		PreparedStatement pstmt=null;
		List<Product> productList = new ArrayList<>();
		
		try 
		{
			String viewQuery = "select product_id,product_category,product_name,description,price,available_quantity,"
					 + " product_img,points_per_unit,status,offer from products";
			con=ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(viewQuery);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Product product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"), rs.getString("status"), rs.getInt("offer"));
				productList.add(product);
			}
			return productList;

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}

		return productList;
}
	

}
