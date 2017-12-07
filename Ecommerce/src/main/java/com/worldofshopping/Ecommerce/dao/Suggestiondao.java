package com.worldofshopping.Ecommerce.dao;

import java.util.List;

import com.worldofshopping.Ecommerce.dto.Product;

public interface Suggestiondao {
	public List<Product> suggest(Long id,String category);
	public List<Product> bybrand(String brand);
	public List<Product> bycategory(String category);
}
