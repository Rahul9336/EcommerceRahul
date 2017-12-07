package com.worldofshopping.Ecommerce.dao;

import java.util.List;

import com.worldofshopping.Ecommerce.dto.Cart;
import com.worldofshopping.Ecommerce.dto.CartItem;
import com.worldofshopping.Ecommerce.dto.Product;



public interface CartItemdao  {
	public boolean addCartItem(CartItem cartItem);

	public List<CartItem> cartItemGetByCart(Cart cart);

	public boolean updateCartItem(CartItem cartItem);

	public boolean deleteCartItem(Long cart_id);

	public CartItem getCartItemByCartItem_Id(Long cartItem_Id);

	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product);

	public CartItem CartItemByCartIdAndProductId(Cart cart, Product product);
}
