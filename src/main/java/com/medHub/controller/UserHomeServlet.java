package com.medHub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medHub.dao.ProductDaoImpl;
import com.medHub.model.Product;

@WebServlet("/userHomeServlet")
public class UserHomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDaoImpl product= new ProductDaoImpl();
		List<Product> allproduct = product.viewProduts();
		Product searchProducts = new Product(); 
		req.setAttribute("allProducts", allproduct);
		RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp");
		rd.forward(req, resp);
	}

}
