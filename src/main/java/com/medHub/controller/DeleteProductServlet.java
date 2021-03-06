package com.medhub.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.medhub.dao.*;
import com.medhub.model.Product;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = -5037205572770946551L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		int deletePId = Integer.parseInt(req.getParameter("deleteProductId"));
		ProductDaoImpl product = new ProductDaoImpl();
			int result = product.deleteProduct(deletePId);
			if (result > 0) {
				ProductDaoImpl product1 = new ProductDaoImpl();
				List<Product> allproduct = product1.adminViewProduts();
				req.setAttribute("allProducts", allproduct);
				RequestDispatcher rd = req.getRequestDispatcher("adminAllProducts.jsp?status=deleted");
					rd.forward(req, resp);
			}
			else{
				ProductDaoImpl product1 = new ProductDaoImpl();
				List<Product> allproduct = product1.viewProduts();
				req.setAttribute("allProducts", allproduct);
				RequestDispatcher rd = req.getRequestDispatcher("adminAllProducts.jsp?deleteFailure=deleteFailure");
				rd.forward(req, resp);
			}
		} catch (SQLException | ServletException e) {

			e.printStackTrace();
		}

	}

}
