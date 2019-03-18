package com.poc.elasticsample.models;

import java.io.Serializable;

import io.searchbox.annotations.JestId;
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@JestId
	private String id;
	private String name;
	private String email;
	public User() {	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
