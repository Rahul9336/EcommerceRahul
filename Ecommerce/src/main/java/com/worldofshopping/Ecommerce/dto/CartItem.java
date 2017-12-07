package com.worldofshopping.Ecommerce.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartItem_Id;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="cart_Id")
	private Cart cart;

	private int sell_quantity;

	private double total_price;

	public Long getCartItem_Id() {
		return cartItem_Id;
	}

	public void setCartItem_Id(Long cartItem_Id) {
		this.cartItem_Id = cartItem_Id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getSell_quantity() {
		return sell_quantity;
	}

	public void setSell_quantity(int sell_quantity) {
		this.sell_quantity = sell_quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double d) {
		this.total_price = d;
	}

	@Override
	public String toString() {
		return "CartItem [cartItem_Id=" + cartItem_Id + ", product=" + product + ", cart=" + cart + ", sell_quantity="
				+ sell_quantity + ", total_price=" + total_price + "]";
	}
	
}
