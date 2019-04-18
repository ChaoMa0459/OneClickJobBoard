package com.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.pojo.User;
import com.me.validator.UserValidator;

@RequestMapping("/user/login.htm")
@Controller
public class LoginController {
	@Autowired
	UserValidator userValidator;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, User user) {
		return "login-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "login-form";  //the are validation errors, go to the form view
		}
		
		// check password
		
		//no errors, so go to the success view
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getType());
		return "home-panel";
	}
}
