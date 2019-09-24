package com.synergisticit.onlinebanking.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.onlinebanking.domain.Customer;
import com.synergisticit.onlinebanking.service.CustomerService;
@Component   //Error creating bean with name 'customerController': Unsatisfied dependency expressed through field 'customerValidator';
public class CustomerValidator implements Validator {
	
	 private Pattern pattern;  
	 private Matcher matcher;  
	 
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	 
	 String MOBILE_PATTERN = "[0-9]{10}";  
	 
	
	@Autowired
	CustomerService customerService;

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Customer.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		//THIS IS MUST TO VALIDATE
		Customer customer=(Customer)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerfname", "customer.customerfname", "firstname is required");
		
		if(customer.getCustomerfname()==null){
			errors.rejectValue("customerfname", "customer.customerfname.value", "fname is required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerlname", "customer.customerlname", "lastname is required");
		
		if(customer.getCustomerlname()==null){
			errors.rejectValue("customerlname", "customer.customerlname.value", "lname is required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "customer.email", "email is required");
		
		if(!(customer.getEmail()!=null&&customer.getEmail().isEmpty())){
			pattern = Pattern.compile(EMAIL_PATTERN);  
			   matcher = pattern.matcher(customer.getEmail());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("email", "email.incorrect",  
			      "Enter a correct email");  
			   }  
		}
		
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile",  
		    "required.mobile", "mobile is required.");  
		  
		// phone number validation  
		  if (!(customer.getMobile()!= 0)) {  
		   pattern = Pattern.compile(MOBILE_PATTERN);  
		   matcher = pattern.matcher(MOBILE_PATTERN);
		   if (!matcher.matches()) {  
		    errors.rejectValue("mobile", "mobile.incorrect",  
		      "Enter a correct mobile number");  
		   }  
		  } 
		
		//validationutils is required for validating the string	
		//CREATE VALIDATOR IN CONTROLLER
		
		
	
		
		if(customer.getCustomerid()==0){
			errors.rejectValue("customerid", "customer.customerid.value", "customerid is required");
		}
		
		
	}

}
