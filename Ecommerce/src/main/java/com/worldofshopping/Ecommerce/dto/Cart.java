package com.worldofshopping.Ecommerce.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long cart_Id;
	private int cartItemCount;

	private double grandTotal;

	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cart")
	private List<CartItem> cartList = new ArrayList<CartItem>();
  
	public Long getCart_Id() {
		return cart_Id;
	}

	public void setCart_Id(Long cart_Id) {
		this.cart_Id = cart_Id;
	}

	public int getCartItemCount() {
		return cartItemCount;
	}

	public void setCartItemCount(int cartItemCount) {
		if(cartItemCount<0) {this.cartItemCount=0;}else
		this.cartItemCount = cartItemCount;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartItem> cartList) {
		this.cartList = cartList;
	}

	@Override
	public String toString() {
		return "Cart [cart_Id=" + cart_Id + ", cartItemCount=" + cartItemCount + ", grandTotal=" + grandTotal
				+ ", user=" + user + ", cartList=" + cartList + "]";
	}
	
}
