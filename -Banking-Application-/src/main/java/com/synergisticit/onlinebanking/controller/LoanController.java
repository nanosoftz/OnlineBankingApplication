package com.synergisticit.onlinebanking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisticit.onlinebanking.domain.Loan;
import com.synergisticit.onlinebanking.service.LoanService;
import com.synergisticit.onlinebanking.validation.LoanValidator;

@Controller
public class LoanController {
	
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	LoanValidator loanValidator;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(loanValidator);
	}
	
	@RequestMapping(value="/loanform",method=RequestMethod.GET)
	public String loanform(@ModelAttribute("loan") Loan loan){
	
		return "loanform";
	}
	
	@RequestMapping(value="/saveloanform",method=RequestMethod.POST)
	public String saveloanform(@Valid @ModelAttribute ("loan")Loan loan,BindingResult result){
		loanValidator.validate(loan, result);
		System.out.println("result hasErrors()"+result.hasErrors());
		if(result.hasErrors()){
			System.out.println("return back to loanform.jsp");
			return "loanform";
		}
		else
		{
			loanService.save(loan);
			System.out.println("###success"+result.hasErrors());
		}
		return "loandetailssaved";
	}
	/*
	@GetMapping(value="/findAll")
	@ResponseBody
	public List<Loan> findAll(@PathVariable int loanid )
	{
		List<Loan> loanList=loanService.findAll(loanid);
		return loanList;
		
	}*/

	
}
