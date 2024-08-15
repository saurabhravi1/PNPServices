package com.erp.model;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;


public class UserModel {
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotBlank(message = "Name field is mandatory.")
	private String username;
	private String password;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String email;
	private Date createdDate;
	private boolean enable;
	private boolean expired;
	private boolean locked;
	private boolean credentialExpired;
	private String role;
	private String address;
	private String state;
	private String area;
	private String city;
	private AddressMasterModel addressMasterModel;
	private String country;
	

	public AddressMasterModel getAddressMasterModel() {
		return addressMasterModel;
	}

	public void setAddressMasterModel(AddressMasterModel addressMasterModel) {
		this.addressMasterModel = addressMasterModel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private int zipcode;
	private String action;
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String[] getStateArr() {
		return stateArr;
	}

	public void setStateArr(String[] stateArr) {
		this.stateArr = stateArr;
	}

	public String[] getPincodeArr() {
		return pincodeArr;
	}

	public void setPincodeArr(String[] pincodeArr) {
		this.pincodeArr = pincodeArr;
	}

	private int pincode;
	private String[] stateArr;
	private String[] pincodeArr;
	

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isCredentialExpired() {
		return credentialExpired;
	}

	public void setCredentialExpired(boolean credentialExpired) {
		this.credentialExpired = credentialExpired;
	}

	@Override
	public String toString() {
		return "User [ username=" + username + ", password=" + password + ", name=" + name
				+ ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", createdDate=" + createdDate + ", enable="
				+ enable + ", expired=" + expired + ", locked=" + locked + ", credentialExpired=" + credentialExpired
				+ ", role=" + role + "]";
	}
	
	
	
	
}
