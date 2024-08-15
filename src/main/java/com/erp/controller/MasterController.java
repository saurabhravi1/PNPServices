package com.erp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.model.KeyValueModel;
import com.erp.service.AddressMasterService;

@RestController
@RequestMapping("/master")
public class MasterController {
	
	@Autowired
	private AddressMasterService addressMasterService;
	
	@GetMapping("/countryList")
	public ResponseEntity<List<KeyValueModel>> countryList(){
		return ResponseEntity.of(Optional.ofNullable(addressMasterService.getCountryList()));
	}
	
	@GetMapping("/countryListArray")
	public ResponseEntity<List<String>> countryListArray(){
		List<String> array = addressMasterService.getCountryList().stream().map(a->a.getValue()).toList();
		Optional<List<String>> oArray = Optional.ofNullable(array);
		return ResponseEntity.of(oArray);
	}
	
	
	@GetMapping("/stateListArray/{countryName}")
	public ResponseEntity<List<String>> stateListArray(@PathVariable("countryName") String countryName){
		List<String> array = addressMasterService.getStateList(countryName).stream().map(a->a.getValue()).toList();
		Optional<List<String>> oArray = Optional.ofNullable(array);
		return ResponseEntity.of(oArray);
	}
	@GetMapping("/cityListArray/{stateName}")
	public ResponseEntity<List<String>> cityListArray(@PathVariable("stateName") String stateName){
		
		System.out.println("");
		List<String> array = addressMasterService.getCityList(stateName).stream().map(a->a.getValue()).toList();
		Optional<List<String>> oArray = Optional.ofNullable(array);
		return ResponseEntity.of(oArray);
	}

	@GetMapping("/zipcodeListArray/{cityName}")
	public ResponseEntity<List<String>> zipcodeListArray(@PathVariable("cityName") String cityName){
		
		System.out.println("");
		List<String> array = addressMasterService.getZipcodeList(cityName).stream().map(a->a.getValue()).toList();
		Optional<List<String>> oArray = Optional.ofNullable(array);
		return ResponseEntity.of(oArray);
	}
	
	@GetMapping("/areaListArray/{zipcode}")
	public ResponseEntity<List<String>> areaListArray(@PathVariable("zipcode") int zipcode){
		
		System.out.println("");
		List<String> array = addressMasterService.getAreaList(zipcode).stream().map(a->a.getValue()).toList();
		Optional<List<String>> oArray = Optional.ofNullable(array);
		return ResponseEntity.of(oArray);
	}
}
