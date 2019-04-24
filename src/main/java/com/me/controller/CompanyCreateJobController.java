package com.me.controller;

import java.util.Enumeration;

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

import com.me.dao.JobDao;
import com.me.dao.UserDao;
import com.me.pojo.Job;
import com.me.pojo.User;
import com.me.validator.ResumeValidator;

@RequestMapping("/createjob.htm")
@Controller
@SessionAttributes("user")
public class CompanyCreateJobController {
	@Autowired
	ResumeValidator resumeValidator;

	// Set a form validator
	@InitBinder("Resume")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(resumeValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, @ModelAttribute("job") Job job, HttpSession session) {

		// session objects
		System.out.println("--- Session data ---");
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
			System.out.println("**" + session.getAttribute(s));
		}
		System.out.println("--- ---");

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:login.htm";
		}
		System.out.println("current user id: " + user.getUserId());
		System.out.println("current username: " + user.getUsername());

		return "job-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("job") Job job, BindingResult bindingResult,
			ModelMap model, JobDao jobDao, UserDao userDao, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "job-form"; // the are validation errors, go to the form view
		}

		// check job name
		String jobName = job.getJobName();

		
		User user = (User) session.getAttribute("user");
		long userId = (Long) session.getAttribute("userId");

		Job jobdata = jobDao.getByUserIdAndName(userId, jobName);
		
		System.out.println("--- create resume ---");
		System.out.println("userId" + userId);
		System.out.println("jobName" + jobName);
		
		if (jobdata != null) {
			model.addAttribute("errorName", "Job name already exists.");
			return "job-form";
		}
		
		User userdata = userDao.getUserByUsername(user.getUsername());
		
		System.out.println("current user id: " + userdata.getUserId());
		System.out.println("current username: " + userdata.getUsername());
		
		// UserDao.getSession().load(User.class, user.getUserId());
		
		// userdata.addResume(resume);
		// userDao.create(userdata);
		
		job.setUser(userdata);
		jobDao.create(job);
		return "home-panel-company";
	}
}
