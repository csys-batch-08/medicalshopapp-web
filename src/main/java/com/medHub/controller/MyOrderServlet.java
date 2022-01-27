package com.medHub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medHub.dao.*;
import com.medHub.model.*;

@WebServlet("/myOrdersServlet")
public class MyOrderServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		OrderItemsDaoImpl myOrder= new OrderItemsDaoImpl();
		User currentUser = (User)session.getAttribute("user");
		List<OrderItems> myOrderList = myOrder.ViewMyOrders(currentUser);
		req.setAttribute("myOrders", myOrderList);
		RequestDispatcher rd = req.getRequestDispatcher("MyOrders.jsp");
		rd.forward(req, resp);
	}

}
