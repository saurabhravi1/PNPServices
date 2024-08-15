package com.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.erp.entities.UserDTO;

@Component
public interface UserDAO extends JpaRepository<UserDTO, Integer> 
{
	public UserDTO findByUsername(String username);
	
	
}
