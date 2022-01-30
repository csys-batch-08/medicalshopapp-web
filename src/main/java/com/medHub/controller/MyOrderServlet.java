package com.medhub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medhub.dao.*;
import com.medhub.model.*;

@WebServlet("/myOrdersServlet")
public class MyOrderServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		OrderItemsDaoImpl myOrder= new OrderItemsDaoImpl();
		User currentUser = (User)session.getAttribute("user");
		List<OrderItems> myOrderList = myOrder.ViewMyOrders(currentUser);
		
		
		 
		
		
		req.setAttribute("myOrders", myOrderList);
		RequestDispatcher rd = req.getRequestDispatcher("myOrders.jsp?orderId=0&totalPrice=0&quantity=0&points=0&productId=0");
		rd.forward(req, resp);
	}

}
