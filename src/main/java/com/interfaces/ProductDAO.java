package com.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.medHub.model.Product;

public interface ProductDAO {
	
	public List<Product> viewProduts();
	public Boolean insertProduct(Product productModel) throws SQLException;
	public int deleteProduct(int productId) throws SQLException;
	public Product findProductByName(String productName);
	public Product findProductByProductId(int id);
	public int updateProducts(Product product) throws SQLException;
	public void updateProductQuantity(Product currentProduct, int qty) throws SQLException;
	public List<Product> searchProduct(String Productname);
}
