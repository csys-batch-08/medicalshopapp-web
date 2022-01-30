package com.medhub.controller;

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

import com.medhub.dao.CartDaoImpl;
import com.medhub.dao.OrderDaoImpl;
import com.medhub.dao.OrderItemsDaoImpl;
import com.medhub.dao.ProductDaoImpl;
import com.medhub.dao.UserDaoImpl;
import com.medhub.model.Cart;
import com.medhub.model.Order;
import com.medhub.model.OrderItems;
import com.medhub.model.Product;
import com.medhub.model.User;

@WebServlet("/cartserv")
public class CartServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	
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
		
		List<Cart> cartItems = cartDao.viewCart(currentUser);
		req.setAttribute("cartList", cartItems);
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, res);
	}
}
