package com.medhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.exceptions.AddressNotFoundException;
import com.exceptions.InsuffientMoneyException;
import com.medhub.dao.OrderDaoImpl;
import com.medhub.dao.OrderItemsDaoImpl;
import com.medhub.dao.ProductDaoImpl;
import com.medhub.dao.UserDaoImpl;
import com.medhub.model.Order;
import com.medhub.model.OrderItems;
import com.medhub.model.Product;
import com.medhub.model.User;

@WebServlet("/prod1")
public class BuyProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession();
		UserDaoImpl user = new UserDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		OrderItems orderItems = new OrderItems();
		User currentUser = (User) session.getAttribute("user");
		Product currentproduct = (Product) session.getAttribute("currentproduct");
		int qty = Integer.parseInt(req.getParameter("quantity"));
		double price = Double.parseDouble(req.getParameter("totalPrice"));
		int offer = 0;
		Order order = new Order();
		OrderDaoImpl orderDao = new OrderDaoImpl();
		OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();
		

		if (currentUser.getWallet() >= price) 
			{
					if(currentUser.getAddress()!=null && !currentUser.getAddress().equals("null")) 
					{
						
					order.getProduct().setQuantity((order.getProduct().getQuantity() - qty));
					try {
							int updateQty = currentproduct.getQuantity() - qty;
							productDao.updateProductQuantity(currentproduct, updateQty);
						} catch (SQLException e) 
							{
								e.printStackTrace();
							}
						order.setUser(currentUser);
						orderItems.setUser(currentUser);
						order.setPrice(price);
						order.getUser().setPoints(order.getUser().getPoints() + (currentproduct.getPoints() * qty));
						order.getUser().setWallet(order.getUser().getWallet() - price);
						user.updateUserPoints(order);
						user.updateWalletMoney(order);
						boolean result=orderDao.orders(order, currentUser);
						int orderId = orderDao.getByOrderId();
						order.setOrderId(orderId);
						orderItems.setOrderModel(order);
						orderItems.setProduct(currentproduct);
						orderItems.setOrderId(orderId);
						orderItems.getProduct().setProductId(currentproduct.getProductId());
						orderItems.setQuantity(qty);
						orderItems.setUnitPrice(currentproduct.getUnitPrice());
						orderItems.setTotalPrice(price);
						orderItemsDaoImpl.insertOrders(orderItems);
						
						PrintWriter out = res.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Ordered Placed Sucessfully');");
						out.println("location= 'myOrdersServlet'");
						out.println("</script>");
						
					}else {
						try {
						throw new AddressNotFoundException();
						}
						catch(AddressNotFoundException e)
						{
							session.setAttribute("AddressNotFound", e.getMessage());
							res.sendRedirect("userProfile.jsp");
						}
					}
			} else {
						try {
							throw new InsuffientMoneyException();
							}
						catch(InsuffientMoneyException iM) 
							{
								session.setAttribute("InsuffientMoney", iM.getMessage());
								res.sendRedirect("userProfile.jsp");
							}
				
				
				}
		


	}

}
