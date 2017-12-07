package com.worldofshopping.Ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldofshopping.Ecommerce.dao.Productdao;
import com.worldofshopping.Ecommerce.dto.Product;
@Repository("productDao")
@Transactional
public class Productdaoimpl implements Productdao {
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@Override
	public Product getProductId(Long product_id) {
		return sessionFactory.getCurrentSession().get(Product.class, Long.valueOf(product_id));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Product> productList() {
		String command="from Product where ActiveIs=:parameter";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("parameter", true);
		return query.getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
		 sessionFactory.getCurrentSession().saveOrUpdate(product);
		 return true;}
		catch(Exception msg) {
			System.out.println(msg);
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			 sessionFactory.getCurrentSession().saveOrUpdate(product);
			 return true;}
			catch(Exception msg) {
				System.out.println(msg);
				return false;
			}
	}

	@Override
	public boolean delete(Product product) {
		
		//Product product =getProductId(product_id);
		try {
//		String update="update Product set ActiveIs=:parameter where product_id=:id";
//		Query query=sessionFactory.getCurrentSession().createQuery(update);
//		query.setParameter("parameter", false);
//		query.setParameter("id", product_id);
//		query.executeUpdate();
			sessionFactory.getCurrentSession().delete(product);
			 return true;}
			catch(Exception msg) {
				System.out.println(msg);
				return false;
			}
	}
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public List<Product> homepageproduct(){
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Product.class);
		cr.setFirstResult(1);
		cr.setMaxResults(9);
		List results = cr.list();
		return results;
	}

}
