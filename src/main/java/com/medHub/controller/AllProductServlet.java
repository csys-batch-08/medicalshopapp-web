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


@WebServlet("/adminAllProducts")
public class AllProductServlet extends HttpServlet{
	
	private static final long serialVersionUID = -8892239316322971294L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ProductDaoImpl product = new ProductDaoImpl();
		List<Product> allproduct = product.viewProduts();
		req.setAttribute("allProducts", allproduct);
		System.out.println(allproduct.get(0).getStatus());
		RequestDispatcher rd = req.getRequestDispatcher("adminAllProducts.jsp?deleteProductId=0");
		 try {
			 rd.forward(req, resp);
			 }catch(ServletException se)
			 {
				se.printStackTrace(); 
			 }catch (IOException e) {
				e.printStackTrace();
			 }
		
	}

}
