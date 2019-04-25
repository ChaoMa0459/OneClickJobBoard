package com.me.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.me.dao.ResumeDao;
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

		System.out.println("--- CompanyViewResumeController ---");

		// should pass resume id instead
		List<Resume> resumes = resumeDao.getByResumeName(resumeName);
		resume = resumes.get(resumes.size() - 1);

		model.addAttribute("resume", resume);
		return "view-resume-company";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@ModelAttribute("resume") Resume resume, ModelMap model, HttpSession session) {
		
		String applicantEmail = resume.getEmail();
		
		System.out.println("--- CompnaySendInterviewController ---");
		System.out.println("applicantEmail: " + applicantEmail);
		
		try {
		sendEmail(applicantEmail);
		} catch(EmailException e) {
			e.printStackTrace();
			return "redirect:company-homepanel.htm";
		}
		
		System.out.println("Interview Email is sent.");
		return "redirect:company-homepanel.htm";
	}
	
	public void sendEmail(String applicantEmail) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        //User your gmail username and password
        email.setAuthenticator(new DefaultAuthenticator("michael1630459@gmail.com", "wanjiuwan123"));
        email.setSSLOnConnect(true);
        email.setFrom("michael1630459@gmail.com");
        email.setSubject("Test Interview Mail");
        email.setMsg("Conguatulations! You are selected for intervew! Please reply to this email for more details.");
        email.addTo(applicantEmail);
        email.send();
    }
}
