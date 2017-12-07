package com.worldofshopping.Ecommerce;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

public class TestCase1 {
	private static AnnotationConfigApplicationContext context;

	static Userdao userDao;
	static Productdao productDao;
	static CartItemdao cartItemDao;
	static Cartdao cartDao;
	static Categorydao categoryDao;
	static Branddao brandDao;
	static User user;
	static Cart cart;
	static CartItem cartItem;
	static Product product, pro;
	static Category category;
	static Brand brand;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.worldofshopping.Ecommerce");
		context.refresh();

		userDao = (Userdao) context.getBean("userDao");
		productDao = (Productdao) context.getBean("productDao");
		cartItemDao = (CartItemdao) context.getBean("cartItemDao");
		cartDao = (Cartdao) context.getBean("cartDao");
		categoryDao = (Categorydao) context.getBean("categoryDao");
		brandDao = (Branddao) context.getBean("brandDao");
	}

	// testing user and cart
	//@Test
	public void test1() {
		user = new User();
		user.setAddress("New Delhi");
		user.setContact("9988776655");
		user.setEmail("komal@gmail.com");
		user.setEnabled(true);
		user.setName("Komal");
		user.setPassword("komal");
		user.setRole("CUSTOMER");
		assertEquals("Success to add a category inside the table", true, userDao.add(user));
	}

	// @Test
	public void test2() {
		user = userDao.getUserByUsername("komal@gmail.com");
		assertEquals("Success to add a category inside the table", "Rahul", user.getName());
	}

	// testing Category and product
	//@Test
	public void test3() {
		category = new Category();
		category.setCategory_name("Electronoics");
		categoryDao.add(category);
		product = new Product();
		product.setActiveIs(true);
		product.setBrand("Sony");
		product.setDescription("NEW IN GOOD CONDITION");
		product.setKeywords("NEW,HD");
		product.setName("Laptop");
		product.setPrice(1000);
		product.setQuantity(3);
		product.setSupplier("LG");
		product.setCategory_name(category.getCategory_name());
		pro = new Product();
		Category n=new Category();
		n.setCategory_name("Pizza");
		categoryDao.add(n);
		pro.setActiveIs(true);
		pro.setBrand("HP");
		pro.setDescription("NEW IN GOOD CONDITION");
		pro.setKeywords("NEW,HD");
		pro.setName("TV");
		pro.setPrice(1000);
		pro.setQuantity(3);
		pro.setSupplier("LG");
		pro.setCategory_name(category.getCategory_name());
		productDao.add(pro);
		assertEquals("Success to add a category inside the table", true, productDao.add(product));
	}

	//@Test
	public void test4() {
		user = userDao.getUserById(new Long(1));
		cart = cartDao.getCartBycart_Id(new Long(2));
		product = productDao.getProductId(new Long(3));
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setSell_quantity(cartItem.getSell_quantity() + 1);
		cartItem.setTotal_price(cartItem.getSell_quantity() * product.getPrice());
		cartItem.setCart(cart);
		cart.setCartItemCount(cartItem.getSell_quantity()+ 1);
		cart.setGrandTotal(cartItem.getSell_quantity() * product.getPrice());
		cartItemDao.addCartItem(cartItem);
	}
	//@Test
	public void test5() {
		user = userDao.getUserById(new Long(1));
		cart = cartDao.getCartBycart_Id(new Long(2));
		cart.setCartItemCount(cart.getCartItemCount()+1);
		cartDao.updateCart(cart);
	}
	//@Test
	public void test6() {
		user = userDao.getUserById(new Long(1));
		cart = cartDao.getCartBycart_Id(new Long(2));
		product = productDao.getProductId(new Long(3));
		cartItem=cartItemDao.getCartItemByUserIdAndProductId(cart, product);
		cart.setCartItemCount(cartItem.getSell_quantity());
		cart.setGrandTotal(cart.getCartItemCount()*product.getPrice());
		cartDao.updateCart(cart);
	}
	//test admin option
	//@Test
	public void test7() {
		assertEquals("Email And Password Succesfully Matched", true, userDao.getuserByemailAndPassword("komal@gmail.com", "komal"));
		System.out.println(userDao.getuserByemailAndPassword("komal@gmail.com", "komal"));
	}
	//@Test
	
	public void test8() {
		List<Category>category=categoryDao.categorylist();
		for (Category category2 : category) {
			System.out.println(category2.getCategory_name());
		}
	}
	//@Test
	public void test9() {
	List<Product>	product=productDao.productList();
	for(Product p:product) {
		System.out.println(p.getName());
	}
	}
	//@Test
	public void test10() {
		Category cat=new Category();
		List<Category>list=categoryDao.categorylist();
		for (Category category2 : list) {
			cat=categoryDao.getcategoryById(category2.getCategory_id());
			System.out.println(cat.getCategory_name());
		}
	}
	//@Test
	public void test11() {
		brand=new Brand();
		brand.setBrand_name("HP");
		brand.setBrand_description("Leading Company");
		assertEquals("Succesfully Add", true,brandDao.add(brand));
		}
	//@Test
	public void test12() {
		List<Product> list=productDao.productList();
		for(Product pro:list) {
			System.out.println(pro.isActiveIs());
		}
	}
	//@Test
	public void test13() {
		product=productDao.getProductId((long) 211);
		productDao.delete(product);
	}
	//@Test
	public void test14() {
		category=categoryDao.getcategoryById((long) 86);
		
		categoryDao.delete(category);
		
	}
	//@Test
	public void test15() {
		user=new User();
		user.setAddress("New Delhi");
		user.setContact("9560796526");
		user.setEmail("rahul@gmail.com");
		user.setName("Rahul Gupta");
		user.setPassword("9336");
		user.setRole("CUSTOMER");
		userDao.add(user);
	}
	//@Test
	public void test16() {
	user=userDao.getUserById(new Long(408));
		Cart cart=new Cart();
		cart=cartDao.getCartBycart_Id(new Long(550));
		cart.setUser(user);
		cartDao.add(cart);
	}
	//@Test
	public void test17() {
	List<Product> list=productDao.homepageproduct();
	for(Product pro:list) {
		System.out.println(pro.getName());
	}
	}
	//@Test
	public void test18() {
		List<Product> cart= new ArrayList<>();
		Cart cartid=cartDao.getCartBycart_Id(new Long(1));
		List<CartItem> cartItems=cartItemDao.cartItemGetByCart(cartid);
		for(CartItem cartitems:cartItems) {
			product=cartitems.getProduct();
			cart.add(product);
		}
		for(Product pro:cart) {
			System.out.println(pro.getName());
		}
	}
	@Test
	public void test19() {
		cartItemDao.deleteCartItem((long) 811);
	}
	}
	
