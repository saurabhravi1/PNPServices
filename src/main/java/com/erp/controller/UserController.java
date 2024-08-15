package com.erp.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.dao.UserDAO;
import com.erp.service.AddressMasterService;
import com.erp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private AddressMasterService addressMasterService;
	
	@Autowired
	private UserService userService;
		
	@GetMapping("/home")
	public String userHome(Model m, HttpSession session) {
		System.out.println("userHome controller called.");
		logger.debug("logging called");	
		m.addAttribute("title","PNPServices:UserHome");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();		 
		String username;
		if (principal instanceof UserDetails) {
			UserDetails ud = ((UserDetails)principal);
			username = ud.getUsername();
		} else {
		  username = principal.toString();
		}
		System.out.println("username : "+username);
		session.setAttribute("username", username);
		session.setAttribute("userModel", userService.getUser(username));
		System.out.println("username : "+username);
		
		return "user/userHome";
	}	
	
	@ModelAttribute
	public void setUserData(Model m, HttpSession session) {
		System.out.println("userHome controller called.");
		logger.debug("logging called");	
		m.addAttribute("title","MyERP:UserHome");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();		 
		String username;
		if (principal instanceof UserDetails) {
			UserDetails ud = ((UserDetails)principal);
			username = ud.getUsername();
		} else {
		  username = principal.toString();
		}
		System.out.println("username : "+username);
		session.setAttribute("username", username);
		session.setAttribute("userModel", userService.getUser(username));
		System.out.println("username : "+username);
		
		//return "user/userHome";
	}	
	
	@ResponseBody
	@GetMapping("/countryList")
	public String[] getCountryList() {
		return addressMasterService.getCountryList().stream().map(a->a.getValue()).toArray(String[]::new);
	}
	
	@ResponseBody
	@GetMapping("/stateList/{countryName}")
	public String[] getCountryList(@PathVariable("countryName") String countryName) {
		return addressMasterService.getStateList().stream().map(a->a.getValue()).toArray(String[]::new);
	}
}
