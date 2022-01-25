package com.medHub.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.exceptions.UserExistsException;
import com.exceptions.UserNotFoundException;
import com.medHub.dao.UserDaoImpl;
import com.medHub.model.*;






@WebServlet("/RegisterController")
public class RegisterServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(); 
		String fullName= req.getParameter("regfullName").toLowerCase();
		String mail=req.getParameter("regMail").toLowerCase();
		long mobile=Long.parseLong(req.getParameter("regMobile"));
		String password=req.getParameter("regPassword");
		User user = null;
		//int age= Integer.parseInt(req.getParameter("regAge"));
//		UserModel user = new UserModel(fullName,age,mobile,mail,password);
//		UserDao userDao= new UserDao();
		UserDaoImpl userdao = new UserDaoImpl();
		try {
		if(userdao.checkMail(mail))
		{
		
			if (mail.contains("@medhub.com")) {
			
			//System.out.println("notallow");
			session.setAttribute("notallow", "@medhub.com domain not allowed !");
			try {
				res.sendRedirect("Registration.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
			{
			user = new User(fullName,mobile,mail,password);
			UserDaoImpl userDao = new UserDaoImpl();
			userDao.insert(user);
			res.sendRedirect("RegisterWelcomeMessage.jsp");
			}
		}
	
		else {
			
			throw new UserExistsException();
				
		}
		
		}catch(UserExistsException e) {
			session.setAttribute("error", e.getMessage());
			
			res.sendRedirect("Registration.jsp");
		}
	}

}
