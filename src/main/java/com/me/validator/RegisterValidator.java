package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.dao.UserDao;
import com.me.pojo.User;

public class RegisterValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz) {
		//This Validator validates *just* User instances
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//basic validations
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty.username", "Username is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "empty.confirmPassword", "Confirm Password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty.email", "Email is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "empty.type", "Type is Required");
		//add additional custom validations below
	}
}
