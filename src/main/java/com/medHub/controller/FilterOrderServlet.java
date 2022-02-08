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
import com.exceptions.DateMismatchException;
import com.medhub.dao.OrderItemsDaoImpl;
import com.medhub.model.*;

@WebServlet("/filterOrder")
public class FilterOrderServlet extends HttpServlet {

	private static final long serialVersionUID = -5477560504590184918L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		  HttpSession session = req.getSession();
		  try {
		  	double totalAmt=0;
	 		  String fromDate = req.getParameter("startDate"); 
			  String toDate =  req.getParameter("endDate");
			  OrderItemsDaoImpl orderItem = new OrderItemsDaoImpl();
			  int from= Integer.parseInt(fromDate.substring(8,10));
			  int to= Integer.parseInt(toDate.substring(8,10));
			  if(to-from >= 0){ 
			  List<OrderItems> salesReport =  orderItem.salesReport(fromDate,toDate);
			  req.setAttribute("salesReport", salesReport);
			  req.setAttribute("totalAmt", totalAmt);
			  session.setAttribute("invalidDate",null);
			  RequestDispatcher rd = req.getRequestDispatcher("salesReports2.jsp");
			  rd.forward(req, res);
			  }else{
					 
						 throw new DateMismatchException();
						 
		
				 }
		  }catch(NumberFormatException | ServletException | IOException | DateMismatchException e)
		  {
			  e.getMessage();
			  session.setAttribute("invalidDate",e.getMessage());
				 RequestDispatcher rd = req.getRequestDispatcher("salesReports2.jsp");
				 try {
				 rd.forward(req, res);
				 }catch(ServletException | IOException si)
				 {
					 si.getMessage();
				 }
		  }
				 
			
				
	 
			  

}
	}
