package com.medhub.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.DateMismatchException;
import com.exceptions.UserNotFoundException;
import com.medhub.dao.AdminDaoImpl;
import com.medhub.dao.ProductDaoImpl;
import com.medhub.dao.UserDaoImpl;
import com.medhub.model.*;




@WebServlet("/LoginController")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession(); 
		String email = req.getParameter("loginMail").toLowerCase();
		String password = req.getParameter("loginPassword");
		User user;
		UserDaoImpl userDao = new UserDaoImpl();
		Admin admin;
		AdminDaoImpl admindao= new AdminDaoImpl();
		User currentuser;	
		try {
			
		if(!email.endsWith("medhub.com"))
		{
			user=new User(email,password);
			currentuser= userDao.login(user);
			
			
			if(currentuser!=null)
			{
				session.setAttribute("user", currentuser);
				req.setAttribute("currentUser", currentuser);
				ProductDaoImpl product= new ProductDaoImpl();
				List<Product> allproduct = product.viewProduts();
				Product searchProducts = new Product(); 
				req.setAttribute("allProducts", allproduct);
				RequestDispatcher rd = req.getRequestDispatcher("userHome.jsp");
				rd.forward(req, res);
			}
			else
			{

				try {
				throw new UserNotFoundException();
				}catch(UserNotFoundException e)
				 {
					
					 session.setAttribute("InvalidUser",e.getMessage());
					 RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					 rd.forward(req, res);
					
				 }
				
			}
		}else
		{
			try {
				admin=new Admin(email,password);
				Admin adminModule= admindao.login(admin);
				if(adminModule!=null)
				{
					res.sendRedirect("adminHome.jsp");

				}
				else
				{
					throw new UserNotFoundException();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
		}
		
		
			} catch (IOException e) {
			e.printStackTrace();
			} catch (UserNotFoundException e) {
				session.setAttribute("InvalidUser",e.getMessage());
				 RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				 rd.forward(req, res);
			}
		
	}

}
