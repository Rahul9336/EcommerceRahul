package com.worldofshopping.Ecommerce.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldofshopping.Ecommerce.dao.CartItemdao;
import com.worldofshopping.Ecommerce.dao.Cartdao;
import com.worldofshopping.Ecommerce.dto.Cart;
import com.worldofshopping.Ecommerce.dto.CartItem;
import com.worldofshopping.Ecommerce.dto.Product;
@Repository("cartItemDao")
@Transactional
public class CartItemdaoimpl implements CartItemdao{

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@Autowired
	Cartdao cartDao;
	@Override
	public boolean addCartItem(CartItem cartItem) {
		try {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
		return true;}
		catch(Exception msg) {
			System.out.println("Something Error Ocuured During add item to cartitem "+msg);
			return false;
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<CartItem> cartItemGetByCart(Cart cart) {
		String command="FROM CartItem where cart=:cart";
		Query<CartItem> query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("cart", cart);
		try {
			return query.getResultList();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			return true;
			
		} catch (Exception msg) {
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(Long cartItem_Id) {
		
		CartItem cartItem = getCartItemByCartItem_Id(cartItem_Id);
		try {
			//Cart cart=cartDao.getCartBycart_Id(cartItem.getCart().getCart_Id());
			//cart.getCartList().remove(cartItem);
			sessionFactory.getCurrentSession().delete(cartItem);
			//sessionFactory.getCurrentSession().saveOrUpdate(cart);
			//sessionFactory.getCurrentSession().flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	

	@Override
	public CartItem getCartItemByCartItem_Id(Long cartItem_Id) {
		String command="FROM CartItem where cartItem_Id=:parameter";
		Query<CartItem> query=sessionFactory.getCurrentSession().createQuery(command,CartItem.class);
		query.setParameter("parameter", cartItem_Id);
		try {
			return  query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product) {
		String command = "FROM CartItem where cart=:parameter1 and product=:parameter2";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(command, CartItem.class);
		query.setParameter("parameter1", cart);
		query.setParameter("parameter2", product);
		try {
			return query.getSingleResult();
		} catch (Exception msg) {
			return null;
		}
	}

	@Override
	public CartItem CartItemByCartIdAndProductId(Cart cart, Product product) {
	String command = "FROM CartItem where cart=:parameter1 and product=:parameter2";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(command, CartItem.class);
		query.setParameter("parameter1", cart);
		query.setParameter("parameter2", product);
		try {
			return query.getSingleResult();
		} catch (Exception msg) {
			return null;
		}
	}

}
