package entities;

import java.time.LocalDateTime;

public class Product {
	
	int id;
	String name;
	String description;
	Double price;
	int stock;
	Boolean shippingIncluded;
	LocalDateTime disabledOn; 
	
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
		if(!name.isEmpty()) {
		this.name = name;}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if(!description.isEmpty()) {
		this.description = description;}
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		if(price>=0) {
		this.price = price;}
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Boolean getShippingIncluded() {
		return shippingIncluded;
	}
	public void setShippingIncluded(Boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	
	public LocalDateTime getDisabledOn() {
		return disabledOn;
	}
	public void setDisabledOn(LocalDateTime disabledOn) {
		this.disabledOn = disabledOn;
	}
	
	@Override
	public String toString() {
		return "[id:"+id+" | name:"+name+" | description:"+description+" | price:"+price+" | stock:"+stock+" | shippingIncluded:"+shippingIncluded+" | disabledOn:"+disabledOn+"]";
	}
	
	
}
