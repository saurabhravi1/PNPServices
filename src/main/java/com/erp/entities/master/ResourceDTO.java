package com.erp.entities.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="PNP_RESOURCES")
public class ResourceDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String value;
	private String dataType;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public ResourceDTO() {}
	
	public ResourceDTO(int id, String name, String value, String dataType) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.dataType = dataType;
	}
	@Override
	public String toString() {
		return "Resources [id=" + id + ", name=" + name + ", value=" + value + ", dataType=" + dataType + "]";
	}
	
}
