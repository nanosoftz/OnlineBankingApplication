package com.synergisticit.onlinebanking.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.onlinebanking.domain.Role;
import com.synergisticit.onlinebanking.service.RoleService;

@Component
public class RoleValidator implements Validator {

	@Autowired
	RoleService roleService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Role.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Role role=(Role)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "role.id.value","id already exists");
		if(roleService.exists(role.getId())){
			errors.rejectValue("id", "role.id.value", "role id already exists");
		}
		
	}

}
