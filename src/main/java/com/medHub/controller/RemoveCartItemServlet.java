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

@WebServlet("/removeCartItem")
public class RemoveCartItemServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession();
		
		UserDaoImpl user = new UserDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		Cart cart = new Cart();
		CartDaoImpl cartdao = new CartDaoImpl();
		Product product = new Product();
		User currentUser = (User)session.getAttribute("user");
		int removeStatus;
		int CartproductId = Integer.parseInt(req.getParameter("CartproductId"));
		Product currentProduct = productDao.findProductByProductId(CartproductId);
		cart.setProduct(currentProduct);
		cart.setUser(currentUser);
		try {
			 removeStatus=cartdao.removecartItems(cart);
			if(removeStatus>0)
			{
				List<Cart> cartItems = cartdao.viewCart(currentUser);
				req.setAttribute("cartList", cartItems);
				RequestDispatcher rd = req.getRequestDispatcher("cart.jsp?removestatus=removed");
				rd.forward(req, res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
