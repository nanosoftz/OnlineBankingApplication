package com.synergisticit.onlinebanking.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synergisticit.onlinebanking.domain.Transaction;
import com.synergisticit.onlinebanking.service.AccountService;
import com.synergisticit.onlinebanking.service.TransactionService;

@Component
public class TransactionValidator implements Validator {

//	@Autowired
//	@Qualifier("accountServiceImpl")
//	AccountService accountService;
	
	@Autowired
	TransactionService transactionService;

	@Override
	public boolean supports(Class<?> arg0) {
		return Transaction.class.equals(arg0) ;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Transaction transaction=(Transaction)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "depositamt", "transaction.depositamt.value", "deposit amount should be greater than 100");
		if(transaction.getDepositamt()>100){
			errors.rejectValue("depositamt", "transaction.depositamt.value", "deposit amount should be greater than 100");
		}
		
	}
}
