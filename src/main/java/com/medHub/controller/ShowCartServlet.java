package com.medhub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.medhub.dao.*;
import com.medhub.model.*;

@WebServlet("/showCartServlet")
public class ShowCartServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User currentUser = (User)session.getAttribute("user");
		 OrderItemsDaoImpl myOrder= new OrderItemsDaoImpl();
		CartDaoImpl cartDao = new CartDaoImpl();
		List<Cart> cartItems = cartDao.viewCart(currentUser);
		req.setAttribute("cartList", cartItems);
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);
	}

}
