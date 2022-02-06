package com.medhub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medhub.dao.UserDaoImpl;

@WebServlet("/checkEmail")
public class CheckEmailServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 624609347315357984L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
		String email =req.getParameter("email"); 
		UserDaoImpl user = new UserDaoImpl();
		if(user.checkMail(email))
		{
			
			resp.getWriter().print("This Email Already Registered");
		}
		else {
			resp.getWriter().print("");
			}
		}catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
	

		
	}
	

}
