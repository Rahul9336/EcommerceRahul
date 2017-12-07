package com.worldofshopping.frontend1;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.worldofshopping.Ecommerce.dao.Branddao;
import com.worldofshopping.Ecommerce.dao.CartItemdao;
import com.worldofshopping.Ecommerce.dao.Cartdao;
import com.worldofshopping.Ecommerce.dao.Categorydao;
import com.worldofshopping.Ecommerce.dao.Productdao;
import com.worldofshopping.Ecommerce.dao.Userdao;
import com.worldofshopping.Ecommerce.dto.Brand;
import com.worldofshopping.Ecommerce.dto.Cart;
import com.worldofshopping.Ecommerce.dto.CartItem;
import com.worldofshopping.Ecommerce.dto.Category;
import com.worldofshopping.Ecommerce.dto.Product;
import com.worldofshopping.Ecommerce.dto.User;

@Controller
public class CheckoutController {
	@Autowired
	Userdao userDao;
	@Autowired
	Categorydao categoryDao;
	Category category;
	@Autowired
	Productdao productDao;
	Brand brand;
	@Autowired
	Branddao brandDao;
	User user;
	Cart cart;
	Product product;
	CartItem cartItem;
	@Autowired
	Cartdao cartDao;
	@Autowired
	CartItemdao cartItemDao;
	Long ip;
	int count;
	double price;
	
	@RequestMapping(value="/user/checkout")
	public ModelAndView checkout(Principal principal,HttpServletRequest request,Map<String,Object>detail) {
		ModelAndView model=new ModelAndView("user/orderdetail");
		user=userDao.getUserByUsername(principal.getName());
		String address=request.getRemoteAddr();
		ip=extractint(address);
		Cart cartid=cartDao.getCartBycart_Id(ip);
		cartid.setUser(user);
		cartDao.updateCart(cartid);
		List<CartItem> cartItems=cartItemDao.cartItemGetByCart(cartid);
		detail.put("address", user.getAddress());
		detail.put("cartitems", cartItems);
		detail.put("category", categoryDao.categorylist());
		detail.put("brand", brandDao.brandlist());
		detail.put("cart", cartid);
		return model;
}
	public static long extractint(String str) {
	    String x = str;
	    String numStr = "";

	    for (int i = 0; i < x.length(); i++) {
	        char charCheck = x.charAt(i);
	        if(Character.isDigit(charCheck)) {
	            numStr += charCheck;
	        }
	    }

	    Long num = Long.parseLong(numStr);
	    return num;
}
}
