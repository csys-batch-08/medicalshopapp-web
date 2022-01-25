package com.medHub.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.medHub.dao.ProductDaoImpl;
import com.medHub.model.Product;

@WebServlet("/allProducts")
public class UserHomeAllProducts extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		ProductDaoImpl product= new ProductDaoImpl();
		System.out.println(1);
		List<Product> allproduct = product.viewProduts();
		System.out.println(2);
		Product searchProducts = new Product(); 
		System.out.println(3);
		req.setAttribute("allProducts", allproduct);
		System.out.println(4);
		
		
	}

}
