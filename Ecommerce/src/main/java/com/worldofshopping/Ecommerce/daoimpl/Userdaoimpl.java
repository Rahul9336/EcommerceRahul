package com.worldofshopping.Ecommerce.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldofshopping.Ecommerce.dao.Userdao;
import com.worldofshopping.Ecommerce.dto.User;
@Repository("userDao")
@Transactional
public class Userdaoimpl implements Userdao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@Override
	public User getUserByUsername(String email) {
		String command="from User where email=:parameter";
		Query<User> query=sessionFactory.getCurrentSession().createQuery(command,User.class);
		query.setParameter("parameter", email);
		try {
			return query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(User user) {
		try {
//		Cart cart=new Cart();
//		cart.setUser(user);
//		user.setCart(cart);
		sessionFactory.getCurrentSession().persist(user);
		return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println("Something error occured during Update "+msg);
			return false;
		}
	}

	@Override
	public boolean delete(String email) {
		User user= getUserByUsername(email);
		user.setEnabled(false);
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println("Something error occured during delete");
			return false;
		}
	}

	@Override
	public User getUserById(Long user_id) {
		
		try {
			return sessionFactory.getCurrentSession().get(User.class, Long.valueOf(user_id));
			
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println("Something error occured during Update");
			return null;
		}
	}
	@Override
	public boolean getuserByemailAndPasswordadmin(String email,String password) {
		String command = "from User u where u.email=:email and u.password=:password and u.role=:role";
		Query<User> query=sessionFactory.getCurrentSession().createQuery(command,User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		query.setParameter("role", "ROLE_ADMIN");
		List<User> list = query.list();
		try {
			if (list.size() > 0) {
				return true;
			}
			else throw new NullPointerException();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> userslist() {
		Query<User> query=sessionFactory.getCurrentSession().createQuery("FROM User");
		return query.getResultList();
	}
	@Override
	public boolean getuserByemailAndPassword(String email,String password) {
		String command = "from User u where u.email=:email and u.password=:password and u.role=:role";
		Query<User> query=sessionFactory.getCurrentSession().createQuery(command,User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		query.setParameter("role", "ROLE_CUSTOMER");
		List<User> list = query.list();
		try {
			if (list.size() > 0) {
				return true;
			}
			else throw new NullPointerException();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
