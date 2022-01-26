package com.medHub.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.CartNotEnoughQtyException;
import com.exceptions.NegativePointsException;
import com.medHub.dao.OrderDaoImpl;
import com.medHub.dao.OrderItemsDaoImpl;
import com.medHub.dao.ProductDaoImpl;
import com.medHub.dao.UserDaoImpl;
import com.medHub.model.Order;
import com.medHub.model.OrderItems;
import com.medHub.model.Product;
import com.medHub.model.User;

@WebServlet("/ConvertMoney")
public class ConvertPointsMoneyServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute("user");
		int points=Integer.parseInt(req.getParameter("pointsMoney"));
		try {
		if(points>0) {
		double Converted = Math.round((points * 10)/100);
		double wallet=currentUser.getWallet()+Converted;
		UserDaoImpl userDao = new UserDaoImpl();
		int result=userDao.addMoneyInWallet(wallet, currentUser);
		userDao.updateUserPoints(null);
		boolean flag=userDao.updatePointsConverted(currentUser);
		if(flag)
		{
			res.sendRedirect("UserProfile.jsp");
		}
		}else
		{
			try {
				throw new NegativePointsException();
				}catch(NegativePointsException e)
				{
					session.setAttribute("negativePoints",e.getMessage());
					res.sendRedirect("UserProfile.jsp");
				}
			
		}
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
