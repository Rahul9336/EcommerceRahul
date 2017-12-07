package com.worldofshopping.Ecommerce.dao;

import java.util.List;

import com.worldofshopping.Ecommerce.dto.Category;

public interface Categorydao {
	public Category getcategoryById(Long category_id);

	public List <Category> categorylist();

	boolean add(Category catgory);

	boolean update(Category catgory);

	boolean delete(Category category);
}
