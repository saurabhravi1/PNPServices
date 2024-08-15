package com.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.StateDAO;
import com.erp.model.CountryModel;
import com.erp.model.StateModel;
import com.erp.utility.PrepareDTO;
import com.erp.utility.PrepareModel;

@Service
public class StateService {

	@Autowired
	private StateDAO stateDAO;

	public List<StateModel> getStateList(CountryModel countryModel) {
		List<StateModel> stateList = stateDAO.findByCountry(PrepareDTO.prepareCountryDTO(countryModel)).stream()
				.map(a -> PrepareModel.prepareStateModel(a)).toList();
		return stateList;
	}
	
	public List<StateModel> getStateList() {
		List<StateModel> stateList = stateDAO.findAll().stream()
				.map(a -> PrepareModel.prepareStateModel(a)).toList();
		return stateList;
	}
}
