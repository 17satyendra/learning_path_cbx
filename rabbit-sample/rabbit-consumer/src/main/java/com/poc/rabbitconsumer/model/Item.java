package com.poc.rabbitconsumer.model;

public class Item {
	private String name;
    private Integer quantity;
public Item() {
}
    public Item(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	@Override
	public String toString() {
		return "Item [name=" + name + ", quantity=" + quantity + "]";
	}
    
}
