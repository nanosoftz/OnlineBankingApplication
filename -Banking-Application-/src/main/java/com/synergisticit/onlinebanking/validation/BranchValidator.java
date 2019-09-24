package com.synergisticit.onlinebanking.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.onlinebanking.domain.Branch;
import com.synergisticit.onlinebanking.service.BranchService;

@Component
public class BranchValidator implements Validator {

	@Autowired
	BranchService branchService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return Branch.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Branch branch=(Branch)arg0;
		
	}

	/*@Override
	public void validate(Object obj1, Errors errors) {
		Branch branch=(Branch)obj1;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bcode", "branch.bcode.empty", "bcode not exist");
		if(branchService.exists(branch.getBcode())){
			errors.rejectValue("bcode", "branch.bcode.value", "this branch already  exist");
		}
		
	}*/
}


