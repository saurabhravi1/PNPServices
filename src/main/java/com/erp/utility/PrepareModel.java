package com.erp.utility;

import com.erp.entities.JobDTO;
import com.erp.entities.UserDTO;
import com.erp.entities.master.AddressMasterDTO;
import com.erp.entities.master.CountryDTO;
import com.erp.entities.master.StateDTO;
import com.erp.model.AddressMasterModel;
import com.erp.model.CountryModel;
import com.erp.model.JobModel;
import com.erp.model.StateModel;
import com.erp.model.UserModel;

public interface PrepareModel {

	public static JobModel prepareJobModel(JobDTO dto) {
		JobModel model = new JobModel();
		model.setCreatedDate(dto.getCreatedDate());
		model.setDescription(dto.getDescription());
		model.setEndDate(dto.getEndDate());
		model.setId(dto.getId());
		model.setRequired(dto.getRequired());
		model.setStartdate(dto.getStartdate());
		model.setStatus(dto.getStatus());
		model.setTitle(dto.getTitle());
		model.setUser_id(dto.getUserId());		
		model.setServices(dto.getServices().stream().map(b -> b.getName()).toArray(String[]::new));
		return model;

	}

	public static UserModel prepareUserModel(UserDTO userDTO) {
		UserModel userModel = new UserModel();
		userModel.setId(userDTO.getId());
		userModel.setCreatedDate(userDTO.getCreatedDate());
		userModel.setCredentialExpired(userDTO.isCredentialExpired());
		userModel.setDateOfBirth(userDTO.getDateOfBirth());
		userModel.setEmail(userDTO.getEmail());
		userModel.setEnable(userDTO.isEnable());
		userModel.setExpired(userDTO.isExpired());
		userModel.setLocked(userDTO.isLocked());
		userModel.setName(userDTO.getName());
		userModel.setPassword(userDTO.getPassword());
		userModel.setRole(userDTO.getRole());
		userModel.setUsername(userDTO.getUsername());
		userModel.setAddress(userDTO.getAddress());
		AddressMasterDTO dto  = userDTO.getAddressMasterDTO();
		userModel.setArea(dto.getArea());
		userModel.setZipcode(dto.getZipcode());
		userModel.setCity(dto.getCity());
		userModel.setState(dto.getState());
		userModel.setCountry(dto.getCountry());
		userModel.setAddressMasterModel(prepareAddressMasterModel(dto));		
		return userModel;
	}
	
	public static CountryModel prepareCountryModel(CountryDTO dto) {
		CountryModel model = new CountryModel();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setEnable(dto.isEnable());
		return model;		
	}
	
	public static StateModel prepareStateModel(StateDTO model) {
		StateModel dto = new StateModel();
		dto.setCountry(PrepareModel.prepareCountryModel(model.getCountry()));
		dto.setEnable(model.isEnable());
		dto.setName(model.getName());
		dto.setId(model.getId());
		return dto;
	}
	
	public static AddressMasterModel  prepareAddressMasterModel(AddressMasterDTO model) {
		AddressMasterModel dto = new AddressMasterModel();
		dto.setArea(model.getArea());
		dto.setCity(model.getCity());
		dto.setCountry(model.getCountry());
		dto.setId(model.getId());
		dto.setState(model.getState());
		dto.setZipcode(model.getZipcode());
		return dto;
	}
}
