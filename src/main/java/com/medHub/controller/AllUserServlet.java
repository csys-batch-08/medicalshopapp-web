package com.medhub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medhub.dao.UserDaoImpl;
import com.medhub.model.User;

@WebServlet("/allUsers")
public class AllUserServlet extends HttpServlet{
	
	private static final long serialVersionUID = -5803969482139873961L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
		 UserDaoImpl userdao = new UserDaoImpl();
		 List<User> userList=userdao.viewAllUser();
		 req.setAttribute("userList",userList);
		 RequestDispatcher rd = req.getRequestDispatcher("allUser.jsp");
		 try {
		 rd.forward(req, resp);
		 }catch(ServletException se)
		 {
			se.printStackTrace(); 
		 }catch (IOException e) {
			e.printStackTrace();
		 }
	
	}

}
