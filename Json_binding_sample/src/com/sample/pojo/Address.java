package com.sample.pojo;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String city;
	private String pinCode;
	
	public Address() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", pinCode=" + pinCode + "]";
	}
}
