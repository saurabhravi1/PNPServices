package com.erp.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler  extends  SavedRequestAwareAuthenticationSuccessHandler{
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
         
        String redirectURL = request.getContextPath();
         
        if (userDetails.getRole().contains("USER")) {
            redirectURL = "user/home";
        } else if (userDetails.getRole().contains("ADMIN")) {
            redirectURL = "admin/home";
        } else if (userDetails.getRole().contains("Shipper")) {
            redirectURL = "shipper_home";
        }
        System.out.println("LoginSuccessHandler.onAuthenticationSuccess request.getContextPath() : "+request.getContextPath()); 
        System.out.println("LoginSuccessHandler.onAuthenticationSuccess userDetails.getRole() : "+userDetails.getRole());
        System.out.println("LoginSuccessHandler.onAuthenticationSuccess redirectURL : "+redirectURL);
        response.sendRedirect(redirectURL);
         
    }
}
