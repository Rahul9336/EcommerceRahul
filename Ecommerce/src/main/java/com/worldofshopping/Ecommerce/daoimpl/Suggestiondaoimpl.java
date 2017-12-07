package com.worldofshopping.Ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldofshopping.Ecommerce.dao.Suggestiondao;
import com.worldofshopping.Ecommerce.dto.Product;
@Repository("suggestDao")
@Transactional
public class Suggestiondaoimpl implements Suggestiondao {
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public List<Product> suggest(Long id,String category) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Product.class);
		cr.add(Restrictions.ilike("category_name", category));
		cr.add(Restrictions.not(Restrictions.in("product_id", id)));
		cr.setMaxResults(3);
		List results = cr.list();
		return results;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Product> bybrand(String brand) {
		String command="from Product where ActiveIs=:parameter and brand=:brand";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("parameter", true);
		query.setParameter("brand", brand);
		return query.getResultList();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Product> bycategory(String category) {
		String command="from Product where ActiveIs=:parameter and category_name=:category";
		Query query=sessionFactory.getCurrentSession().createQuery(command);
		query.setParameter("parameter", true);
		query.setParameter("category", category);
		return query.getResultList();
	}

}
