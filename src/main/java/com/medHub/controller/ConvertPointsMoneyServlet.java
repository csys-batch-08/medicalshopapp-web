package com.medhub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.CartNotEnoughQtyException;
import com.exceptions.NegativePointsException;
import com.medhub.dao.OrderDaoImpl;
import com.medhub.dao.OrderItemsDaoImpl;
import com.medhub.dao.ProductDaoImpl;
import com.medhub.dao.UserDaoImpl;
import com.medhub.model.Order;
import com.medhub.model.OrderItems;
import com.medhub.model.Product;
import com.medhub.model.User;

@WebServlet("/ConvertMoney")
public class ConvertPointsMoneyServlet extends HttpServlet{

	private static final long serialVersionUID = -508535237820559918L;

	public void doGet(HttpServletRequest req,HttpServletResponse res){
		
		try {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute("user");
		int points=Integer.parseInt(req.getParameter("pointsMoney"));
		try {
		if(points>0) {
		double converted = (double)Math.ceil((points * 10)/100);
		double wallet=currentUser.getWallet()+converted;
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.addMoneyInWallet(wallet, currentUser);
		userDao.updateUserPoints(null);
		boolean flag=userDao.updatePointsConverted(currentUser);
		if(flag)
		{
			req.setAttribute("currentUser", currentUser);
			RequestDispatcher rd = req.getRequestDispatcher("userProfile.jsp");
			rd.forward(req, res);
		}
		}else
		{
			try {
				throw new NegativePointsException();
				}catch(NegativePointsException e)
				{
					session.setAttribute("negativePoints",e.getMessage());
					req.setAttribute("currentUser", currentUser);
					RequestDispatcher rd = req.getRequestDispatcher("userProfile.jsp");
					rd.forward(req, res);
				}
			
		}
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		}catch (NumberFormatException e) {
				e.printStackTrace();
		}	
	}
}
