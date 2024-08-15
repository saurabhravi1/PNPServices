package com.erp.helper;

public class ResponseMessage {
	private String type;
	private String message;
	
	public final String success="alert-success";
	public final String error="alert-error";
	
	public ResponseMessage(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	public ResponseMessage() {
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseMessage [type=" + type + ", message=" + message + "]";
	}
	
	
	
}
