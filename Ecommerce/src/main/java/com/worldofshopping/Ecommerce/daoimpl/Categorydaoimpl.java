package com.worldofshopping.Ecommerce.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldofshopping.Ecommerce.dao.Categorydao;
import com.worldofshopping.Ecommerce.dto.Category;
@Repository("categoryDao")
@Transactional
public class Categorydaoimpl implements Categorydao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;
	static Categorydao categoryDao;
	@Override
	public Category getcategoryById(Long category_id) {
		return sessionFactory.getCurrentSession().get(Category.class, Long.valueOf(category_id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> categorylist() {
		Query<Category> query=sessionFactory.getCurrentSession().createQuery("FROM Category");
		return query.getResultList();
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println(msg);
			return false;
		}
	}

}
