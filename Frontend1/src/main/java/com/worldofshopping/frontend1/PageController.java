package com.worldofshopping.frontend1;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class PageController {
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
	//Display Login Page for Admin
	@RequestMapping(value="/admin/loginsuccess")
	public String loginpage(Map<String,String>message,@RequestParam("username") String email,@RequestParam("password") String password) {
		if(userDao.getuserByemailAndPasswordadmin(email, password)) {return "admin/product";}else {
			message.put("message", "! Invalid Email And Password ");
			return "admin/adminlogin";
		}
	}
	//Add Category page
	@RequestMapping(value="/admin/category",method= RequestMethod.GET)
	public String categorypage() {
		return "admin/category";
	}
	//add product page
	@RequestMapping(value="/admin/product",method=RequestMethod.GET)
	public ModelAndView productpage(Map<String,Object> list) {
		ModelAndView model = new ModelAndView("admin/product");
		list.put("category", categoryDao.categorylist());
		list.put("brand", brandDao.brandlist());
		list.put("product", productDao.productList());
		return model;
	}
	//add brand page
	@RequestMapping(value="/admin/brand",method=RequestMethod.GET)
	public String brandpage() {
		return "admin/brand";
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView homepage(Map<String, Object> list,HttpServletRequest request) {
		list.put("category", categoryDao.categorylist());
		list.put("brand", brandDao.brandlist());
		list.put("product", productDao.homepageproduct());
		String address=request.getRemoteAddr();
		ip=extractint(address);
		if(cartDao.check(ip)) {
			cart=new Cart();
			cart.setCart_Id(ip);
			cartDao.add(cart);	
		}
		System.out.println(ip);
		Cart cartid=cartDao.getCartBycart_Id(ip);
		List<CartItem> cartItems=cartItemDao.cartItemGetByCart(cartid);
		for(CartItem cartitem:cartItems) {
			count+=cartitem.getSell_quantity();
			price+=cartitem.getTotal_price();
		}
		cartid.setCartItemCount(count);
		cartid.setGrandTotal(price);
		cartDao.add(cartid);
		list.put("cart", count);
		ModelAndView model=new ModelAndView("Home");
		count=0;
		price=0.0;
		System.out.println(request.getRequestURL());
		return model;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView Signup() {
		ModelAndView model = new ModelAndView("SignUp");
		return model;
	}
	
	@RequestMapping(value="/cartdetail")
	public ModelAndView cartdetail(Map<String, Object> list,HttpServletRequest request) {
		ModelAndView model= new ModelAndView("user/cartdetail");
		String address=request.getRemoteAddr();
		ip=extractint(address);
		Cart cartid=cartDao.getCartBycart_Id(ip);
		List<CartItem> cartItems=cartItemDao.cartItemGetByCart(cartid);
		for(CartItem cartitem:cartItems) {
			count+=cartitem.getSell_quantity();
			price+=cartitem.getTotal_price();
		}
		cartid.setCartItemCount(count);
		cartid.setGrandTotal(price);
		cartDao.add(cartid);
		list.put("category", categoryDao.categorylist());
		list.put("brand", brandDao.brandlist());
		list.put("cart", count);
		list.put("grand", price);
		list.put("detail", cartItems);
		count=0;
		price=0.0;
		return model;
	}
	@RequestMapping("/login")
	public String login(Map<String, Object> list){
		list.put("category", categoryDao.categorylist());
		list.put("brand", brandDao.brandlist());
		return "login";
	}
	@RequestMapping("notallow")
	public String denied(Map<String, Object> list){
		return "403";
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
