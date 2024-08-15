package com.erp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.erp.dao.CountryDAO;
import com.erp.dao.KeyValueParamDAO;
import com.erp.dao.ResourcesDAO;
import com.erp.entities.master.KeyValueParamDTO;
import com.erp.entities.master.ResourceDTO;
import com.erp.model.KeyValueModel;

@Component
public class ResourcesService {
	@Autowired
	private ResourcesDAO resourcesDAO;
	@Autowired
	private KeyValueParamDAO keyValueParamDAO;
	
	
	private List<ResourceDTO> allResources = new ArrayList<ResourceDTO>();
	private List<KeyValueParamDTO> allKeyValueParamDTOList = new ArrayList<KeyValueParamDTO>();
	
	public String getProjectName() {		
		Optional<ResourceDTO> resource = loadResources()
				.stream()
				.filter(res->res.getName().equals("ProjectName"))
				.findAny();		
//		System.out.println("Project name resource : " + resource);
		return resource.isPresent()?resource.get().getValue():"NA";
	}
	
	public List<ResourceDTO> loadResources() {
		if(allResources==null || allResources.size()==0) 
			allResources = resourcesDAO.findAll();
		return allResources;
	}
	
	public List<KeyValueParamDTO> loadKeyValueParam() {
		if(allKeyValueParamDTOList==null || allKeyValueParamDTOList.size()==0) 
			allKeyValueParamDTOList = keyValueParamDAO.findAll();
		return allKeyValueParamDTOList;
	}
	

	
	//ServiceType
	
	public void loadAllResourcesForce() {
			allResources = resourcesDAO.findAll();
	}
	
	public List<KeyValueModel> getKeyValueList(String name){
		List<KeyValueModel> allKeyValueParamModelList = loadKeyValueParam()
				.stream()
				.filter(a->a.getName().equals(name))
				.map(a->prepareKeyValueModel(a))
				.collect(Collectors.toList());
		//System.out.println("KeyValue pairs found {"+name+"} : "+allKeyValueParamModelList);
		return allKeyValueParamModelList;
	}
	
	
	
	public KeyValueModel prepareKeyValueModel(KeyValueParamDTO keyValueParamDTO) {
		KeyValueModel keyValueModel = new KeyValueModel();
		keyValueModel.setIdentifier(keyValueParamDTO.getName());
		keyValueModel.setKey(keyValueParamDTO.getKey());
		keyValueModel.setValue(keyValueParamDTO.getValue());
		return keyValueModel;
	}
	
	
	
}
