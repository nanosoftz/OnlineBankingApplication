package com.synergisticit.onlinebanking.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.onlinebanking.domain.Loan;
import com.synergisticit.onlinebanking.service.CustomerService;
import com.synergisticit.onlinebanking.service.LoanService;

@Component
public class LoanValidator implements Validator {

	@Autowired
	LoanService loanService;
	
	@Autowired
	CustomerService customerService;
	

	@Override
	public boolean supports(Class<?> arg0) {
		return Loan.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Loan loan=(Loan)obj;
		//VALIDATING LOAN ID FIELD NOT EMPTY
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanid", "loan.loanid", "loan id not null");
		if(loan.getLoanid()==0){
			errors.rejectValue("loanid", "loan.loanid.value", "loan id not null");
		}
		
		//VALIDATING FOR ID// IF USER USE DIFFERENT CUSTOMER ID DISPLAY NOT EXISTS
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer", "loan.customer", "id not exists");
		if((loan.getCustomer()!=null)){
			if(!customerService.existsById(loan.getCustomer().getCustomerid())){
				errors.rejectValue("customer", "loan.customer.value", "customer id not exists");
			}
		}
	
			if(isValidDatefuture(loan.getLoandate())){
			errors.rejectValue("loandate", "loan.loandate.value", "todays date is required not future date");
		}
	}
	
	
		//VALIDATING FUTURE LOAN DATE
	public boolean isValidDatefuture(Date value){
		  Calendar calendar = Calendar.getInstance(); 
	        calendar.set(Calendar.HOUR_OF_DAY, 0);
	        calendar.set(Calendar.MINUTE, 0);
	        calendar.set(Calendar.SECOND, 0);
	        Date today = calendar.getTime();
	        System.out.println("today future date"+today);
	        System.out.println("@@@@@" +value.after(today));
		return value.after(today);

}
		
}
	
	





