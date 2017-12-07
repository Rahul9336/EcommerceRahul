package com.worldofshopping.frontend1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.worldofshopping.Ecommerce.dao.Branddao;
import com.worldofshopping.Ecommerce.dao.Categorydao;
import com.worldofshopping.Ecommerce.dao.Productdao;
import com.worldofshopping.Ecommerce.dao.Userdao;
import com.worldofshopping.Ecommerce.dto.Brand;
import com.worldofshopping.Ecommerce.dto.Category;
import com.worldofshopping.Ecommerce.dto.User;

@Controller
public class ListController {
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

	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public ModelAndView product(Map<String, Object> list) {
		ModelAndView model = new ModelAndView("admin/productlist");
		list.put("category", categoryDao.categorylist());
		list.put("product", productDao.productList());
		return model;
	}

	@RequestMapping(value = "/admin/category/list", method = RequestMethod.GET)
	public ModelAndView category(Map<String, Object> list) {
		ModelAndView model = new ModelAndView("admin/categorylist");
		list.put("category", categoryDao.categorylist());
		return model;
	}

	@RequestMapping(value = "/admin/brand/list", method = RequestMethod.GET)
	public ModelAndView brand(Map<String, Object> list) {
		ModelAndView model = new ModelAndView("admin/brandlist");
		list.put("brand", brandDao.brandlist());
		return model;
	}

	@RequestMapping(value = "/admin/usersdetail", method = RequestMethod.GET)
	public ModelAndView userdetail(Map<String, Object> list) {
		ModelAndView model = new ModelAndView("admin/Alluserlist");
		list.put("userdetail", userDao.userslist());
		return model;
	}
}
