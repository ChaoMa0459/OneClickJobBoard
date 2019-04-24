package com.me.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/logout.htm")
@Controller
public class LogoutController {
	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, HttpSession session) {

		session.invalidate();

		return "redirect:login.htm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(ModelMap model) {
		return "redirect:logout.htm";
	}
}
