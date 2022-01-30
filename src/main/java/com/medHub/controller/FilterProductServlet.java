package com.medhub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.medhub.dao.*;
import com.medhub.model.*;

@WebServlet("/filterProductservlet")
public class FilterProductServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Pname = req.getParameter("ProductName").toLowerCase();
		ProductDaoImpl product= new ProductDaoImpl();
		 Product searchProducts = new Product(); 
		List<Product> allproduct = product.searchProduct(Pname);
		req.setAttribute("allProducts", allproduct);
		RequestDispatcher rd = req.getRequestDispatcher("filteredProduct.jsp");
		rd.forward(req, resp);
	}

}
