package com.erp.model;

public class AddressMasterModel {
	@Override
	public String toString() {
		return "AddressMasterModel [id=" + id + ", Area=" + Area + ", zipcode=" + zipcode + ", city=" + city
				+ ", state=" + state + ", country=" + country + "]";
	}
	private int id;
	private String Area;
	private int zipcode;
	private String city;
	private String state;	
	private String country;
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
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AddressMasterModel) {
			if(obj!=null) {
				AddressMasterModel obj1 = (AddressMasterModel)obj;
				if(
						obj1.getId()==this.getId() 
						&& obj1.getArea().equals(this.getArea())
						&& obj1.getCity().equals(this.getCity())
						&& obj1.getCountry().equals(this.getCountry())
						&& obj1.getState().equals(this.getState())
						&& obj1.getZipcode()==this.getZipcode()
						)
					return true;
			}
		}
		return false;
	}
	
}
