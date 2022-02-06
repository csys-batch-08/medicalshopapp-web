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
	
	final String commitQuery= "commit";
										//Show All Products
	public List<Product> viewProduts() {
		
		Connection con = null;
		PreparedStatement pst=null;
		List<Product> productList = new ArrayList<>();
		
		try 
		{
			String viewQuery = "select product_id,product_category,product_name,description,price,available_quantity,"
					 + " product_img,points_per_unit,status,offer from products where status= ? ";
			con=ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(viewQuery);
			pst.setString(1, "available");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Product product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"), rs.getString("status"), rs.getInt("offer"));
				productList.add(product);
			}
			return productList;

		}catch (SQLException e) {
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

		return productList;
}
	

									// Insert Product By Admin
	public Boolean insertProduct(Product productModel) throws SQLException {
		boolean flag = false;
		Connection con = null;ConnectionUtil.getDBconnect();
		PreparedStatement pst =null;
		try {
			String query = "insert into products (product_category,product_name,description,price,available_quantity,product_img,points_per_unit,offer) values (?,?,?,?,?,?,?,?)";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setString(1, productModel.getProductCategory());
			pst.setString(2, productModel.getProductName());
			pst.setString(3, productModel.getDescription());
			pst.setDouble(4, productModel.getUnitPrice());
			pst.setInt(5, productModel.getQuantity());
			pst.setString(6, productModel.getProductImg());
			pst.setInt(7, productModel.getPoints());
			pst.setInt(8, productModel.getOffer());
			int result = pst.executeUpdate();

			if (result > 0) {
				flag = true;
				return flag;
			}

		}catch (SQLException e) {

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
		return false;
	}

										
												//Update Products By ADmin
	public int updateProducts(Product product) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int result=0;

		try {
			String updateQwery = "update products set product_category=?,product_name=?,price=?,available_Quantity=?,product_img=?,points_per_unit=?,offer=?,description=?,status=? where product_id=?";
			con=ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(updateQwery);
			pst.setString(1, product.getProductCategory());
			pst.setString(2, product.getProductName());
			pst.setDouble(3, product.getUnitPrice());
			pst.setDouble(4, product.getQuantity());
			pst.setString(5, product.getProductImg());
			pst.setInt(6, product.getPoints());
			pst.setInt(7, product.getOffer());
			pst.setString(8, product.getDescription());
			pst.setString(9,"available");
			pst.setInt(10, product.getProductId());
			result = pst.executeUpdate();
			pst.executeUpdate(commitQuery);
			
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
		return result;
	}

												//Delete Product by admin
	public int deleteProduct(int productId) throws SQLException {
		
		int res=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
		String qwery = "update products set status= ? where product_id=?";
		con = ConnectionUtil.getDBconnect();
		pst = con.prepareStatement(qwery);
		pst.setString(1, "unavailable");
		pst.setInt(2, productId);
		res = pst.executeUpdate();
		pst.executeUpdate(commitQuery);
		if (res > 0) {
			return res;
		}
		}catch(SQLException e)
		{
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
	
		return res;

	}
	
	

													//find Product By Name
	public Product findProductByName(String productName) {
		
		Connection con=null;
		PreparedStatement pst=null;
		
		Product product = null;
		try 
		{
			String query = "select product_id,product_category,product_name,description,price,available_quantity,"
					 + "product_img,points_per_unit from products where product_name= ? ";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setString(1,productName);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"), rs.getDouble("price"),
						rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"));
				return product;
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

		return product;
	}
	
	

								//find product by product Id
	public Product findProductByProductId(int id) {
		
		Connection con =null;
		PreparedStatement pst=null;
		
		Product product = null;
		try 
		{
			String query = "select product_id,product_category,product_name,description,price,available_quantity,"
					 + "product_img,points_per_unit,status,offer from products where product_id= ?";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"), rs.getDouble("price"),
						rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"), rs.getString("status"), rs.getInt("offer"));
				return product;
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

		return product;
	}

	
									//update product quantity after a purchase
	public void updateProductQuantity(Product currentProduct, int qty) throws SQLException {
		
		PreparedStatement pst=null;
		Connection con = null;
		try {
			String updateQtyQuery = "update products set available_quantity = ? where product_id = ?";
			con=ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(updateQtyQuery);
			pst.setInt(1, qty);
			pst.setInt(2, currentProduct.getProductId());
			pst.executeUpdate();
			pst.executeUpdate(commitQuery);
		}catch (SQLException e) {
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

	}

	
									// search product by user 
	public List<Product> searchProduct(String productName) {
		
		List<Product> findedProducts = new ArrayList<>();
		Connection con =null;
		PreparedStatement pst=null;
		try {
			String query = "select product_id,product_category,product_name,description,price,available_quantity,product_img,"
					+ "points_per_unit,status,offer from products where product_name like ? OR product_category like ?  ";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setString(1, productName+"%");
			pst.setString(2, productName+"%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"), rs.getString("status"), rs.getInt("offer"));
				findedProducts.add(product);
			}
			return findedProducts;

		} catch (Exception e) {
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
		
		
		return findedProducts;
	}
	
	
		public List<Product> adminViewProduts() {
		
		Connection con = null;
		PreparedStatement pst=null;
		List<Product> productList = new ArrayList<>();
		
		try 
		{
			String viewQuery = "select product_id,product_category,product_name,description,price,available_quantity,"
					 + " product_img,points_per_unit,status,offer from products";
			con=ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(viewQuery);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Product product = new Product(rs.getInt("product_id"), rs.getString("product_category"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("available_quantity"), rs.getString("product_img"), rs.getInt("points_per_unit"), rs.getString("status"), rs.getInt("offer"));
				productList.add(product);
			}
			return productList;

		}catch (SQLException e) {
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

		return productList;
}
	

}
