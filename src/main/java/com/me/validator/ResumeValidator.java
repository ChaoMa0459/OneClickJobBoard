package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Resume;

public class ResumeValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz) {
		//This Validator validates *just* User instances
		return Resume.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//basic validations
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resumeName", "empty.resumeName", "Resume name is Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resumeName", "empty.resumeName", "Resume name is Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resumeName", "empty.resumeName", "Resume name is Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resumeName", "empty.resumeName", "Resume name is Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resumeName", "empty.resumeName", "Resume name is Required");
		//add additional custom validations below
	}
}
