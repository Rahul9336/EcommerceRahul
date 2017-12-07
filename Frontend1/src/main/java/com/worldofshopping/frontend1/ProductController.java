package com.worldofshopping.frontend1;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.worldofshopping.Ecommerce.dao.Branddao;
import com.worldofshopping.Ecommerce.dao.CartItemdao;
import com.worldofshopping.Ecommerce.dao.Cartdao;
import com.worldofshopping.Ecommerce.dao.Categorydao;
import com.worldofshopping.Ecommerce.dao.Productdao;
import com.worldofshopping.Ecommerce.dao.Suggestiondao;
import com.worldofshopping.Ecommerce.dto.Brand;
import com.worldofshopping.Ecommerce.dto.Cart;
import com.worldofshopping.Ecommerce.dto.CartItem;
import com.worldofshopping.Ecommerce.dto.Product;

@Controller
public class ProductController {
	@Autowired
	Productdao productDao;
	Product product;
	@Autowired
	Suggestiondao suggestDao;
	Brand brand;
	@Autowired
	Branddao brandDao;
	@Autowired
	Categorydao categoryDao;
	Long ip;
	@Autowired
	Cartdao cartDao;
	Cart cart;
	@Autowired
	CartItemdao cartItemDao;
	CartItem cartItem;
	double grandprice;
	 int count;
	@RequestMapping(value = "/productdetail/{id}")
	public ModelAndView productdetail(Map<String, Object> map, @PathVariable(value = "id") Long id,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("productdetail");
		product = productDao.getProductId(id);
		map.put("product", productDao.getProductId(id));
		map.put("suggestproduct", productDao.getProductId(id + 2));
		map.put("category", categoryDao.categorylist());
		map.put("brand", brandDao.brandlist());
		String category_name = product.getCategory_name();
		map.put("suggestion", suggestDao.suggest(id, category_name));
		String address=request.getRemoteAddr();
		ip=extractint(address);
		Cart cartid=cartDao.getCartBycart_Id(ip);
		List<CartItem> cartItems=cartItemDao.cartItemGetByCart(cartid);
		for(CartItem cartitem:cartItems) {
			count+=cartitem.getSell_quantity();
		}
		map.put("cart", count);
		count=0;
		return model;
	}

	@RequestMapping(value = "/bybrand/{name}")
	public ModelAndView bybrand(Map<String, String> heading, Map<String, Object> map,
			@PathVariable(value = "name") String name,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/all");
		String address=request.getRemoteAddr();
		ip=extractint(address);
		Cart cartid=cartDao.getCartBycart_Id(ip);
		List<CartItem> cartItems=cartItemDao.cartItemGetByCart(cartid);
		for(CartItem cartitem:cartItems) {
			count+=cartitem.getSell_quantity();
		}
		map.put("cart", count);
		map.put("By", suggestDao.bybrand(name));
		map.put("category", categoryDao.categorylist());
		map.put("brand", brandDao.brandlist());
		heading.put("title", name);
		count=0;
		return model;
	}

	@RequestMapping(value = "/bycategory/{name}")
	public ModelAndView bycategory(Map<String, String> heading, Map<String, Object> map,
			@PathVariable(value = "name") String name,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/all");
		map.put("By", suggestDao.bycategory(name));
		map.put("category", categoryDao.categorylist());
		map.put("brand", brandDao.brandlist());
		String address=request.getRemoteAddr();
		ip=extractint(address);
		Cart cartid=cartDao.getCartBycart_Id(ip);
		List<CartItem> cartItems=cartItemDao.cartItemGetByCart(cartid);
		for(CartItem cartitem:cartItems) {
			count+=cartitem.getSell_quantity();
		}
		map.put("cart", count);
		heading.put("title", name);
		count=0;
		return model;
	}
	@RequestMapping(value="/addcart/{id}")
	public ModelAndView addcart(@PathVariable(value = "id") Long id,HttpServletRequest request,Map<String, Object> list) {
		ModelAndView model=new ModelAndView("redirect:/");
		String address=request.getRemoteAddr();
		product=productDao.getProductId(id);
		ip=extractint(address);
		if(cartDao.check(ip)) {
			cart=new Cart();
			cart.setCart_Id(ip);
			cartDao.add(cart);	
		}
		Cart cartid=cartDao.getCartBycart_Id(ip);
		List<CartItem> cartItems=cartItemDao.cartItemGetByCart(cartid);
		for(CartItem cartitem:cartItems) {
			if(cartitem.getProduct().getProduct_id()==id) {
				ModelAndView model1=new ModelAndView("redirect:/");
				System.out.println(cartitem.getSell_quantity());
				cartitem.setSell_quantity(cartitem.getSell_quantity()+1);
				System.out.println(cartitem.getSell_quantity());
				cartitem.setTotal_price(cartitem.getSell_quantity()*product.getPrice());
				cartItemDao.updateCartItem(cartitem);
				System.out.println(cartitem.getSell_quantity());
				System.out.println(cartid.getCartItemCount()+cartitem.getSell_quantity());
				/*list.put("cart", cartDao.getCartBycart_Id(ip));*/
				list.put("category", categoryDao.categorylist());
				list.put("brand", brandDao.brandlist());
				list.put("product", productDao.homepageproduct());
				return model1;
			}
		}
		cart=cartDao.getCartBycart_Id(ip);
		CartItem cartitem=new CartItem();
		cartitem.setSell_quantity(+1);
		cartitem.setTotal_price(product.getPrice()*cartitem.getSell_quantity());
		cartitem.setProduct(product);
		cartitem.setCart(cart);
		cartItemDao.addCartItem(cartitem);
//		list.put("cart", cartDao.getCartBycart_Id(ip));
		list.put("category", categoryDao.categorylist());
		list.put("brand", brandDao.brandlist());
		list.put("product", productDao.homepageproduct());
		return model;
	}
	@RequestMapping(value="/cartitems/remove/{id}")
	public ModelAndView cartitemRemove(@PathVariable(value = "id") Long id) {
		ModelAndView model=new ModelAndView("redirect:/cartdetail");
		cartItemDao.deleteCartItem(id);
		return model;
	}
	@RequestMapping(value="/cartitems/update/{id}")
	public ModelAndView cartitemUpdate(@PathVariable(value = "id") Long id,@RequestParam(value = "qty") int qty) {
		ModelAndView model=new ModelAndView("redirect:/cartdetail");
		cartItem=cartItemDao.getCartItemByCartItem_Id(id);
		System.out.println(qty);
		cartItem.setSell_quantity(qty);
		cartItemDao.updateCartItem(cartItem);
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
