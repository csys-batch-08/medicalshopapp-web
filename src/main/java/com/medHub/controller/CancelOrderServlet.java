package com.medhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medhub.dao.*;
import com.medhub.model.*;

@WebServlet("/cancelOrderServlet")
public class CancelOrderServlet extends HttpServlet {

	private static final long serialVersionUID = -4520372450707733897L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws NullPointerException{
		
		HttpSession session = req.getSession();
		User currentUser = (User)session.getAttribute("user");
		OrderDaoImpl currentCancelOrder = new OrderDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();
		int orderId=0;
		try {
		 orderId=Integer.parseInt(req.getParameter("orderId"));
		}catch(NumberFormatException n)
		{
			n.printStackTrace();
		}
		boolean deleteStatus = false;
		try {
			deleteStatus = currentCancelOrder.deleteProduct(orderId);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		double totalAmt = 0;
		int quanity = 0;
		int points = 0;
		int productId = 0;
		try {
		 totalAmt= Double.parseDouble(req.getParameter("totalPrice"));
		 quanity = Integer.parseInt(req.getParameter("quantity"));
		 points = Integer.parseInt(req.getParameter("points"));
		 productId = Integer.parseInt(req.getParameter("productId"));
		}catch(NumberFormatException n)
		{
			n.printStackTrace();
		}
		double returnAmt = Math.round(totalAmt-(totalAmt*10/100));
		double availableWallet= currentUser.getWallet()+returnAmt;
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
		
		
		
		PrintWriter out = null;
		if(deleteStatus){
		try {
			out = resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Order Cancelled Sucessfully');");
			out.println("location= 'myOrdersServlet'");
			out.println("</script>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		}
			
		
		
	}

}
