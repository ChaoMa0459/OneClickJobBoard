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
import com.me.pojo.Job;
import com.me.pojo.JobChoice;
import com.me.pojo.User;

@RequestMapping("/viewjob.htm")
@Controller
@SessionAttributes("user")
public class CompanyViewPanelController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, JobChoice jobChoice, JobDao jobDao, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:login.htm";
		}
				
		long userId = (Long)session.getAttribute("userId");
		
		System.out.println("userId: " + userId);

		List<Job> jobs = jobDao.getByUserId(userId);
		
		System.out.println("jobs: " + jobs.size());
		
		model.addAttribute("jobs", jobs);	
		return "view-panel-company";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("jobChoice") JobChoice jobChoice, ModelMap model) {
		
		model.addAttribute("jobName", jobChoice.getJobName());
		
		System.out.println("jobName: " + jobChoice.getJobName());
		
		return "redirect:viewjobdetail.htm";
	}
}
