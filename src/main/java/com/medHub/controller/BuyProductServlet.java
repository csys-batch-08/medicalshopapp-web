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
import com.exceptions.InsuffientMoneyException;
import com.medHub.dao.OrderDaoImpl;
import com.medHub.dao.OrderItemsDaoImpl;
import com.medHub.dao.ProductDaoImpl;
import com.medHub.dao.UserDaoImpl;
import com.medHub.model.Order;
import com.medHub.model.OrderItems;
import com.medHub.model.Product;
import com.medHub.model.User;

@WebServlet("/prod1")
public class BuyProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession();
		UserDaoImpl user = new UserDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		Product product = new Product();
		OrderItems orderItems = new OrderItems();
		User currentUser = (User) session.getAttribute("user");
		Product currentproduct = (Product) session.getAttribute("currentproduct");
//		Product product = new Product(currentproduct.getProductId(),currentproduct.getProductCategory(),currentproduct.getProductName(),
//				currentproduct.getDescription(),currentproduct.getUnitPrice(),currentproduct.getQuantity(),currentproduct.getProductImg(),currentproduct.getPoints(),currentproduct.getStatus(),currentproduct.getOffer());

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
						System.out.println("add null found");
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
						//res.getWriter().println("order placed!!");
								//alert box when ordered placed sucessfully
						PrintWriter out = res.getWriter();
						
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Ordered Placed Sucessfully');");
						out.println("location= 'MyOrders.jsp?orderId=0&totalPrice=0&quantity=0&points=0&productId=0';");
						out.println("</script>");
						
					}else {
						try {
						throw new AddressNotFoundException();
						}
						catch(AddressNotFoundException e)
						{
							session.setAttribute("AddressNotFound", e.getMessage());
							res.sendRedirect("UserProfile.jsp");
						}
					}
			} else 
				{
						try {
							throw new InsuffientMoneyException();
							}
						catch(InsuffientMoneyException IM) 
							{
								session.setAttribute("InsuffientMoney", IM.getMessage());
								res.sendRedirect("UserProfile.jsp");
							}
				
				
				}
		


	}

}
