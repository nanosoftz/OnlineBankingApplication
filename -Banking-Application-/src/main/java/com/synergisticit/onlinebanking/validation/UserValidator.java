package com.synergisticit.onlinebanking.validation;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.onlinebanking.domain.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user=(User)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username", "name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password", "password is required");
	
		if(user.getUsername().length()<6){
			errors.rejectValue("username", "user.username.length", "name is required");
		}
		
		if(user.getPassword().length()<5){
			errors.rejectValue("password", "user.password.length", "password is required");
		
	}

}
}
