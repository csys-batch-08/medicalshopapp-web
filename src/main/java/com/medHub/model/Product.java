package com.medhub.model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable
{
	
	private Order order;
	private User user;
	private int productId;
	private String productCategory;
	private String productName;
	private String description;
	private double unitPrice;
	private int quantity;
	private String productImg;
	private int points;
	private String status;
	private int offer;
	private int totalPrice;
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPoints() {
		return points;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public Product(int productId, String productCategory, String productName, String description, double unitPrice,
			int quantity, String productImg,int points) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productImg = productImg;
		this.points=points;
	}
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getProductImg() {
		return productImg;
	}
	
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	
	public String getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public Product(String productCategory, String productName,String description, double unitPrice, int quantity,
			String productImg) {
		super();
		
		this.productCategory = productCategory;
		this.productName = productName;
		this.description=description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productImg = productImg;
	}
	
	public Product(String productname, String productcategory, String description, double unitPrice,
			int quantity,int productId) {
		super();
		this.productName = productname;
		this.description=description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productCategory=productcategory;
		this.productId=productId;
	}

	public Product(int productId, String productCategory, String productName, String description, double unitPrice, int availableQuantity,
			String productImg,int points,String status,int offer) {
		super();
		this.productId=productId;
		this.productCategory=productCategory;
		this.productName=productName;
		this.description=description;
		this.unitPrice=unitPrice;
		this.quantity=availableQuantity;
		this.productImg=productImg;
		this.points=points;
		this.status=status;
		this.offer=offer;
	}
	
	public Product(String category,String productname,double price,int quantity,String imageurl,int points,int offer,String description,int productId)
	{
		super();
		this.productCategory=category;
		this.productName=productname;
		this.unitPrice=price;
		this.quantity=quantity;
		this.productImg=imageurl;
		this.points=points;
		this.offer=offer;
		this.description=description;
		this.productId=productId;
		}
	
	public Product(String category,String productname,double price,int quantity,String imageurl,int points,int offer)
	{
		super();
		this.productCategory=category;
		this.productName=productname;
		this.unitPrice=price;
		this.quantity=quantity;
		this.productImg=imageurl;
		this.points=points;
		this.offer=offer;
		}
	

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product id="+ productId+"\nproductCategory="
				+ productCategory + "\nproductName=" + productName + "\nunitPrice=" + unitPrice + "\nquantity="
				+ quantity +"\n";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(productCategory, productImg, productName, quantity, unitPrice);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productCategory, other.productCategory) && Objects.equals(productImg, other.productImg)
				 && Objects.equals(productName, other.productName)
				&& quantity == other.quantity && unitPrice == other.unitPrice;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}