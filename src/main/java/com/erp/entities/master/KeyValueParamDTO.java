package com.erp.entities.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PNP_KEY_VALUE_PARAM")
public class KeyValueParamDTO {
	@Override
	public String toString() {
		return "KeyValueParamDTO [name=" + name + ", key=" + key + ", value=" + value + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	private String name;
	private String key;
	private String value;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
