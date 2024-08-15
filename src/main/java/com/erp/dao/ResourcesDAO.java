package com.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.erp.entities.master.ResourceDTO;

@Component
public interface ResourcesDAO extends JpaRepository<ResourceDTO, Integer>{

	ResourceDTO findByName(String string);
	
}
