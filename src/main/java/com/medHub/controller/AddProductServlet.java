package com.medhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.ProductExistsException;
import com.medhub.dao.ProductDaoImpl;
import com.medhub.model.Product;

@WebServlet("/AddProductController")
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 2120470933156349026L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession session = req.getSession();
		String category = req.getParameter("category");
		String productname = req.getParameter("productName");
		double price=0;
		int quantity=0;
		int points=0;
		int offer =0;
		try {
		 price = Double.parseDouble(req.getParameter("price"));
		 quantity = Integer.parseInt(req.getParameter("quantity"));
		 points = Integer.parseInt(req.getParameter("points"));
		 offer = Integer.parseInt(req.getParameter("offer"));
		}catch(NumberFormatException n)
		{
			n.printStackTrace();
		}
		String description = req.getParameter("description");
		String imageurl = req.getParameter("imageFile");
		Product product = new Product(category, productname, price, quantity, imageurl, points, offer);
		product.setDescription(description);
		ProductDaoImpl products = new ProductDaoImpl();

		try {
			boolean flag = products.insertProduct(product);
			if (flag) {			
				RequestDispatcher rd = req.getRequestDispatcher("addProduct.jsp?status=addedSuccessfully");
				try {
					rd.forward(req, res);
				} catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}

			} else {
				throw new ProductExistsException();
				
			}
		} catch (SQLException |ProductExistsException e) {
			req.setAttribute("productExists", e.getMessage());
			RequestDispatcher rd = req.getRequestDispatcher("addProduct.jsp");
			try {
				rd.forward(req, res);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
