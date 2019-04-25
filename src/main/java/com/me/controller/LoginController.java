package com.me.controller;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.me.dao.UserDao;
import com.me.pojo.User;
import com.me.validator.UserValidator;

@RequestMapping("/login.htm")
@Controller
@SessionAttributes("user")
public class LoginController {
	@Autowired
	UserValidator userValidator;

	// Set a form validator
	@InitBinder("User")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, User user, HttpSession session) {
		
		// session.invalidate();
		return "login-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap model,
			UserDao userDao, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "login-form"; // the are validation errors, go to the form view
		}

		// check password
		String username = user.getUsername();
		User registerdUser = userDao.getUserByUsername(username);
		if (registerdUser == null) {
			model.addAttribute("errorLogin", "No such user.");
			return "login-form";
		}
		
		// check confirm password
		if (!user.getPassword().equals(registerdUser.getPassword())) {
			model.addAttribute("errorLogin", "Wrong password.");
			return "login-form";
		}
		
		// no errors, so go to the success view		
		session.setAttribute("userId", registerdUser.getUserId());		
		String userType = user.getType();
		if (userType.equals("Applicant")) {
			return "home-panel-applicant";
		} else {
			return "home-panel-company";
		}
	}
}
