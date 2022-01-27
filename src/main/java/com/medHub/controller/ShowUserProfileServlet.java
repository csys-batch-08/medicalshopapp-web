package com.medHub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.medHub.model.*;

@WebServlet("/showUserProfile")
public class ShowUserProfileServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User currentUser = (User)session.getAttribute("user");
		req.setAttribute("currentUser", currentUser);
		RequestDispatcher rd = req.getRequestDispatcher("UserProfile.jsp");
		rd.forward(req, resp);
		
	}

}
