package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.pojo.User;

@RequestMapping("/user/login.htm")
@Controller
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, User user) {
		return "login-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("user") User user, ModelMap model) {
		//no errors, so go to the success view
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return "home-panel";
	}
}
