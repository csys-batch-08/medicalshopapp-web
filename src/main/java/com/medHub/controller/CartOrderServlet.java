package com.medhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
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

@WebServlet("/cartOrder")

public class CartOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 3052953784774654312L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		UserDaoImpl user = new UserDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		OrderItems orderItems = new OrderItems();
		Cart cart = new Cart();
		CartDaoImpl cartdao = new CartDaoImpl();
		Order order = new Order();
		OrderDaoImpl orderDao = new OrderDaoImpl();
		OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();
		int cartProductId = 0;
		int cartQuantity = 0;
		double unitPrice =0;
		double totalPrice = 0;
		User currentUser = (User) session.getAttribute("user");
		try {
		 cartProductId = Integer.parseInt(req.getParameter("CartproductId"));
		 cartQuantity = Integer.parseInt(req.getParameter("cartQuantity"));
		 unitPrice = Double.parseDouble(req.getParameter("unitPrice"));
		 totalPrice = Double.parseDouble(req.getParameter("totalPrice"));
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}

		Product currentProduct = productDao.findProductByProductId(cartProductId);
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
				try {
					orderDao.orders(order, currentUser);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				user.updateUserPoints(order);
				user.updateWalletMoney(order);
				int orderId = 0;
				try {
					orderId = orderDao.getByOrderId();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				orderItems.setProduct(currentProduct);
				orderItems.setUser(currentUser);
				orderItems.setOrderId(orderId);
				orderItems.setQuantity(cartQuantity);
				orderItems.setUnitPrice(unitPrice);
				orderItems.setTotalPrice(totalPrice);
				int result=	orderItemsDaoImpl.insertOrders(orderItems);
				try {
				if(result>0)
				{
					PrintWriter out = res.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Order Placed Successfully');");
					out.println("location='showCartServlet'");
					out.println("</script>");
				}
				
					cartdao.removecartItems(cart);
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					throw new InsuffientMoneyException();
				}catch(InsuffientMoneyException iF)
				{
					session.setAttribute("notEnoughAmt",iF.getMessage());
					req.setAttribute("currentUser", currentUser);
					RequestDispatcher rd = req.getRequestDispatcher("showUserProfile");
					try {
						rd.forward(req, res);
					} catch (ServletException |IOException e) {
						e.printStackTrace();
					
				}
			}}
		}else {
			try {
				throw new CartNotEnoughQtyException();
				}catch(CartNotEnoughQtyException e)
				{
					session.setAttribute("lessStock",e.getMessage());
					try {
					res.sendRedirect("showCartServlet");
					}catch (IOException io) {
						io.printStackTrace();
					}
				}

		} 
		
		}else {
			try {
			throw new OutOfStockException();
			}catch(OutOfStockException e)
			{
				session.setAttribute("outOfStock",e.getMessage());
				RequestDispatcher rd = req.getRequestDispatcher("ProductOutStock.jsp");
				try {
					rd.forward(req, res);
				} catch (ServletException se) {
					se.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		}
		}else {
			try {
				throw new AddressNotFoundException();
				}
				catch(AddressNotFoundException ad)
				{
					session.setAttribute("AddressNotFoundFromCart", ad.getMessage());
					try {
					res.sendRedirect("userProfile.jsp");
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
			
		}
		
		
	}
}
