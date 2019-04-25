package com.me.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.me.dao.JobDao;
import com.me.dao.UserDao;
import com.me.pojo.ApplyJobChoice;
import com.me.pojo.Job;
import com.me.pojo.User;

@RequestMapping("/viewjob-applicant.htm")
@Controller
@SessionAttributes("user")
public class ApplicantViewJobController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, ApplyJobChoice applyJobChoice, JobDao jobDao, UserDao userDao, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:login.htm";
		}
						
		List<Job> jobs = jobDao.getAll();
		
		System.out.println("jobs: " + jobs.size());
		
		model.addAttribute("jobs", jobs);	
		return "select-job-applicant";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("applyJobChoice") ApplyJobChoice applyJobChoice, ModelMap model) {
		
		model.addAttribute("jobId", applyJobChoice.getJobId());
		
		System.out.println("jobId: " + applyJobChoice.getJobId());
		
		return "redirect:viewjobdetail-applicant.htm";
	}
}
