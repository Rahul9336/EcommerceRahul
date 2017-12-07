package com.worldofshopping.Ecommerce.dao;

import java.util.List;

import com.worldofshopping.Ecommerce.dto.User;

public interface Userdao {
	public User getUserByUsername(String email);

	public boolean add(User user);

	public boolean update(User user);

	public boolean delete(String email);

	public User getUserById(Long user_id);

	public boolean getuserByemailAndPassword(String email, String password);
	
	public List <User> userslist();
	
	public boolean getuserByemailAndPasswordadmin(String email, String password);
}
