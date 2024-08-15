package com.erp.model;

public class StateModel {
	private int id;
	private String name;
	private boolean enable;
	private CountryModel country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public CountryModel getCountry() {
		return country;
	}
	public void setCountry(CountryModel country) {
		this.country = country;
	}
	
	
}
