package com.synergisticit.onlinebanking.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisticit.onlinebanking.domain.Account;

import com.synergisticit.onlinebanking.service.AccountService;

import com.synergisticit.onlinebanking.validation.AccountValidator;




@Controller
public class AccountController {
	
	
	@Autowired
	@Qualifier(value="accountServiceJpa")
	AccountService accountService;

	
	@Autowired
	AccountValidator accountValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(accountValidator);
	}
	
	
	@RequestMapping(value="/saveaccount",method=RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute ("account")Account acc,BindingResult result ){
		//System.out.println("%%%%%%%"+branch);
		//accountValidator.validate(acc, result);
	
		System.out.println("result.hasErrors()"+result.hasErrors());
		if(result.hasErrors()){
			
			System.out.println("return accountform.jsp");
			if(accountService.exists(acc.getAccno())){
				result.addError(new ObjectError("accno","the account number"+acc.getAccno()+"  already exists."));
			
			}
			return "accountform";
		}
		else
		{
			  
			accountService.save(acc);
			System.out.println("success"+result.hasErrors());
			return "success";
		}
			
	/*	Transaction tx=new Transaction();
		tx.setTxdate(new Date(System.currentTimeMillis()));
		
		tx.setComments("new account"+acc.getAccno()+","+acc.getAccholdername()+","+acc.getAccBalance()+","+acc.getAccType());
		transactionService.save(tx);
		
		return "success";*/
		
	}
	@RequestMapping(value="/createaccount",method=RequestMethod.GET)
	public String accountForm(Account acc){
		return "accountform";
		
	}

}
