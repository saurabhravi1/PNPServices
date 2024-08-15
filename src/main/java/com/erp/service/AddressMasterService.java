package com.erp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.AddressMasterDAO;
import com.erp.entities.master.AddressMasterDTO;
import com.erp.model.AddressMasterModel;
import com.erp.model.KeyValueModel;
import com.erp.utility.PrepareModel;

@Service
public class AddressMasterService {

	@Autowired
	private AddressMasterDAO addressMasterDAO;

	private List<AddressMasterModel> addressList;

	public List<AddressMasterModel> addressList() {

		if (addressList == null)
			addressList = addressMasterDAO.findAll().stream().map(a -> PrepareModel.prepareAddressMasterModel(a))
					.toList();
		return addressList;
	}

	public boolean uploadAddressMaster(List<AddressMasterDTO> list) {
		addressMasterDAO.saveAll(list);
		return true;
	}

	public List<KeyValueModel> getCountryList() {
		List<AddressMasterModel> addresslist = addressList();

		List<KeyValueModel> list = new ArrayList<>();
//		System.out.println("Country List");
//		list.stream().forEach(System.out::println);
		list.add(new KeyValueModel("countryList", "--None--", "--None--"));
		list.addAll(addresslist.stream().map(a -> a.getCountry()).distinct()
				.map(c -> new KeyValueModel("CountryList", c, c)).toList());
		return list;
	}

	public List<KeyValueModel> getStateList() {
		List<AddressMasterModel> addresslist = addressList();

		List<KeyValueModel> list = addresslist.stream().map(a -> a.getState()).distinct()
				.map(c -> new KeyValueModel("StateList", c, c)).toList();
//		System.out.println("State List");
//		list.stream().forEach(System.out::println);
		return list;
	}
	public List<KeyValueModel> getStateList(String countryName) {
		List<AddressMasterModel> addresslist = addressList();
		List<KeyValueModel> list = new ArrayList<>();
		list.add(new KeyValueModel("stateList", "--None--", "--None--"));
		list.addAll(
				addresslist.stream()
				.filter(a->a.getCountry().equals(countryName))
				.map(a -> a.getState())
				.distinct()
				.map(c -> new KeyValueModel("StateList", c, c)).toList()
			);
//		System.out.println("State List");
//		list.stream().forEach(System.out::println);
		return list;
	}
	

	public List<KeyValueModel> getCityList(String state) {
		List<AddressMasterModel> addresslist = addressList();
		List<KeyValueModel> list = new ArrayList<>();
		list.add(new KeyValueModel("cityList", "--None--", "--None--"));
		list.addAll(addresslist.stream().filter(a -> a.getState().equals(state)).map(a -> a.getCity())
				.distinct().map(c -> new KeyValueModel("CityList", c, c)).toList());
//		System.out.println("CityList");
//		list.stream().forEach(System.out::println);
		return list;
	}

	public List<KeyValueModel> getAreaList(int zipcode) {
		List<AddressMasterModel> addresslist = addressList();
		List<KeyValueModel> list = new ArrayList<>();
		list.add(new KeyValueModel("areaList", "--None--", "--None--"));
		list.addAll(
		addresslist.stream().filter(a -> a.getZipcode() == (Integer.valueOf(zipcode)))
				.map(a -> a.getArea()).distinct().map(c -> new KeyValueModel("AreaList", c, c)).toList()
				);
//		System.out.println("AreaList");
//		list.stream().forEach(System.out::println);
		return list;
	}

	public List<KeyValueModel> getZipcodeList(String city) {
		List<AddressMasterModel> addresslist = addressList();
		List<KeyValueModel> list = new ArrayList<>();
		list.add(new KeyValueModel("areaList", "--None--", "--None--"));
		list.addAll(
		addresslist.stream().filter(a -> a.getCity().equals(city)).map(a -> a.getZipcode())
				.distinct().map(c -> new KeyValueModel("AreaList", String.valueOf(c), String.valueOf(c))).toList()
				);
//		System.out.println("AreaList");
//		list.stream().forEach(System.out::println);
		return list;
	}

	public AddressMasterModel findAddress(String area, int zipcode, String city, String state) {
		System.out.println("state :"+state);
		System.out.println("city :"+city);
		System.out.println("zipcode :"+zipcode);
		System.out.println("area :"+area);
		System.out.println("addressList size : "+addressList.size());
		Optional<AddressMasterModel> addressId = addressList.stream().filter(a -> a.getArea().contains(area)
				&& a.getZipcode() == zipcode && a.getCity().contains(city) && a.getState().contains(state)).findFirst();
		
		System.out.println("AddressService-->result of find address : "+addressId);
		return addressId.isPresent() ? addressId.get() : new AddressMasterModel();
	}
}
