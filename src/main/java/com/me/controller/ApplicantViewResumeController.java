package com.me.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.me.dao.ResumeDao;
import com.me.pojo.Resume;
import com.me.pojo.User;

@RequestMapping("/viewresumedetail.htm")
@Controller
@SessionAttributes("user")
public class ApplicantViewResumeController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, @ModelAttribute("resume") Resume resume, ResumeDao resumeDao,
			@RequestParam("resumeName") String resumeName, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:login.htm";
		}

		long userId = (Long) session.getAttribute("userId");

		System.out.println("ViewResumeController: ");
		System.out.println("userId: " + userId);
		System.out.println("resumeName: " + resumeName);

		resume = resumeDao.getByUserIdAndName(userId, resumeName);

		System.out.println("getByUserIdAndName: " + resume);
		
		model.addAttribute("resume", resume);

		return "view-resume";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(ModelMap model) {
		return "redirect:viewresumedetail.htm";
	}
}
