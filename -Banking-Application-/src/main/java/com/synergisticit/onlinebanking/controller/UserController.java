package com.synergisticit.onlinebanking.controller;


import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.synergisticit.onlinebanking.domain.Role;
import com.synergisticit.onlinebanking.domain.User;
import com.synergisticit.onlinebanking.service.UserService;
import com.synergisticit.onlinebanking.validation.UserValidator;

@Controller
//@SessionAttributes("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerform(User user,Model model)
	{
		Set<Role> roles=new HashSet<Role>();
		
		roles.add(new Role(new Long(1L),"Admin"));
		roles.add(new Role(new Long(2L),"Manager"));
		roles.add(new Role(new Long(3L),"DBA"));
		roles.add(new Role(new Long(4L),"HR"));
		roles.add(new Role(new Long(7L),"ROLE_USER"));
		model.addAttribute("roles",roles);
		user.setRoles(roles);
		
		return "register";
	}
	@PostMapping(value="/register")
	public String saveregister(@ModelAttribute("user") User user,BindingResult result)
	{
	
		System.out.println(" USER FROM MODEL "+user);
		
		userValidator.validate(user,result);
		
		if(result.hasErrors()){
			System.out.println("#####");
			return "register";
		}else
		{
			userService.save(user);
			return "redirect:/login";
		}
	}
	@GetMapping(value="/login")
	public String loginPage(@ModelAttribute User user,String error,String logout,HttpServletRequest request,HttpServletResponse response,Model model){
		//model.addAttribute("user", user);
		System.out.println("########LOGIN PAGE #########"+user);
		if(error!=null){
			model.addAttribute("error", "password and login not avaliable");
		
		}
		if(logout!=null){
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
			if(authentication!=null){
				new SecurityContextLogoutHandler().logout(request, response, authentication);;
			}
			return "login";
		}
		return "login";
	}
	
	@GetMapping(value={"/","/welcome"})
	public String welcomepage(User user){
		return "welcome";
	}
	
	
	
	@GetMapping(value={"/login?error"})
	public String logout(){
	
		return  "redirect:/login";
	}
	
}

	

