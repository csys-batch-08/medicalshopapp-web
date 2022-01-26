package com.medHub.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.medHub.dao.*;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		int deletePId = Integer.parseInt(req.getParameter("deleteProductId"));
		ProductDaoImpl product = new ProductDaoImpl();

		try {
			int result = product.deleteProduct(deletePId);
			if (result > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("adminAllProducts");
				rd.forward(req, resp);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
