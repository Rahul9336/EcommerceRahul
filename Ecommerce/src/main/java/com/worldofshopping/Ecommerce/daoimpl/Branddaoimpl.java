package com.worldofshopping.Ecommerce.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldofshopping.Ecommerce.dao.Branddao;
import com.worldofshopping.Ecommerce.dto.Brand;
@Repository("brandDao")
@Transactional
public class Branddaoimpl implements Branddao {
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@Override
	public Brand getbrand(Long brand_id) {
		return sessionFactory.getCurrentSession().get(Brand.class, Long.valueOf(brand_id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> brandlist() {
		Query<Brand> query=sessionFactory.getCurrentSession().createQuery("FROM Brand");
		return query.getResultList();
	}

	@Override
	public boolean add(Brand brand) {
		try {
			sessionFactory.getCurrentSession().persist(brand);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public boolean update(Brand brand) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(brand);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public boolean delete(Brand brand) {
		try {
			sessionFactory.getCurrentSession().delete(brand);
			return true;
		}catch(Exception msg) {
			msg.printStackTrace();
			System.out.println(msg);
			return false;
		}
	}

}
