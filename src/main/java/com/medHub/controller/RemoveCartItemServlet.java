package com.medHub.controller;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/removeCartItem")
public class RemoveCartItemServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
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
				res.sendRedirect("Cart.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
