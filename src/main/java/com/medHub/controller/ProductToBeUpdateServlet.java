package com.medhub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medhub.dao.*;
import com.medhub.model.*;

@WebServlet("/ProdToBeUpdate")
public class ProductToBeUpdateServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
		int productId = Integer.parseInt(req.getParameter("productId"));
		ProductDaoImpl productDao = new ProductDaoImpl();
		Product currentProduct = productDao.findProductByProductId(productId);
		req.setAttribute("currentProduct", currentProduct);
		RequestDispatcher rd = req.getRequestDispatcher("updateProduct.jsp");
		 rd.forward(req, resp);
		}catch (ServletException | IOException  | NumberFormatException e) {
			e.getMessage();
		}
		
	}

}
