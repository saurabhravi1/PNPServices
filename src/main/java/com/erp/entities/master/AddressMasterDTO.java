package com.erp.entities.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PNP_ADDRESS_MASTER")
public class AddressMasterDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Area;
	private int zipcode;
	private String city;
	private String state;	
	private String country;
	
	public AddressMasterDTO(){}
	public AddressMasterDTO(int id){ this.id=id;}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
}




