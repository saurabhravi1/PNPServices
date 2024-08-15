package com.erp.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.erp.dao.AddressMasterDAO;
import com.erp.dao.UserDAO;
import com.erp.entities.UserDTO;
import com.erp.entities.master.AddressMasterDTO;
import com.erp.model.AddressMasterModel;
import com.erp.model.UserModel;
import com.erp.utility.PrepareDTO;
import com.erp.utility.PrepareModel;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AddressMasterDAO addressMasterDAO;
	
	@Autowired
	private AddressMasterService addressMasterService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	
	public Optional<String> saveUser(UserModel userModel){
		userModel.setCreatedDate(new Date());
		userModel.setCredentialExpired(false);
		userModel.setEnable(true);
		userModel.setExpired(false);
		userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		AddressMasterModel addressid=addressMasterService.findAddress(userModel.getArea(), userModel.getZipcode(),userModel.getCity(), userModel.getState()
				);
		userModel.setAddressMasterModel(addressid);
		UserDTO userDTO = PrepareDTO.prepareUserDTO(userModel);
		
		Optional<AddressMasterDTO> addressMasterDTO = addressMasterDAO.findById(addressid.getId());
		addressMasterDAO.save(addressMasterDTO.get());
		UserDTO savedUser=userDAO.save(userDTO);
		try{
			savedUser = userDAO.save(savedUser);
		}catch(Exception e) {
			savedUser=null;
			return Optional.ofNullable("User creation failed due to : "+e.getLocalizedMessage());
		}
		if(savedUser==null) {
			return Optional.ofNullable("User creation failed");
		}
		else 
			return Optional.ofNullable("User created successfully");
	}
	
	public UserModel getUser(String username) {
		UserDTO userDTO = userDAO.findByUsername(username);
		System.out.println("userservice.getuser : UserDTO --> "+userDTO);
		return PrepareModel.prepareUserModel(userDTO);
	}
	
	
	
}
