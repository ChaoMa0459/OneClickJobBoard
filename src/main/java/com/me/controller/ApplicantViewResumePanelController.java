package com.me.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.me.dao.ResumeDao;
import com.me.dao.UserDao;
import com.me.pojo.Resume;
import com.me.pojo.ResumeChoice;
import com.me.pojo.User;

@RequestMapping("/viewresume.htm")
@Controller
@SessionAttributes("user")
public class ApplicantViewResumePanelController {

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, ResumeChoice resumeChoice, ResumeDao resumeDao, UserDao userDao, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null || session.getAttribute("userId") == null) {
			return "redirect:login.htm";
		}
				
		long userId = (Long)session.getAttribute("userId");
		
		List<Resume> resumes = resumeDao.getByUserId(userId);
		
		System.out.println("resumes: " + resumes.size());
		
		model.addAttribute("resumes", resumes);	
		return "view-panel-applicant";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("resumeChoice") ResumeChoice resumeChoice, ModelMap model) {
		
		model.addAttribute("resumeName", resumeChoice.getResumeName());		
		System.out.println("resumeName: " + resumeChoice.getResumeName());
		
		return "redirect:viewresumedetail.htm";
	}
}
