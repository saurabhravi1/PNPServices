package com.erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.erp.service.ResourcesService;

@ControllerAdvice
public class ControllerAdv {
	
	@Autowired
	private ResourcesService resourcesService; 
	
	@ModelAttribute
	public void addGlobalAttributes(Model m,HttpServletRequest request) {
		System.out.println("addGlobalAttributes is called");
		m.addAttribute("projectName",resourcesService.getProjectName());
		m.addAttribute("contextPath",request.getContextPath());
	}
}
