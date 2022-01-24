package com.medHub.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medHub.dao.UserDaoImpl;
import com.medHub.model.User;

@WebServlet("/ProfileUpdate")
public class UserProfileServlet extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute("user");
		String name = req.getParameter("updatedName");
		String password = req.getParameter("updatedPassword");
		long mobileNo =  Long.parseLong(req.getParameter("UpdatedMobNum"));
		String address = req.getParameter("UpdateDeliveryAddress");
		
		User user = new User(name,password,mobileNo,address);
		currentUser.setName(name);
		currentUser.setUserPassword(password);
		currentUser.setUserMobile(mobileNo);
		currentUser.setAddress(address);
		UserDaoImpl userDao = new UserDaoImpl();
		int updateStatus = userDao.update(currentUser);
		
		try {			
			res.sendRedirect("UserProfile.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	

}
