package com.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.erp.entities.master.KeyValueParamDTO;

@Component
public interface KeyValueParamDAO extends JpaRepository<KeyValueParamDTO, Integer>{
	public List<KeyValueParamDTO> findByName(String name);
}
