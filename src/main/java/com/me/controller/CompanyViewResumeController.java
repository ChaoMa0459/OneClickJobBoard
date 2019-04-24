package com.me.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.me.dao.ResumeDao;
import com.me.dao.UserDao;
import com.me.pojo.Resume;
import com.me.pojo.User;

@RequestMapping("/viewresumedetail-company.htm")
@Controller
@SessionAttributes("user")
public class CompanyViewResumeController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, @ModelAttribute("resume") Resume resume, ResumeDao resumeDao,
			@RequestParam("resumeName") String resumeName, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:login.htm";
		}

		System.out.println("CompanyViewResumeController: ");
		System.out.println("resumeName: " + resumeName);

		// should pass resume id instead
		List<Resume> resumes = resumeDao.getByResumeName(resumeName);
		resume = resumes.get(0);

		System.out.println("getByResumeName: " + resume);

		model.addAttribute("resume", resume);

		return "view-resume-company";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("resume") Resume resume, ModelMap model, HttpSession session) {
		
		String applicantEmail = resume.getEmail();
		
		System.out.println("--- CompnaySendInterviewController ---");
		System.out.println("applicantEmail: " + applicantEmail);
		
		return "redirect:company-homepanel.htm";
	}
}
