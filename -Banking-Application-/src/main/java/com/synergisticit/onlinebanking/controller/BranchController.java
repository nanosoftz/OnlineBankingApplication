package com.synergisticit.onlinebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisticit.onlinebanking.domain.Branch;

import com.synergisticit.onlinebanking.service.BranchService;

@Controller
public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@RequestMapping(value="/branchform",method=RequestMethod.GET)
	public String branchform(@ModelAttribute("branch") Branch branch){
	
		return "branchform";
	}
	
	@RequestMapping(value="/savebranchform",method=RequestMethod.POST)
	public String savebranchform(Branch branch){
		branchService.save(branch);
		return "branchsuccess";
		
	}
	
	
	

}
