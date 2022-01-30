package com.medhub.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class OrderItems extends Order implements Serializable{

	private int itemId;
	private User user;
	private Product product = new Product();
	private Order orderModel = new Order();
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	private String description;
	private int offer;
	private LocalDate orderdate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public int getItemId() {
		return itemId;
	}

	public OrderItems() {
		super();
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public OrderItems(User user, Order orderModel, Product product, int quantity, double unitPrice, double totalPrice) {
		super();
		this.user = user;
		this.product = product;
		this.orderModel = orderModel;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}

	public OrderItems(String productName, int points, int quantity, double unitPrice, double totalPrice, int orderId,
			String productImg, String description, int offer, int productId,LocalDate orderDate,String orderStatus) {
		this.product.setProductName(productName);
		this.product.setPoints(points);
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderModel.setOrderId(orderId);
		this.product.setProductImg(productImg);
		this.product.setDescription(description);
		this.product.setOffer(offer);
		this.product.setProductId(productId);
		this.orderdate=orderDate;
		this.orderModel.setOrderStatus(orderStatus);
	}

	public OrderItems(LocalDate orderDate, String productName, int qty, double unitPrice, double totalPrice) {
		this.orderdate=orderDate;
		this.product.setProductName(productName);
		this.quantity=qty;
		this.unitPrice=unitPrice;
		this.totalPrice=totalPrice;
		}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrderModel() {
		return orderModel;
	}

	public void setOrderModel(Order orderModel) {
		this.orderModel = orderModel;
	}

	@Override
	public String toString() {
		return "order id " + getOrderId() + "\nuser " + user + "\nproduct " + product + "\nquantity " + quantity
				+ "\nunitPrice " + unitPrice + "\ntotalPrice " + totalPrice + "\n";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
