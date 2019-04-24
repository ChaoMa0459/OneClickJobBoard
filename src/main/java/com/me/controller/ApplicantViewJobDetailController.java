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

@RequestMapping("/viewjobdetail-applicant.htm")
@Controller
@SessionAttributes("user")
public class ApplicantViewJobDetailController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, @ModelAttribute("job") Job job, JobDao jobDao,
			@RequestParam("jobId") long jobId, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:login.htm";
		}

		long userId = (Long) session.getAttribute("userId");

		System.out.println("ViewJobController: ");
		System.out.println("userId: " + userId);
		System.out.println("jobId: " + jobId);

		job = jobDao.getById(jobId);

		System.out.println("getById: " + job);
		
		model.addAttribute("job", job);

		return "view-job-applicant";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(ModelMap model, @ModelAttribute("job") Job job) {
		
		// pass by hidden field
		long jobId = job.getJobId();

		System.out.println("Post jobId: " + jobId);
		return "redirect:apply-job-applicant.htm";
	}
}
