 package com.worldofshopping.Ecommerce.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long product_id;
	@Size(min = 1, message = "Must be greater than 3")
	private String brand;
	@NotBlank(message = "Can not leave this field witout entering value name")
	private String name;
	@Size(max=255,message="Description must be in 255 words")
	@NotBlank(message = "Not Null desp")
	private String description;
	@NotBlank(message = "Not Null supplier")
	private String supplier;
	private double price;
	private String productImg_url;
	private int quantity;
	private String keywords;
	@Transient
	@JsonIgnore
	MultipartFile file;
	private boolean activeIs = true;
	private String category_name;
	private CartItem cartItem;
	@OneToMany(mappedBy = "product",fetch=FetchType.LAZY)
	public CartItem getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public boolean isActiveIs() {
		return activeIs;
	}
	public void setActiveIs(boolean activeIs) {
		this.activeIs = activeIs;
	}

	public String getProductImg_url() {
		return productImg_url;
	}
	public void setProductImg_url(String productImg_url) {
		this.productImg_url = productImg_url;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", brand=" + brand + ", name=" + name + ", description="
				+ description + ", supplier=" + supplier + ", price=" + price + ", productImg_url=" + productImg_url
				+ ", quantity=" + quantity + ", keywords=" + keywords + ", file=" + file + ", activeIs=" + activeIs
				+ ", category_name=" + category_name + ", cartItem=" + cartItem + "]";
	}


}
