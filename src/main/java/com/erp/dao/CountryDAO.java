package com.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.erp.entities.master.CountryDTO;

@Component
public interface CountryDAO extends JpaRepository<CountryDTO, Integer>{

}
