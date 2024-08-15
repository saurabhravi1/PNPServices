package com.erp.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;

import com.erp.entities.JobDTO;
import com.erp.entities.ServiceTypeDTO;
import com.erp.entities.UserDTO;
import com.erp.entities.master.AddressMasterDTO;
import com.erp.entities.master.CountryDTO;
import com.erp.entities.master.StateDTO;
import com.erp.model.AddressMasterModel;
import com.erp.model.CountryModel;
import com.erp.model.JobModel;
import com.erp.model.StateModel;
import com.erp.model.UserModel;

public interface PrepareDTO {
	public static JobDTO prepareJobDTO(JobModel model) {
		JobDTO dto = new JobDTO();
		dto.setId(model.getId());
		dto.setCreatedDate(model.getCreatedDate());
		dto.setDescription(model.getDescription());
		dto.setEndDate(model.getEndDate());
		dto.setId(model.getId());
		dto.setRequired(model.getRequired());
		dto.setStartdate(model.getStartdate());
		dto.setStatus(model.getStatus());
		dto.setTitle(model.getTitle());
		dto.setUserId(model.getUser_id());	
		List<ServiceTypeDTO> serviceDTOList = new ArrayList<ServiceTypeDTO>();		
		//TODO: Change this if else to dynamic
		Arrays.asList(model.getServices()).stream().forEach(a->{
			ServiceTypeDTO sdto = new ServiceTypeDTO();
			int id=0;
			if(a.equals("ecr"))
				id=112;
			else if (a.equals("cleaning"))
				id=113;
			else if (a.equals("plumbing"))
				id=114;
			else if (a.equals("decorationR"))
				id=115;
			
			
			sdto.setId(id);
			sdto.setEnable(true);
			sdto.setName(a);
			serviceDTOList.add(sdto);
		});;
		
		dto.setServices(serviceDTOList);
		return dto;
		
	}
	
	public static UserDTO prepareUserDTO(UserModel userModel) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userModel.getId());
		userDTO.setCreatedDate(userModel.getCreatedDate());
		userDTO.setCredentialExpired(userModel.isCredentialExpired());
		userDTO.setDateOfBirth(userModel.getDateOfBirth());
		userDTO.setEmail(userModel.getEmail());
		userDTO.setEnable(userModel.isEnable());
		userDTO.setExpired(userModel.isExpired());
		userDTO.setLocked(userModel.isLocked());
		userDTO.setName(userModel.getName());
		userDTO.setPassword(userModel.getPassword());
		userDTO.setRole(userModel.getRole());
		userDTO.setUsername(userModel.getUsername());
		userDTO.setAddress(userModel.getAddress());
		userDTO.setAddressMasterDTO(preapreAddressMasterDTO(userModel.getAddressMasterModel()));
		return userDTO;
	}

	public static CountryDTO prepareCountryDTO(CountryModel model) {
		CountryDTO dto = new CountryDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setEnable(model.isEnable());
		return dto;
		
	}

	public static StateDTO prepareStateDTO(StateModel model) {
		StateDTO dto = new StateDTO();
		dto.setCountry(PrepareDTO.prepareCountryDTO(model.getCountry()));
		dto.setEnable(model.isEnable());
		dto.setName(model.getName());
		dto.setId(model.getId());
		return dto;
	}

	public static AddressMasterDTO preapreAddressMasterDTO(AddressMasterModel model) {
		AddressMasterDTO dto = new AddressMasterDTO();
		dto.setArea(model.getArea());
		dto.setCity(model.getCity());
		dto.setCountry(model.getCountry());
		dto.setId(model.getId());
		dto.setState(model.getState());
		dto.setZipcode(model.getZipcode());
		return dto;
	}
}
