package com.erp.model;

public class KeyValueModel {
	private String identifier;
	private String key;
	private String value;
	public KeyValueModel(String identifier,String key, String value) {
		this.key=key;
		this.value=value;
		this.identifier=identifier;
	}
	public KeyValueModel() {}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
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
	@Override
	public String toString() {
		return "KeyValueModel [identifier=" + identifier + ", key=" + key + ", value=" + value + "]";
	}
	
	
}
