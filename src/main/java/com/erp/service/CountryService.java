package com.erp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.CountryDAO;
import com.erp.model.CountryModel;
import com.erp.utility.PrepareModel;

@Service
public class CountryService {
	
	@Autowired
	private CountryDAO countryDAO;
	
	public List<CountryModel> getCountryList() {
		return countryDAO.findAll().stream().map(c->PrepareModel.prepareCountryModel(c)).collect(Collectors.toList());
	}
	
}
