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

@WebServlet("/ProfileUpdate")
public class UserProfileServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		try {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute("user");
		String name = req.getParameter("updatedName");
		String password = req.getParameter("updatedPassword");
		long mobileNo =  Long.parseLong(req.getParameter("UpdatedMobNum"));
		String address = req.getParameter("UpdateDeliveryAddress");		
		currentUser.setUsername(name);
		currentUser.setUserPassword(password);
		currentUser.setUserMobile(mobileNo);
		currentUser.setAddress(address);
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.update(currentUser);
		req.setAttribute("currentUser", currentUser);
		RequestDispatcher rd = req.getRequestDispatcher("userProfile.jsp");
		rd.forward(req, res);
		}catch (ServletException |NumberFormatException | IOException e) {
			e.getMessage();
		}

		
		
	}
	

}
