package com.worldofshopping.frontend1;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.worldofshopping.Ecommerce.dao.Userdao;
import com.worldofshopping.Ecommerce.dto.User;

@Controller
public class UserController {
	User user;
	@Autowired
	Userdao userDao;
	@RequestMapping(value="/welcome")
	public ModelAndView welcome() {
		ModelAndView model=new ModelAndView("user/welcome");
		return model;
	}
	@RequestMapping(value="/user/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView model=new ModelAndView("user/login");
		String ip=request.getRemoteAddr();
		Long id=extractInt(ip);
		System.out.println(request.getRemoteHost());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteUser());
		System.out.println(request.getUserPrincipal());
		System.out.println(request.getLocalPort());
		System.out.println(id);
		return model;
	}
	public static long extractInt(String str) {
		    String x = str;
		    String numStr = "";

		    for (int i = 0; i < x.length(); i++) {
		        char charCheck = x.charAt(i);
		        if(Character.isDigit(charCheck)) {
		            numStr += charCheck;
		        }
		    }

		    Long num = Long.parseLong(numStr);
		    return num;
    }

}
