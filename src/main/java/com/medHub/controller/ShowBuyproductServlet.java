package com.medhub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.medhub.dao.ProductDaoImpl;
import com.medhub.model.Product;

@WebServlet("/showBuyProduct")
public class ShowBuyproductServlet extends HttpServlet{
	
	private static final long serialVersionUID = 2604399059551099108L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		System.out.println();
		int pId=Integer.parseInt(req.getParameter("pid"));
	
		ProductDaoImpl productDao = new ProductDaoImpl();
		Product currentProduct = productDao.findProductByProductId(pId);
		req.setAttribute("currentProduct", currentProduct);
		session.setAttribute("currentproduct", currentProduct);
		System.out.println(currentProduct.getProductCategory());
		System.out.println(currentProduct.getProductName());
		System.out.println(currentProduct.getDescription());
		System.out.println(currentProduct.getUnitPrice());
		System.out.println(currentProduct.getQuantity());
		System.out.println(currentProduct.getPoints());
		System.out.println(currentProduct.getOffer());
		RequestDispatcher rd = req.getRequestDispatcher("buyProduct.jsp");
		rd.forward(req, resp);
		
		
	}

}
