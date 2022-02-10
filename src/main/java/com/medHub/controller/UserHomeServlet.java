package com.medhub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medhub.dao.ProductDaoImpl;
import com.medhub.model.Product;

@WebServlet("/userHomeServlet")
public class UserHomeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		ProductDaoImpl product= new ProductDaoImpl();
		List<Product> allproduct = product.viewProduts();
		req.setAttribute("allProducts", allproduct);
		RequestDispatcher rd = req.getRequestDispatcher("userHome.jsp");
		rd.forward(req, resp);
		}catch (IOException | ServletException e) {
			e.getMessage();
		}
	}

}
