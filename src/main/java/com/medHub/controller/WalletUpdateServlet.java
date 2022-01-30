package com.medhub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medhub.dao.UserDaoImpl;
import com.medhub.model.User;

@WebServlet("/walletUpdate")
public class WalletUpdateServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		session.setAttribute("InsuffientMoney",null);
		User currentUser = (User) session.getAttribute("user");
		double wallet = Long.parseLong(req.getParameter("UpdateWallet"));
		wallet=wallet+currentUser.getWallet();
		UserDaoImpl userDao = new UserDaoImpl();
		int result=userDao.addMoneyInWallet(wallet, currentUser);
		if(result>0)
		{
			req.setAttribute("currentUser", currentUser);
			RequestDispatcher rd = req.getRequestDispatcher("userProfile.jsp");
			rd.forward(req, res);
		}
		
	}
}
