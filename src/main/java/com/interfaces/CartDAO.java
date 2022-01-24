package com.interfaces;

import java.util.List;

import com.medHub.model.Cart;
import com.medHub.model.User;

public interface CartDAO {

	public void insertProduct(Cart cart);
	public List<Cart> viewCart(User currentUser);
	public int productexist(Cart cart);
	public int updatequantity(Cart cart);
	public int removecartItems(Cart cart);
}
