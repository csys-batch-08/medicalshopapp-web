package com.medhub.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medhub.dao.ProductDaoImpl;
import com.medhub.model.Product;

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
				ProductDaoImpl product1 = new ProductDaoImpl();
				List<Product> allproduct = product1.viewProduts();
				req.setAttribute("allProducts", allproduct);
				req.setAttribute("updateCheck", "updated");
				RequestDispatcher rd = req.getRequestDispatcher("adminAllProducts.jsp");
				try {
					rd.forward(req, res);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
