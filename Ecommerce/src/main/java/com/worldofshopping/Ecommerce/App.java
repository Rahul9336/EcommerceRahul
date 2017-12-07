package com.worldofshopping.Ecommerce;

import com.worldofshopping.Ecommerce.dao.Userdao;
import com.worldofshopping.Ecommerce.daoimpl.Userdaoimpl;
import com.worldofshopping.Ecommerce.dto.User;

public class App 
{
    public static void main( String[] args )
    {
    User user = new User();
		user.setAddress("New Delhi");
		user.setContact("9988776655");
		user.setEmail("komal@gmail.com");
		user.setEnabled(true);
		user.setName("Komal");
		user.setPassword("komal");
		user.setRole("CUSTOMER");
		Userdao userDao=new Userdaoimpl();
		userDao.add(user);
    }
}
