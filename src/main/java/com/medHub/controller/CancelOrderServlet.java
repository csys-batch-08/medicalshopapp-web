package com.medHub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medHub.dao.*;
import com.medHub.model.*;

@WebServlet("/cancelOrderServlet")
public class CancelOrderServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,NumberFormatException{
		
		HttpSession session = req.getSession();
		User currentUser = (User)session.getAttribute("user");
		OrderDaoImpl currentCancelOrder = new OrderDaoImpl();
		OrderItemsDaoImpl orderItem = new OrderItemsDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int orderId=Integer.parseInt(req.getParameter("orderId"));
		OrderDaoImpl orderDao=new OrderDaoImpl();	
		boolean deleteStatus = false;
		try {
			deleteStatus = currentCancelOrder.deleteProduct(orderId);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		double totalAmt= Double.parseDouble(req.getParameter("totalPrice"));
		double returnAmt = Math.round(totalAmt-(totalAmt*10/100));
		double availableWallet= currentUser.getWallet()+returnAmt;
		int quanity = Integer.parseInt(req.getParameter("quantity"));
		int points = Integer.parseInt(req.getParameter("points"));
		int productId = Integer.parseInt(req.getParameter("productId"));
		userDao.updateWalletMoney(availableWallet, currentUser);
		currentUser.setWallet(availableWallet);
		int availablePoints = currentUser.getPoints()-points;
		userDao.updateUserPoints(availablePoints, currentUser);
		currentUser.setPoints(availablePoints);
		Product cancelledProduct;
		
		
		
		if(productId>0)
		{
			 cancelledProduct = productDao.findProductByProductId(productId);
			 int updatedQty = cancelledProduct.getQuantity()+quanity;
			cancelledProduct.setQuantity(updatedQty);
			try {
				productDao.updateProductQuantity(cancelledProduct, updatedQty);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		if(deleteStatus) {
		PrintWriter out = resp.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Order Cancelled Sucessfully');");
		out.println("location= 'myOrdersServlet'");
		out.println("</script>");
		}
			
		
		
	}

}
