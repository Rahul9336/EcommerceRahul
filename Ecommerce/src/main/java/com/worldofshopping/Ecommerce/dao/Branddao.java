package com.worldofshopping.Ecommerce.dao;

import java.util.List;

import com.worldofshopping.Ecommerce.dto.Brand;
public interface Branddao {
	public Brand getbrand(Long brand_id);

	public List <Brand> brandlist();

	boolean add(Brand brand);

	boolean update(Brand brand);

	boolean delete(Brand brand);
}
