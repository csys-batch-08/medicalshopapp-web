package com.medhub.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Order implements Serializable{
	
	private User user;
	private int orderId;
	private Product product = new Product();
	private LocalDate orderDate;
	private double price;
	private String orderStatus;
	private String orderType;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderDate, orderStatus, orderType, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderDate, other.orderDate) 
				&& Objects.equals(orderStatus, other.orderStatus) && Objects.equals(orderType, other.orderType)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	@Override
	public String toString() {
		return  ", orderDate=" + orderDate + ", price=" + price
				+ ", orderStatus=" + orderStatus + ", orderType=" + orderType + "]";
	}
	public Order(LocalDate orderDate, double price, String orderStatus, String orderType) {
		super();
		this.orderDate = orderDate;
		this.price = price;
		this.orderStatus = orderStatus;
		this.orderType = orderType;
	}
	
	public Order(Product buyProducts, User currentUser,double totalPrice) {
			this.product=buyProducts;
			this.user=currentUser;
			this.price=totalPrice;
		}
	public Order( User currentUser,double totalPrice) {
		this.user=currentUser;
		this.price=totalPrice;
	}
	public Order(LocalDate orderDate, double price, String orderStatus) {
		super();
		this.orderDate = orderDate;
		this.price = price;
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
	}

	
	
	
	
	
}
