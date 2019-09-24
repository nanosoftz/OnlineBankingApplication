package com.synergisticit.onlinebanking.controller;



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

import com.synergisticit.onlinebanking.domain.Customer;

import com.synergisticit.onlinebanking.service.CustomerService;

import com.synergisticit.onlinebanking.validation.CustomerValidator;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerValidator customerValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(customerValidator);
	}
	
	
	@GetMapping(value="/customerform")
	public String customerForm(Customer customer){
		return "customerform";
		
	}
	
	@RequestMapping(value="/savecustomer",method=RequestMethod.POST)
	public String saveCustomer(@Valid @ModelAttribute("customer")Customer customer,BindingResult result){
		customerValidator.validate(customer, result);
		System.out.println("result has errors"+result.hasErrors());
		if(result.hasErrors()){
			System.out.println("return to jsp page");
			return "customerform";
		}else
		{
			customerService.save(customer);
			System.out.println("success"+result.hasErrors());

			return "customersuccess";
		}
	}
	
	@GetMapping(value="/findById/{customerid}")
	@ResponseBody
	public  Customer getById(@PathVariable int customerid)
	{
		return customerService.findById(customerid);
		
	}
	
	
	
	
}