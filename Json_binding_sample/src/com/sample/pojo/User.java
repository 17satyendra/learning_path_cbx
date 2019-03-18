package com.sample.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
@JsonPropertyOrder(alphabetic=true)
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	@JsonAlias({ "fName", "f_name" })
	private String name;
	
	private String contact;
	private List<Address> addresses;
	
	public User() {	}
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
	@JsonValue
	public String getContact() {
		return contact;
	}
	//@JsonIgnore
	public void setContact(String contact) {
		this.contact = contact;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + ", addresses=" + addresses + "]";
	}
}
