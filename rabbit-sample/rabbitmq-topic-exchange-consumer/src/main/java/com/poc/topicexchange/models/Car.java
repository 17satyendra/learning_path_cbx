package com.poc.topicexchange.models;


public class Car{

	public String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

	@Override
	public String toString() {
		return "Car [key=" + key + "]";
	}
    
}
