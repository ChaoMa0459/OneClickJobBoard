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

import com.me.dao.ResumeDao;
import com.me.dao.UserDao;
import com.me.pojo.Resume;
import com.me.pojo.User;
import com.me.validator.ResumeValidator;

@RequestMapping("/createresume.htm")
@Controller
@SessionAttributes("user")
public class ApplicantCreateResumeController {
	@Autowired
	ResumeValidator resumeValidator;

	// Set a form validator
	@InitBinder("Resume")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(resumeValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, @ModelAttribute("resume") Resume resume, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:login.htm";
		}

		return "resume-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("resume") Resume resume, BindingResult bindingResult,
			ModelMap model, ResumeDao resumeDao, UserDao userDao, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "resume-form"; // the are validation errors, go to the form view
		}

		// check resume name
		String resumeName = resume.getResumeName();

		User user = (User) session.getAttribute("user");
		long userId = (Long) session.getAttribute("userId");

		Resume resumedata = resumeDao.getByUserIdAndName(userId, resumeName);
		
		System.out.println("--- ApplicantCreateResumeController ---");
		System.out.println("userId: " + userId);
		System.out.println("resumeName: " + resumeName);
		
		if (resumedata != null) {
			model.addAttribute("errorName", "Resume name already exists.");
			return "resume-form";
		}
		
		User userdata = userDao.getUserByUsername(user.getUsername());
		
		System.out.println("current user id: " + userdata.getUserId());
		System.out.println("current username: " + userdata.getUsername());
		
		// UserDao.getSession().load(User.class, user.getUserId());
		
		userdata.addResume(resume);
		// userDao.create(userdata);
		
		resume.setUser(userdata);
		resumeDao.create(resume);
		return "home-panel-applicant";
	}
}
