package com.erp.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.helper.ResponseMessage;
import com.erp.model.UserModel;
import com.erp.service.AddressMasterService;
import com.erp.service.ResourcesService;
import com.erp.service.StateService;
import com.erp.service.UserService;

@Controller
public class GlobalController {

	@Autowired
	private UserService userService;

	// Logger logger = (Logger) LoggerFactory.getLogger(GlobalController.class);

	@Autowired
	private ResourcesService resourcesService;
	@Autowired
	private AddressMasterService addressMasterService;
	@Autowired
	private StateService stateService;

	@GetMapping(value = "/signup")
	public String signup(Model m, HttpSession session) {
		UserModel userModel = new UserModel();
//		userModel.setAction("create");
		m.addAttribute("countryList", addressMasterService.getCountryList());
		// m.addAttribute("stateList", addressMasterService.getStateList());
		m.addAttribute("userModel", userModel);
		m.addAttribute("title", "MyERP:SignUp");
		session.removeAttribute("responseMessage");
		return "signup";
	}

	@PostMapping("/doSignup")
	public String doSignup(@Valid @ModelAttribute("userModel") UserModel user, BindingResult br, Model m,
			HttpSession session) {

		System.out.println("Binding Results : " + br);
		System.out.println("userModel : " + user);

		// if (user.getAction().equals("create")) {
		Optional<String> response = Optional.empty();
		if (!br.hasErrors()) {
			response = userService.saveUser(user);
			String type = "User created successfully".equals(response.get()) ? "alert-success" : "alert-error";
			session.setAttribute("responseMessage", new ResponseMessage(type, response.get()));
			if (type.equals("alert-success")) {
				m.addAttribute("userModel", new UserModel());
			}
		} else {
			session.setAttribute("responseMessage", new ResponseMessage("alert-error", br.toString()));
			m.addAttribute("countryList", addressMasterService.getCountryList());
//				m.addAttribute("stateList", addressMasterService.getStateList());
//				if (user.getState() != null) {
//					m.addAttribute("cityList", addressMasterService.getCityList(user.getState()));
//				}
//				if (user.getCity() != null) {
//					m.addAttribute("zipcodeList", addressMasterService.getZipcodeList(user.getCity()));
//				}
//				if (user.getZipcode() != 0) {
//					m.addAttribute("areaList", addressMasterService.getAreaList(user.getZipcode()));
//				}
			m.addAttribute("userModel", user);
			session.removeAttribute("responseMessage");
		}
		// } else if (user.getAction().equals("refresh")) {
		// m.addAttribute("countryList", addressMasterService.getCountryList());
//			m.addAttribute("stateList", addressMasterService.getStateList());
//			if (user.getState() != null) {
//				m.addAttribute("cityList", addressMasterService.getCityList(user.getState()));
//			}
//			if (user.getCity() != null) {
//				m.addAttribute("zipcodeList", addressMasterService.getZipcodeList(user.getCity()));
//			}
//			if (user.getZipcode() != 0) {
//				m.addAttribute("areaList", addressMasterService.getAreaList(user.getZipcode()));
//			}
		
		// }
		// user.setAction("create");
		
		System.out.println("before return signup");
		return "signup";
	}

	@GetMapping(value = "/signin")
	public String login(Model m) {
		m.addAttribute("title", "Login : MyERP");
		m.addAttribute("userModel", new UserModel());
		System.out.println("Inside signin controller");
		return "signin";
	}

	@GetMapping("/home")
	public String home(Model m) {
		m.addAttribute("projectName", resourcesService.getProjectName());
		return "homeGlobal";
	}

	@GetMapping("/refresh")
	@ResponseBody
	public String refreshResources(Model m) {

		resourcesService.loadAllResourcesForce();
		addressMasterService.addressList();
		return "Resources Load Successfully";
	}
	
	@ModelAttribute
	public void addGlobalAttributes(Model m,HttpServletRequest request) {
		System.out.println("addGlobalAttributes global controller is called");
		m.addAttribute("projectName",resourcesService.getProjectName());
		m.addAttribute("contextPath",request.getContextPath());
	}

}
