package com.medHub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.AddressNotFoundException;
import com.exceptions.CartNotEnoughQtyException;
import com.exceptions.InsuffientMoneyException;
import com.exceptions.OutOfStockException;
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

@WebServlet("/cartOrder")

public class CartOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		UserDaoImpl user = new UserDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		Product product = new Product();
		OrderItems orderItems = new OrderItems();
		Cart cart = new Cart();
		CartDaoImpl cartdao = new CartDaoImpl();
		Order order = new Order();
		OrderDaoImpl orderDao = new OrderDaoImpl();
		OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();

		User currentUser = (User) session.getAttribute("user");

		int CartproductId = Integer.parseInt(req.getParameter("CartproductId"));
		int cartQuantity = Integer.parseInt(req.getParameter("cartQuantity"));
		double unitPrice = Double.parseDouble(req.getParameter("unitPrice"));
		double totalPrice = Double.parseDouble(req.getParameter("totalPrice"));
		int cartpoints = Integer.parseInt(req.getParameter("cartpoints"));
		int CartprodId = Integer.parseInt(req.getParameter("CartproductId"));
		int removeStatus;

		Product currentProduct = productDao.findProductByProductId(CartproductId);
		cart.setProduct(currentProduct);
		cart.setUser(currentUser);
		
		if(currentUser.getAddress()!=null && !currentUser.getAddress().equals("null")) {
		if(currentProduct.getQuantity() != 0) {
		if (currentProduct.getQuantity() - cartQuantity > 0) {

			if ((currentUser.getWallet() - totalPrice) >= 0) {
				order.setProduct(currentProduct);
				int updateQty = currentProduct.getQuantity() - cartQuantity;

				try {
					productDao.updateProductQuantity(currentProduct, updateQty);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				order.setPrice(totalPrice);
				order.setUser(currentUser);
				order.getUser().setPoints(currentProduct.getPoints() + currentUser.getPoints());
				order.getUser().setWallet(currentUser.getWallet() - totalPrice);
				orderDao.orders(order, currentUser);
				user.updateUserPoints(order);
				user.updateWalletMoney(order);
				int orderId=orderDao.getByOrderId();
				orderItems.setProduct(currentProduct);
				orderItems.setUser(currentUser);
				orderItems.setOrderId(orderId);
				orderItems.setQuantity(cartQuantity);
				orderItems.setUnitPrice(unitPrice);
				orderItems.setTotalPrice(totalPrice);
				int result=	orderItemsDaoImpl.insertOrders(orderItems);
				if(result>0)
				{
					PrintWriter out = res.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Order Placed Successfully');");
					out.println("location='showCartServlet'");
					out.println("</script>");
				}
				try {
					removeStatus=cartdao.removecartItems(cart);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					throw new InsuffientMoneyException();
				}catch(InsuffientMoneyException iF)
				{
					session.setAttribute("notEnoughAmt",iF.getMessage());
					res.sendRedirect("UserProfile.jsp");
				}
			}
		}else {
			try {
				throw new CartNotEnoughQtyException();
				}catch(CartNotEnoughQtyException e)
				{
					session.setAttribute("lessStock",e.getMessage());
					res.sendRedirect("showCartServlet");
				}

		} 
		
		}else {
			try {
			throw new OutOfStockException();
			}catch(OutOfStockException e)
			{
				session.setAttribute("outOfStock",e.getMessage());
				res.sendRedirect("showCartServlet");
			}

		}
		}else {
			try {
				throw new AddressNotFoundException();
				}
				catch(AddressNotFoundException ad)
				{
					session.setAttribute("AddressNotFoundFromCart", ad.getMessage());
					res.sendRedirect("UserProfile.jsp");
				}
			
		}
		
		
	}
}
