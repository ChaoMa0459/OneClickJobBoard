package com.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.dao.UserDao;
import com.me.pojo.User;
import com.me.validator.RegisterValidator;

@RequestMapping("/register.htm")
@Controller
public class RegisterController {
//	@Autowired
//	private ServletContext application; // only static global instances to be AutoWired
//	
//	@PostConstruct
//	public void init() {
//		// initialize global instances
//	}
//
//	@PreDestroy
//	public void destroy() throws Exception {
//		// do cleanup
//	}

	@Autowired
	RegisterValidator registerValidator;

	// Set a form validator
	@InitBinder("User")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(registerValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, User user) {
		 // if object has values, these would populate the form view automatically
		 // if an existing object populates the form fields, it is called
									// form-backing-object
		return "register-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, 
			ModelMap model, UserDao userDao) {
		if (bindingResult.hasErrors()) {
			return "register-form";  //the are validation errors, go to the form view
		}
		// no errors, so go to the success view
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
						
		// check confirm password
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			model.addAttribute("errorConfirmPassword", "Password doesn't match.");
			return "register-form";
		}
		
		String username = user.getUsername();
		User registerdUser = userDao.getUserByUsername(username);
		
		// check if username exists
		if (registerdUser == null) {
			userDao.create(user);
			return "register-success";
		} else {
			model.addAttribute("errorDupUsername", "The username has been used.");
			return "register-form";
		}
	}
	
}
