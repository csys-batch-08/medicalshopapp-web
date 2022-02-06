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
		int pId=Integer.parseInt(req.getParameter("pid"));
		ProductDaoImpl productDao = new ProductDaoImpl();
		Product currentProduct = productDao.findProductByProductId(pId);
		req.setAttribute("currentProduct", currentProduct);
		req.setAttribute("InsuffientMoney", null);
		session.setAttribute("currentproduct", currentProduct);
		RequestDispatcher rd = req.getRequestDispatcher("buyProduct.jsp");
		rd.forward(req, resp);
		
		
	}

}
