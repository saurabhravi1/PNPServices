package com.erp.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.erp.entities.master.AddressMasterDTO;


@Entity
@Table(name = "PNP_USER")
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Name field is mandatory.")
	@Column(unique = true)
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
	@OneToOne(cascade = CascadeType.MERGE)	
	private AddressMasterDTO addressMasterDTO;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AddressMasterDTO getAddressMasterDTO() {
		return addressMasterDTO;
	}
	public void setAddressMasterDTO(AddressMasterDTO addressMasterDTO) {
		this.addressMasterDTO = addressMasterDTO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", createdDate=" + createdDate + ", enable="
				+ enable + ", expired=" + expired + ", locked=" + locked + ", credentialExpired=" + credentialExpired
				+ ", role=" + role + "]";
	}
	
	
	@Override
	public boolean equals(Object u) {
		if(!( u  instanceof UserDTO))
			return false;
		else if(this.getId()==((UserDTO)u).getId())
			return true;
		else return false;
		
		
	}
	
}
