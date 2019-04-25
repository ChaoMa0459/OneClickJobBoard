package com.me.controller;

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
import com.me.pojo.JobApplication;
import com.me.pojo.Resume;
import com.me.pojo.ResumeChoice;
import com.me.pojo.User;

@RequestMapping("/select-resume-applicant.htm")
@Controller
@SessionAttributes("user")
public class ApplicantSelectResumeController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, ResumeDao resumeDao, ResumeChoice resumeChoice, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:login.htm";
		}

		long userId = (Long) session.getAttribute("userId");

		System.out.println("--- ApplicantSelectResumeController ---");

		List<Resume> resumes = resumeDao.getByUserId(userId);

		System.out.println("resumes: " + resumes.size());

		model.addAttribute("resumes", resumes);

		// model.addAttribute("jobId", jobId);
		return "select-resume-applicant";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("resumeChoice") ResumeChoice resumeChoice, ResumeDao resumeDao,
			JobApplicationDao applicationDao, ModelMap model, HttpSession session) {

		String resumeName = resumeChoice.getResumeName();

		System.out.println("resumeName: " + resumeName);
		
		long userId = (Long) session.getAttribute("userId");
		long jobId = (Long) session.getAttribute("jobId");		
		Resume resume = resumeDao.getByUserIdAndName(userId, resumeName);
		long resumeId = resume.getResumeId();
		
		System.out.println("jobId: " + jobId);
		System.out.println("resumeId: " + resumeId);
		
		JobApplication application = new JobApplication();
		application.setResumeId(resumeId);
		application.setJobId(jobId);
		applicationDao.create(application);

		return "redirect:homepanel.htm";
	}
}
