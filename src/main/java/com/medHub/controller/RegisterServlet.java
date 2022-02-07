package com.medhub.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.UserExistsException;
import com.medhub.dao.UserDaoImpl;
import com.medhub.model.*;

@WebServlet("/registerController")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(); 
		String fullName= req.getParameter("regfullName").toLowerCase();
		String mail=req.getParameter("regMail").toLowerCase();
		long mobile=Long.parseLong(req.getParameter("regMobile"));
		String password=req.getParameter("regPassword");
		User user = null;
		UserDaoImpl userdao = new UserDaoImpl();
		
		if(!userdao.checkMail(mail))
		{
		
			if(mail.contains("@medhub.com")) {
			session.setAttribute("notallow", "@medhub.com domain not allowed !");
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
		
				try {
					rd.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			
		}else
			{
			user = new User(fullName,mobile,mail,password);
			UserDaoImpl userDao = new UserDaoImpl();
			
				if(userDao.insert(user)){
						System.out.println("inserted");
						res.sendRedirect("registerWelcomeMessage.jsp");
				}
			
			
			}
		
			}else {
				
				System.out.println("alredayd arwefr");
				try {
				throw new UserExistsException();
				}catch (UserExistsException e) {
					e.printStackTrace();
					System.out.println("user excepion");
					session.setAttribute("error", e.getMessage());
						RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
						try {
							rd.forward(req, res);
						} catch (ServletException | IOException e1) {
							e1.printStackTrace();
						}
				}
				 
			}
			
			
			
	}
}

/*
 * else { try { throw new UserExistsException(); }catch(UserExistsException e) {
 * session.setAttribute("error", e.getMessage()); RequestDispatcher rd =
 * req.getRequestDispatcher("registration.jsp"); try { rd.forward(req, res); }
 * catch (ServletException | IOException e1) { e1.printStackTrace(); } }
 * 
 * }
 */
