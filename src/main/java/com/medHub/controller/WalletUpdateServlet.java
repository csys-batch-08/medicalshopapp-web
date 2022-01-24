package com.medHub.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medHub.dao.UserDaoImpl;
import com.medHub.model.User;

@WebServlet("/walletUpdate")
public class WalletUpdateServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		session.setAttribute("InsuffientMoney",null);
		User currentUser = (User) session.getAttribute("user");
		double wallet = Long.parseLong(req.getParameter("UpdateWallet"));
		wallet=wallet+currentUser.getWallet();
		UserDaoImpl userDao = new UserDaoImpl();
		int result=userDao.addMoneyInWallet(wallet, currentUser);
		if(result>0)
		{
			res.sendRedirect("UserProfile.jsp");
		}
		
	}
}
