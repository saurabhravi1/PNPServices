package com.erp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.erp.service.JobService;
import com.erp.service.UserService;
import com.erp.utility.FileUploadHelper;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JobService jobService;
	
	
	@PostMapping("/uploadMaster")
	@ResponseBody
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model){
		
		System.out.println(multipartFile.getOriginalFilename());
		System.out.println(multipartFile.getSize());
		
		if(multipartFile.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain the file");
		}else {
			boolean result = fileUploadHelper.uploadFile(multipartFile);
			if(result==false) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed.");
			}else {
				return ResponseEntity.ok("File Uploaded Successfully.");
			}
		}	
		
	}
	@GetMapping("/home")
	public String home(Model m, HttpSession session) {
			System.out.println("userHome controller called.");
			
			m.addAttribute("title","PNPServices:AdminHome");
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();		 
			String username;
			if (principal instanceof UserDetails) {
				UserDetails ud = ((UserDetails)principal);
				username = ud.getUsername();
			} else {
			  username = principal.toString();
			}
			System.out.println("admin username : "+username);
			session.setAttribute("username", username);
			session.setAttribute("userModel", userService.getUser(username));
			System.out.println("admin username : "+username);
		
		return "admin/adminHome";
	}
	@GetMapping("/viewAllJobs")
	public String viewJobs(Model m,HttpSession session) {
		m.addAttribute("allJobList",jobService.getAllJobs(""));
		return "admin/viewAllJobs";
	}
	
	@ModelAttribute
	public void setUserData(Model m, HttpSession session) {
		System.out.println("Admin controller called.");
		//logger.debug("logging called");	
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
	
}
