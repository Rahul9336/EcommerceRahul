package com.worldofshopping.Ecommerce.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldofshopping.Ecommerce.dao.Cartdao;
import com.worldofshopping.Ecommerce.dto.Cart;
@Repository("cartDao")
@Transactional
public class Cartdaoimpl implements Cartdao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public boolean updateCart(Cart cart) {
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
			
		} catch (Exception msg) {
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public Cart getCartBycart_Id(Long cart_Id) {
		String command = "FROM Cart where cart_Id=:parameter";
		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(command, Cart.class);
		query.setParameter("parameter", cart_Id);
		try {
			return query.getSingleResult();
		} catch (Exception msg) {
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean deleteAllCartItems(Cart cart) {
		
		try {
			String command = "DELETE FROM CartItem WHERE cart=:parameter";
			Query query = sessionFactory.getCurrentSession().createQuery(command);
			query.setParameter("parameter", cart);
			query.executeUpdate();
			return true;
		} catch (Exception msg) {
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public boolean add(Cart cart) {
		try {
			 sessionFactory.getCurrentSession().saveOrUpdate(cart);
			 return true;}
			catch(Exception msg) {
				System.out.println(msg);
				return false;
			}
	}
	@Override
	public boolean check(Long id) {
		
		String command = "FROM Cart where cart_Id=:parameter";
		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(command, Cart.class);
		query.setParameter("parameter", id);
		List<Cart>result=query.getResultList();
		try {
			if(result.size()!=0) {return false;}else {return true;}
		} catch (Exception msg) {
			return false;
		}

}
	}
