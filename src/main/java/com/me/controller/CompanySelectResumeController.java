package com.me.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.me.dao.JobApplicationDao;
import com.me.dao.ResumeDao;
import com.me.dao.UserDao;
import com.me.pojo.JobApplication;
import com.me.pojo.Resume;
import com.me.pojo.ResumeChoice;
import com.me.pojo.User;

@RequestMapping("/select-resume-company.htm")
@Controller
@SessionAttributes("user")
public class CompanySelectResumeController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, ResumeChoice resumeChoice, JobApplicationDao applicationDao, ResumeDao resumeDao, 
			HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:login.htm";
		}
				
		long userId = (Long)session.getAttribute("userId");
		long jobId = (Long)session.getAttribute("jobId");

		System.out.println("userId: " + userId);
		System.out.println("jobId: " + jobId);

		// get Resumes by jobId
		List<JobApplication> applications = applicationDao.getByJobId(jobId);
		System.out.println("applications: " + applications.size());
		
		List<Resume> resumes = new ArrayList<Resume>();
		for (JobApplication application: applications) {
			Resume resume = resumeDao.getById(application.getResumeId());
			resumes.add(resume);
		}
		
		model.addAttribute("resumes", resumes);	
		return "select-resume-company";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("resumeChoice") ResumeChoice resumeChoice, ModelMap model) {
		
		model.addAttribute("resumeName", resumeChoice.getResumeName());
		
		System.out.println("resumeName: " + resumeChoice.getResumeName());
		
		return "redirect:viewresumedetail-company.htm";
	}
}
