package com.medHub.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medHub.dao.OrderDaoImpl;
import com.medHub.dao.OrderItemsDaoImpl;

@WebServlet("/filter")
public class FilterOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		  HttpSession session = req.getSession();
		  String fromDate = req.getParameter("startDate"); 
		  String toDate =  req.getParameter("endDate");
		  int from= Integer.parseInt(fromDate.substring(8,10));
		  int to= Integer.parseInt(toDate.substring(8,10));
		  OrderItemsDaoImpl orderItem = new OrderItemsDaoImpl();
		  ResultSet rs=  orderItem.salesReport(fromDate,toDate);
		  session.setAttribute("orders",rs);
		  res.sendRedirect("SalesReports.jsp");

	}

}
