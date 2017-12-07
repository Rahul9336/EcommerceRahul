package com.worldofshopping.Ecommerce.dao;

import java.util.List;

import com.worldofshopping.Ecommerce.dto.Product;

public interface Productdao {
	public Product getProductId(Long product_id);

	public List<Product> productList();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);
	
	public List<Product> homepageproduct();
}
