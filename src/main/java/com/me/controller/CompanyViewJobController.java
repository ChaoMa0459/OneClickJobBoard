package com.me.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.me.dao.JobDao;
import com.me.pojo.Job;
import com.me.pojo.User;

@RequestMapping("/viewjobdetail.htm")
@Controller
@SessionAttributes("user")
public class CompanyViewJobController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, @ModelAttribute("job") Job job, JobDao jobDao,
			@RequestParam("jobName") String jobName, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:login.htm";
		}

		long userId = (Long) session.getAttribute("userId");

		System.out.println("ViewJobController: ");
		System.out.println("userId: " + userId);
		System.out.println("jobName: " + jobName);

		job = jobDao.getByUserIdAndName(userId, jobName);

		System.out.println("getByUserIdAndName: " + job);
		
		model.addAttribute("job", job);

		return "view-job";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(ModelMap model) {
		return "redirect:viewresumedetail.htm";
	}
}
