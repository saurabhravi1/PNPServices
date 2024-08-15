package com.erp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.erp.entities.master.AddressMasterDTO;

@Entity(name = "PNP_JOB")
public class JobDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private String status;
	private Date createdDate;
	private Date startdate;
	private Date endDate;
	private String required;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ServiceTypeDTO> services;	
	
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
	public List<ServiceTypeDTO> getServices() {
		return services;
	}
	public void setServices(List<ServiceTypeDTO> services) {
		this.services = services;
	}
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
		
}
