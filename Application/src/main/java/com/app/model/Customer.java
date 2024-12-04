package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Customer {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer customerId; 
	
    private String customerName;	
	
    private String customerSlug;	

    public Customer() {}

	public Customer(String customerName, String customerSlug) {
		super();	
		this.customerName = customerName;
		this.customerSlug = customerSlug;		
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSlug() {
		return customerSlug;
	}

	public void setCustomerSlug(String customerSlug) {
		this.customerSlug = customerSlug;
	}
    
   
}
