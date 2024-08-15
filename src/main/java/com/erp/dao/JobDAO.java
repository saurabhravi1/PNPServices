package com.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entities.JobDTO;

public interface JobDAO extends JpaRepository<JobDTO, Integer>{
	List<JobDTO> findByUserId(int user_id);
}
