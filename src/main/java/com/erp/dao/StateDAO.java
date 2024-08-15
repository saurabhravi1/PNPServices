package com.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.erp.entities.master.CountryDTO;
import com.erp.entities.master.StateDTO;

@Component
public interface StateDAO extends JpaRepository<StateDTO, Integer> {
	public List<StateDTO> findByCountry(CountryDTO countryDTO);
}
