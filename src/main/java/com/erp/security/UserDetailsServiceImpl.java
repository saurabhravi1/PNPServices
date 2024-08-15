package com.erp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.erp.dao.UserDAO;
import com.erp.entities.UserDTO;
import com.erp.service.UserService;
import com.erp.utility.PrepareModel;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDAO userDAO ;
	
	
	
	public UserDetails loadUserByUsername(String username) {
		
		UserDTO user = userDAO.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomUserDetails(PrepareModel.prepareUserModel(user));
	}



	

}
