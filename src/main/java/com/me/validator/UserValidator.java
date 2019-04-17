package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.User;

public class UserValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz) {
		//This Validator validates *just* User instances
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//basic validations
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty.first", "Username is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.last", "Password is Required");
		
		//add additional custom validations below
	}
}
