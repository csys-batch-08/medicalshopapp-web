package com.medHub.model;

import java.util.Objects;

public class Cart{
	private Product product;
	private User user;
	private double unitPrice;
	private double totalPrice;
	private int qty;
	
	
	
	@Override
	public String toString() {
		return  product + "unitPrice " + unitPrice + "totalPrice "
				+ totalPrice + "qty= " + qty;
	}
//	 "user= " + user +

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Cart(Product product, User user, int qty,double unitPrice,double totalPrice) {
		super();
		this.product = product;
		this.user = user;
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.totalPrice=totalPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	


	

}
