package com.poc.topicexchange.models;

import java.io.Serializable;

public class Car implements Serializable{

	private static final long serialVersionUID = 1L;
	public String key;

    public Car(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
