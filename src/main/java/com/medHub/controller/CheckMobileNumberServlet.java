package com.medhub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medhub.dao.UserDaoImpl;

public class CheckMobileNumberServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1282788487163554515L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long mobile =Long.parseLong(req.getParameter("mobile"));
		UserDaoImpl user = new UserDaoImpl();
		user.checkMobileNum(mobile);
	}
}
