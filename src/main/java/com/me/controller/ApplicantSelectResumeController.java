package com.me.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.me.dao.JobApplicationDao;
import com.me.dao.ResumeDao;
import com.me.dao.UserDao;
import com.me.pojo.Resume;
import com.me.pojo.ResumeChoice;
import com.me.pojo.User;

@RequestMapping("/select-resume-applicant.htm")
@Controller
@SessionAttributes("user")
public class ApplicantSelectResumeController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, ResumeDao resumeDao, ResumeChoice resumeChoice,
			HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:login.htm";
		}
				
		long userId = (Long)session.getAttribute("userId");
		
		System.out.println("ApplicantSelectResumeController: " + userId);

		List<Resume> resumes = resumeDao.getByUserId(userId);
		
		System.out.println("resumes: " + resumes.size());
		
		model.addAttribute("resumes", resumes);	
		
		// model.addAttribute("jobId", jobId);	
		return "select-resume-applicant";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("resumeChoice") ResumeChoice resumeChoice, ModelMap model) {
		
		model.addAttribute("resumeName", resumeChoice.getResumeName());
		
		System.out.println("resumeName: " + resumeChoice.getResumeName());
		
		return "redirect:homepanel.htm";
	}
}
