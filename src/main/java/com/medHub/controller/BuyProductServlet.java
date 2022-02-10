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

	private static final long serialVersionUID = -8995920063945379654L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		UserDaoImpl user = new UserDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		OrderItems orderItems = new OrderItems();
		User currentUser = (User) session.getAttribute("user");
		Product currentProduct = (Product) session.getAttribute("currentproduct");
		double price = 0;
		int qty = 0;
		try {
			qty = Integer.parseInt(req.getParameter("quantity"));
			price = Double.parseDouble(req.getParameter("totalPrice"));
		} catch (NumberFormatException n) {
			n.printStackTrace();
		}
		Order order = new Order();
		OrderDaoImpl orderDao = new OrderDaoImpl();
		OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();

		if (currentUser.getWallet() >= price) {
			if (currentUser.getAddress() != null && !currentUser.getAddress().equals("null")) {

				order.getProduct().setQuantity((order.getProduct().getQuantity() - qty));
				try {
					int updateQty = currentProduct.getQuantity() - qty;
					productDao.updateProductQuantity(currentProduct, updateQty);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				order.setUser(currentUser);
				orderItems.setUser(currentUser);
				order.setPrice(price);
				order.getUser().setPoints(order.getUser().getPoints() + (currentProduct.getPoints() * qty));
				order.getUser().setWallet(Math.round(order.getUser().getWallet() - price));
				user.updateUserPoints(order);
				user.updateWalletMoney(order);
				try {
					orderDao.orders(order, currentUser);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int orderId = 0;
				try {
					orderId = orderDao.getByOrderId();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				order.setOrderId(orderId);
				orderItems.setOrderModel(order);
				orderItems.setProduct(currentProduct);
				orderItems.setOrderId(orderId);
				orderItems.getProduct().setProductId(currentProduct.getProductId());
				orderItems.setQuantity(qty);
				orderItems.setUnitPrice(currentProduct.getUnitPrice());
				orderItems.setTotalPrice(price);
				orderItemsDaoImpl.insertOrders(orderItems);

				OrderItemsDaoImpl myOrder = new OrderItemsDaoImpl();
				List<OrderItems> myOrderList = myOrder.ViewMyOrders(currentUser);
				req.setAttribute("myOrders", myOrderList);
				RequestDispatcher rd = req.getRequestDispatcher("myOrders.jsp?orderStatus=success");
				try {
					rd.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}

			} else {
				try {
					throw new AddressNotFoundException();
				} catch (AddressNotFoundException e) {
					session.setAttribute("currentProduct", currentProduct);
					req.setAttribute("AddressNotFound", e.getMessage());
					RequestDispatcher rd = req.getRequestDispatcher("buyProduct.jsp");
					try {
						rd.forward(req, res);
					} catch (ServletException | IOException si) {
						si.printStackTrace();
					}
				}
			}
		} else {
			try {
				throw new InsuffientMoneyException();
			} catch (InsuffientMoneyException iM) {
				session.setAttribute("currentProduct", currentProduct);
				req.setAttribute("InsuffientMoney", iM.getMessage());
				RequestDispatcher rd = req.getRequestDispatcher("buyProduct.jsp");
				try {
					rd.forward(req, res);
				} catch (ServletException | IOException si) {
					si.printStackTrace();
				}
			}

		}

	}

}
