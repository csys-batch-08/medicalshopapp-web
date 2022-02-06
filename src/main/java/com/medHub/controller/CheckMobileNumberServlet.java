package com.medhub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medhub.dao.UserDaoImpl;

@WebServlet("/checkNumber")
public class CheckMobileNumberServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1282788487163554515L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		Long mobile =Long.parseLong(req.getParameter("number"));
		UserDaoImpl user = new UserDaoImpl();
		if(user.checkMobileNum(mobile))
		{
			resp.getWriter().print("This Number Already Registered");
		}else {
			resp.getWriter().print("");
		}

		}catch(NumberFormatException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
