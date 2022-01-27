package com.medHub.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medHub.dao.ProductDaoImpl;
import com.medHub.model.Product;

@WebServlet("/UpdateProductController")

public class UpdateProductServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		ProductDaoImpl productdao = new ProductDaoImpl();
		int prodId= Integer.parseInt(req.getParameter("currentProdId"));
		String category= req.getParameter("category");
		String productname= req.getParameter("productName");
		double price = Double.parseDouble(req.getParameter("price"));
		int quantity= Integer.parseInt(req.getParameter("quantity"));
		String imageurl= req.getParameter("imageUrl");
		int points = Integer.parseInt(req.getParameter("points"));
		int offer=Integer.parseInt(req.getParameter("offer"));
		String description= req.getParameter("description");
		Product currentProduct = productdao.findProductByProductId(prodId);	
		int updateQty= currentProduct.getQuantity()+quantity;
		Product product= new Product(category,productname,price,updateQty,imageurl,points,offer,description,prodId);
		ProductDaoImpl products = new ProductDaoImpl();
		
		try {
			int result=products.updateProducts(product);
			if(result>0)
			{
				product= new Product(category,productname,price,updateQty,imageurl,points,offer,description,prodId);
				res.sendRedirect("adminAllProducts");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
