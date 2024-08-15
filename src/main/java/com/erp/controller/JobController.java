package com.erp.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.erp.entities.UserDTO;
import com.erp.helper.ResponseMessage;
import com.erp.model.JobModel;
import com.erp.model.KeyValueModel;
import com.erp.model.UserModel;
import com.erp.service.AddressMasterService;
import com.erp.service.JobService;
import com.erp.service.ResourcesService;
import com.erp.service.UserService;
import com.erp.utility.PortalConstants;

@Controller
public class JobController {
	
	@Autowired
	private ResourcesService resourcesService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressMasterService addressMasterService;
	
	@GetMapping("/user/newJob")
	public ModelAndView newPost(ModelAndView mv,HttpSession session) {
		mv.addObject("jobModel", new JobModel());
		System.out.println("_____session attribute list");
		session.getAttributeNames().asIterator().forEachRemaining(a->System.out.println(a));
		List<KeyValueModel> serviceList = resourcesService.getKeyValueList(PortalConstants.ServiceTypes);
		mv.addObject("countryList", addressMasterService.getCountryList());
		mv.addObject("serviceList", serviceList);
		mv.setViewName("user/newJob");
		return mv;
	}
	
	@PostMapping("/user/saveJob")
	public String saveJob(@Valid @ModelAttribute("jobModel") JobModel jobModel,BindingResult br,HttpSession session,  Model m){
		System.out.println("Printing__________jobs");
		//Arrays.asList(jobModel.getServices()).stream().forEach((System.out::println));
		
		if(!br.hasErrors()) {
			jobModel = jobService.saveJob(jobModel,(UserModel)session.getAttribute("userModel"));
			String type = jobModel.getId()>0?"alert-success":"alert-error";
			session.setAttribute("responseMessage",new ResponseMessage(type,"Job Created with Job id:"+jobModel.getId()));
			if(type.equals("alert-success")) {
				m.addAttribute("jobModel", new JobModel());
			}
			
		}else {
			session.setAttribute("responseMessage",new ResponseMessage("alert-success",br.toString()));
			m.addAttribute("jobModel",jobModel);
		}
		return "user/newJob";
	}
	
	
	
	@GetMapping("/user/userAllJobs")
	public String viewUserJobs(Model m,HttpSession session) {
		session.setAttribute("responseMessage",null);
		UserModel user = (UserModel)session.getAttribute("userModel");
		m.addAttribute("allJobList",jobService.getAllJobsByUsername(user.getId()));
		return "user/userAllJobs";
	}
	
	@GetMapping("/user/update/{jobId}")
	public String updateJob(@PathVariable(value ="jobId") int jobId, Model m,HttpSession session) {
		System.out.println("update job id "+jobId);
		JobModel jobModel = jobService.getJobByJobId(jobId);
		System.out.println(" updateJob jobModel.id : "+jobModel.getId());
		m.addAttribute("jobModel", jobModel);
		UserModel user = (UserModel)session.getAttribute("userModel");
		m.addAttribute("allJobList",jobService.getAllJobsByUsername(user.getId()));
		return "user/newJob";
	}
	
	@GetMapping("/user/delete/{jobId}")
	public String deleteJob(@PathVariable(value ="jobId") int jobId, Model m,HttpSession session) {
		System.out.println("delete job id "+jobId);
		ResponseMessage responseMessage  = jobService.deleteJob(jobId);
		session.setAttribute("responseMessage",responseMessage);
		UserModel user = (UserModel)session.getAttribute("userModel");
		m.addAttribute("allJobList",jobService.getAllJobsByUsername(user.getId()));
		return "user/userAllJobs";		
	}
	
	
	@ModelAttribute
	public void setJobParameters(Model m, HttpSession session) {
		List<KeyValueModel> keyvalueList = resourcesService.getKeyValueList(PortalConstants.JobRequired);
		m.addAttribute("jobRequiredList",keyvalueList);
		List<KeyValueModel> serviceList = resourcesService.getKeyValueList(PortalConstants.ServiceTypes);
		m.addAttribute("serviceList", serviceList);
		
			System.out.println("userHome controller called.");
		//	logger.debug("logging called");	
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
