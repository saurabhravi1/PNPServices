package com.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.erp.entities.master.AddressMasterDTO;

@Component
public interface AddressMasterDAO extends JpaRepository<AddressMasterDTO, Integer>{
	
	
	
}
