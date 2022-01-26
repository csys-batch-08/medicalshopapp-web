package com.medHub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medHub.dao.*;
import com.medHub.model.*;

@WebServlet("/ProdToBeUpdate")
public class ProductToBeUpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		int productId = Integer.parseInt(req.getParameter("productId"));
		ProductDaoImpl productDao = new ProductDaoImpl();
		Product currentProduct = productDao.findProductByProductId(productId);
		req.setAttribute("currentProduct", currentProduct);
		RequestDispatcher rd = req.getRequestDispatcher("UpdateProduct.jsp");
		 rd.forward(req, resp);
		
	}

}
