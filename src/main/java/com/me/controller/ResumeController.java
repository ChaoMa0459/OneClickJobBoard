package com.me.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

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
import com.me.pojo.Resume;
import com.me.pojo.User;
import com.me.validator.ResumeValidator;

@RequestMapping("/createresume.htm")
@Controller
@SessionAttributes("user")
public class ResumeController {
	@Autowired
	ResumeValidator resumeValidator;

	// Set a form validator
	@InitBinder("Resume")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(resumeValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, @ModelAttribute("resume") Resume resume, HttpSession session) {
		
		System.out.println("--- Session data ---");
		  Enumeration<String> e = session.getAttributeNames();
		  while (e.hasMoreElements()){
			String s = e.nextElement();
			System.out.println(s);
			System.out.println("**" + session.getAttribute(s));
		  }
		User user = (User)session.getAttribute("user");
		System.out.println("current user id: " + user.getUserId());
		System.out.println("current username: " + user.getUsername());
		
		if (model.get("user") == null) {
			return "redirect:login.htm";
		}
		return "resume-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("resume") Resume resume, BindingResult bindingResult, ModelMap model,
			ResumeDao resumeDao, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "login-form"; // the are validation errors, go to the form view
		}

		// check resume name
		String resumeName = resume.getResumeName();
		
		User user = (User)session.getAttribute("user");
		long user_id = user.getUserId();
		System.out.println("current user id: " + user.getUserId());
		System.out.println("current username: " + user.getUsername());
		
		List<Resume> resumes = resumeDao.getByUserIdAndName(user_id, resumeName);
		if (resumes.size() != 0) {
			model.addAttribute("errorName", "Resume name already exists.");
			return "login-form";
		}
		
		// TODO how to save with foreign key
		// TODO it inserts another User data
		resume.setUser(user);
		resumeDao.create(resume);
		return "home-panel";
	}
}
