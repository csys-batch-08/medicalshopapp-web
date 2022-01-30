package com.medhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession session = req.getSession();
		String category = req.getParameter("category");
		String productname = req.getParameter("productName");
		double price = Double.parseDouble(req.getParameter("price"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String imageurl = req.getParameter("imageFile");
		int points = Integer.parseInt(req.getParameter("points"));
		int offer = Integer.parseInt(req.getParameter("offer"));
		String description = req.getParameter("description");

		Product product = new Product(category, productname, price, quantity, imageurl, points, offer, description);
		ProductDaoImpl products = new ProductDaoImpl();

		try {
			boolean flag = products.insertProduct(product);
			if (flag) {			
				PrintWriter out = res.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('New Product Added SucessFully');");
				out.println("location='addProduct.jsp';");
				out.println("</script>");
			} else {
				throw new ProductExistsException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ProductExistsException e) {
			e.getMessage();
			session.setAttribute("productExists", e.getMessage());
			res.sendRedirect("addProduct.jsp");

		}
	}

}
