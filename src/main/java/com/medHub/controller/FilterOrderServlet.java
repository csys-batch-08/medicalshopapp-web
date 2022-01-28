package com.medHub.controller;

import java.io.IOException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.DateMismatchException;
import com.medHub.dao.OrderDaoImpl;
import com.medHub.dao.OrderItemsDaoImpl;
import com.medHub.model.*;

@WebServlet("/filterOrder")
public class FilterOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		  HttpSession session = req.getSession();
		/*  String fromDate = req.getParameter("startDate"); 
		  String toDate =  req.getParameter("endDate");
		  int from= Integer.parseInt(fromDate.substring(8,10));
		  int to= Integer.parseInt(toDate.substring(8,10));
		  OrderItemsDaoImpl orderItem = new OrderItemsDaoImpl();
		  List<OrderItems> salesReport =  orderItem.salesReport(fromDate,toDate);
		  session.setAttribute("orders",salesReport);
		  res.sendRedirect("SalesReports.jsp");*/
		  
		  
			 double totalAmt=0;
	 		  String fromDate = req.getParameter("startDate"); 
			  String toDate =  req.getParameter("endDate");
			  OrderItemsDaoImpl orderItem = new OrderItemsDaoImpl();
			  int from= Integer.parseInt(fromDate.substring(8,10));
			  int to= Integer.parseInt(toDate.substring(8,10));
			  System.out.println(to-from);
			  if(to-from >= 0){ 
			  List<OrderItems> salesReport =  orderItem.salesReport(fromDate,toDate);
			  req.setAttribute("salesReport", salesReport);
			  req.setAttribute("totalAmt", totalAmt);
			  session.setAttribute("invalidDate",null);
			  RequestDispatcher rd = req.getRequestDispatcher("SalesReports2.jsp");
			  rd.forward(req, res);
			  }else{
					 try{
						 throw new DateMismatchException();
						 
					 }catch(DateMismatchException e)
					 {
						 session.setAttribute("invalidDate",e.getMessage());
						 RequestDispatcher rd = req.getRequestDispatcher("SalesReports2.jsp");
						 rd.forward(req, res);
						
					 }
				 }
				 
			
				
	 
			  

}
	}
