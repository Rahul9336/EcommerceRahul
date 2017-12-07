package com.worldofshopping.frontend1;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.worldofshopping.Ecommerce.dao.Branddao;
import com.worldofshopping.Ecommerce.dao.Categorydao;
import com.worldofshopping.Ecommerce.dao.Productdao;
import com.worldofshopping.Ecommerce.dao.Userdao;
import com.worldofshopping.Ecommerce.dto.Brand;
import com.worldofshopping.Ecommerce.dto.Category;
import com.worldofshopping.Ecommerce.dto.Product;
import com.worldofshopping.Ecommerce.dto.User;

@Controller
public class AdminController {
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
	Product product;
	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/admin/page", method = RequestMethod.GET)
	public String home() {

		return "admin/adminlogin";
	}

	@RequestMapping(value = "/admin/productaddsuccess", method = RequestMethod.POST)
	public ModelAndView setupForm(@Valid @ModelAttribute("product") Product product, BindingResult result,
			Map<String, Object> map, Map<String, String> message) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("admin/product");
			map.put("category", categoryDao.categorylist());
			map.put("brand", brandDao.brandlist());
			return model;
		} else {
			if (!(product.getFile().getOriginalFilename().equals(""))) {
				product.setProductImg_url(uploadImage(product.getFile(), product));
			}
			ModelAndView model = new ModelAndView("admin/product");
			System.out.println("Image uploaded");
			productDao.add(product);
			message.put("message", "Product Add SuucessFully");
			map.put("product", productDao.productList());
			map.put("category", categoryDao.categorylist());
			map.put("brand", brandDao.brandlist());
			return model;
		}
		
	}

	@RequestMapping(value = "/signupSuccess", method = RequestMethod.POST)
	public ModelAndView Signupsuccess(@Valid @ModelAttribute("user1") User user, BindingResult result,Map<String,String>map) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("SignUp");
			return model;
		} else {
			ModelAndView model1 = new ModelAndView("SignUp");
			try {
			userDao.add(user);
			map.put("message", "Sign up Success");}catch(Exception ex){
				map.put("Exception", "Email Alreday IN Used");
			}
			return model1;
		}
	}

	@RequestMapping(value = "/updateordelete/{id}", method = RequestMethod.GET)
	public ModelAndView productAddSuccess(@RequestParam(value = "action") String action,
			@PathVariable(value = "id") Long id, Map<String, Object> map,Map<String, String> message) {
		System.out.println(action + id);
		Product productResult = new Product();
		String edit = "EDIT";
		String delete = "DELETE";
		if (action.equalsIgnoreCase(edit)) {
			productResult = productDao.getProductId(id);
			map.put("productedit", productResult);
			map.put("category", categoryDao.categorylist());
			map.put("product", productDao.getProductId(id));
			map.put("brand", brandDao.brandlist());
			ModelAndView model1 = new ModelAndView("admin/edit");
			return model1;
		} else {
			if (action.equalsIgnoreCase(delete)) {
				productResult = productDao.getProductId(id);
				productDao.delete(productResult);
				ModelAndView model1 = new ModelAndView("admin/productlist");
				message.put("delsuccess", "Delete Success");
				map.put("category", categoryDao.categorylist());
				map.put("product", productDao.productList());
				return model1;
			}  else {
					ModelAndView model1 = new ModelAndView("admin/productlist");
					return model1;
				}
			}
		}

	@RequestMapping(value = "/categoryAddSuccess", method = RequestMethod.POST)
	public ModelAndView categoryAddSuccess(@Valid @ModelAttribute("category") Category category, BindingResult result,Map<String, String> message) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("admin/category");
			return model;
		} else {
			ModelAndView model1 = new ModelAndView("admin/category");
			message.put("message", "Category Add successfully");
			categoryDao.add(category);
			return model1;
		}
	}

	@RequestMapping(value = "/brandAddSuccess", method = RequestMethod.POST)
	public ModelAndView brandAddSuccess(@Valid @ModelAttribute("brand") Brand brand, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("admin/brand");
			return model;
		} else {
			ModelAndView model1 = new ModelAndView("admin/brand");
			brandDao.add(brand);
			return model1;
		}
	}

	public String uploadImage(MultipartFile multipart, Product product) {
		System.out.println("MultiPart1");
		String folderToUpload = "/resources/Image/";
		String fileName = multipart.getOriginalFilename();
		System.out.println("MultiPart2");
		String realPath = request.getServletContext().getRealPath(folderToUpload);
		System.out.println(realPath);
		if (!new File(realPath).exists()) {
			System.out.println("MultiPart4");
			new File(realPath).mkdirs();
		}
		System.out.println("MultiPart5");
		String filePath = realPath + product.getName() + ".jpg";
		File destination = new File(filePath);
		try {
			System.out.println("MultiPart6");
			multipart.transferTo(destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(fileName);
		System.out.println(folderToUpload);
		System.out.println(destination);
		return fileName;
	}
	@RequestMapping(value="/product/edit", method = RequestMethod.POST)
	public ModelAndView productEdit(@Valid @ModelAttribute Product product, BindingResult result,@RequestParam(value = "action") String action,Map<String,Object>map,Map<String,String>message){
		String update="UPDATE";	
		if(result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("admin/edit");
			return model1;
		}
		else
		{
		if (action.equalsIgnoreCase(update)) {
			if (!(product.getFile().getOriginalFilename().equals(""))) {
				product.setProductImg_url(uploadImage(product.getFile(), product));
			}
				productDao.update(product);
				ModelAndView model1 = new ModelAndView("admin/productlist");
				message.put("delsuccess", "Update Success");
				map.put("category", categoryDao.categorylist());
				map.put("product", productDao.productList());
				return model1;
			}else {
				message.put("message", "Something Error occured During update");
				ModelAndView model1 = new ModelAndView("admin/productlist");
				return model1;
			}
	}
}
	@RequestMapping(value="/brand/updateordelete/{id}", method = RequestMethod.GET)
	public ModelAndView brandeditOrDelete(@RequestParam(value = "action") String action,
			@PathVariable(value = "id") Long id, Map<String, Object> map,Map<String, String> message) {
		String edit = "EDIT";
		String delete = "DELETE";
		Brand brandResult=new Brand();
		if (action.equalsIgnoreCase(edit)) {
			map.put("brand", brandDao.getbrand(id));
			ModelAndView model1 = new ModelAndView("admin/brandedit");
			return model1;
		} else {
			if (action.equalsIgnoreCase(delete)) {
				brandResult = brandDao.getbrand(id);
				brandDao.delete(brandResult);
				ModelAndView model1 = new ModelAndView("admin/brandlist");
				map.put("brand", brandDao.brandlist());
				message.put("delsuccess", "Delete Success");
				return model1;
			}  else {
					ModelAndView model1 = new ModelAndView("admin/brandlist");
					return model1;
				}
			}
	}
	@RequestMapping(value="admin/brand/edit", method = RequestMethod.POST)
	public ModelAndView brandUpdate(@Valid @ModelAttribute Brand brand, BindingResult result,@RequestParam(value = "action") String action,Map<String,Object>map,Map<String,String>message){
		String update="UPDATE";	
		if(result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("admin/brandedit");
			return model1;
		}
		else
		{
		if (action.equalsIgnoreCase(update)) {
				brandDao.update(brand);
				ModelAndView model1 = new ModelAndView("admin/brandlist");
				map.put("brand", brandDao.brandlist());
				message.put("delsuccess", "Update Success");
				return model1;
			}else {
				message.put("message", "Something Error occured During update");
				ModelAndView model1 = new ModelAndView("admin/brandlist");
				return model1;
			}
	}
}
	@RequestMapping(value="/category/updateordelete/{id}", method = RequestMethod.GET)
	public ModelAndView categoryeditorDelete(@RequestParam(value = "action") String action,
			@PathVariable(value = "id") Long id, Map<String, Object> map,Map<String, String> message) {
		String edit = "EDIT";
		String delete = "DELETE";
		Category categoryResult=new Category();
		if (action.equalsIgnoreCase(edit)) {
			map.put("category", categoryDao.getcategoryById(id));
			ModelAndView model1 = new ModelAndView("admin/categoryedit");
			return model1;
		} else {
			if (action.equalsIgnoreCase(delete)) {
				categoryResult = categoryDao.getcategoryById(id);
				categoryDao.delete(categoryResult);
				ModelAndView model1 = new ModelAndView("admin/categorylist");
				map.put("category", categoryDao.categorylist());
				message.put("delsuccess", "Delete Success");
				return model1;
			}  else {
					ModelAndView model1 = new ModelAndView("admin/categorylist");
					return model1;
				}
			}
	}
	@RequestMapping(value="admin/category/edit", method = RequestMethod.POST)
	public ModelAndView categoryUpdate(@Valid @ModelAttribute Category category, BindingResult result,@RequestParam(value = "action") String action,Map<String,Object>map,Map<String,String>message){
		String update="UPDATE";	
		if(result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("admin/brandedit");
			return model1;
		}
		else
		{
		if (action.equalsIgnoreCase(update)) {
				categoryDao.update(category);
				ModelAndView model1 = new ModelAndView("admin/categorylist");
				map.put("category", categoryDao.categorylist());
				message.put("delsuccess", "Update Success");
				return model1;
			}else {
				message.put("message", "Something Error occured During update");
				ModelAndView model1 = new ModelAndView("admin/categorylist");
				return model1;
			}
	}
}
	}