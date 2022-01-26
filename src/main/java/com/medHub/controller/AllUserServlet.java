package com.medHub.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medHub.dao.UserDaoImpl;
import com.medHub.model.User;

@WebServlet("/allUsers")
public class AllUserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 UserDaoImpl userdao = new UserDaoImpl();
		 List<User> userList = new ArrayList<User>();
		 userList=userdao.ViewAllUser();
		 req.setAttribute("userList",userList);
		 RequestDispatcher rd = req.getRequestDispatcher("AllUser.jsp");
		 rd.forward(req, resp);
	
	}

}
