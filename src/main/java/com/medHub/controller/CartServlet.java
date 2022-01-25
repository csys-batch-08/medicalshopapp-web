package com.medHub.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medHub.dao.CartDaoImpl;
import com.medHub.dao.OrderDaoImpl;
import com.medHub.dao.OrderItemsDaoImpl;
import com.medHub.dao.ProductDaoImpl;
import com.medHub.dao.UserDaoImpl;
import com.medHub.model.Cart;
import com.medHub.model.Order;
import com.medHub.model.OrderItems;
import com.medHub.model.Product;
import com.medHub.model.User;

@WebServlet("/cartserv")
public class CartServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
	
		HttpSession session = req.getSession();
		double totalprice=Double.parseDouble(req.getParameter("cartTotalPrice"));
		int quantity = Integer.parseInt(req.getParameter("cartQuanity"));
		User currentUser = (User) session.getAttribute("user");
		Product currentproduct = (Product) session.getAttribute("currentproduct");
		CartDaoImpl cartDao = new CartDaoImpl();
		Cart cart = new Cart();
		
		cart.setUser(currentUser);
		cart.setProduct(currentproduct);
		cart.setQty(quantity);
		cart.setTotalPrice(totalprice);
		int prodquant;
		try {
			prodquant = cartDao.productexist(cart);
			if(prodquant < 0) {
			cartDao.insertProduct(cart);
			}else {
				int oldprice = cartDao.productexist1(cart);
				cart.setQty(quantity + prodquant);
				cart.setTotalPrice(oldprice + totalprice);
				cartDao.updatequantity(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.sendRedirect("Cart.jsp");
	}
}
