package com.synergisticit.onlinebanking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisticit.onlinebanking.domain.Role;
import com.synergisticit.onlinebanking.service.RoleService;
import com.synergisticit.onlinebanking.validation.RoleValidator;


@Controller
public class RoleController {
	
	@Autowired 
	RoleService roleService;
	
	@Autowired
	RoleValidator roleValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(roleValidator);
	}
	
	@RequestMapping(value="/createrole",method=RequestMethod.GET)
	public String createRole(Role role){
		System.out.println("@@@@@ ENTERING INTO ROLE CONTROLLER");
		return "roleForm";
	}

	@RequestMapping(value="/saverole",method=RequestMethod.POST)
	public String saveRole(@Valid @ModelAttribute("role") Role role,BindingResult result)
	{
		System.out.println("$$$$$$$$ in post mapping");
		roleValidator.validate(role, result);
		System.out.println("result.hasErrors()"+result.hasErrors());
		if(result.hasErrors()){
			System.out.println("return to register.jsp page");
			return "roleForm";
		}
		
		else{
			System.out.println("#######");
			roleService.save(role);
			return "success";
		}
		
	
	}
}
