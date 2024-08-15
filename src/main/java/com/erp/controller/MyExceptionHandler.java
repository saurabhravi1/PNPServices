package com.erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String globalException(Model m,Exception e, HttpServletRequest req) {
		System.out.println(e.getLocalizedMessage());
		System.out.println(req.getRequestURI());
		m.addAttribute("expName", e.getLocalizedMessage());
		m.addAttribute("reqURL", req.getRequestURI());
		m.addAttribute("title","MyERP : Error Page");
		return "myErrorPage";
	}
	
}
