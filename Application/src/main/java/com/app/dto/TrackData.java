package com.app.dto;

import java.time.LocalDate;

public class TrackData {
	
	private Integer customerId;
	
	private String customerName;	
	
    private String customerSlug;
    
    private String originCountryId;
	
	private String destinationCountryId;
	
	private Float  weight;
	
	private LocalDate createdAt;
	
	public TrackData() {
		
	}

	public TrackData(Integer customerId, String customerName, String customerSlug, String browserVersion,
			String originCountryId, String destinationCountryId, Float weight, LocalDate createdAt) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSlug = customerSlug;
		this.originCountryId = originCountryId;
		this.destinationCountryId = destinationCountryId;
		this.weight = weight;
		this.createdAt = createdAt;
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

	
	public String getOriginCountryId() {
		return originCountryId;
	}

	public void setOriginCountryId(String originCountryId) {
		this.originCountryId = originCountryId;
	}

	public String getDestinationCountryId() {
		return destinationCountryId;
	}

	public void setDestinationCountryId(String destinationCountryId) {
		this.destinationCountryId = destinationCountryId;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}


	

}
