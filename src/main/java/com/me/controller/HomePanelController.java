package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/homepanel.htm")
@Controller
public class HomePanelController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model) {
		if (model.get("user") == null) {
			return "redirect:login.htm";
		}
		return "home-panel";
	}
}
