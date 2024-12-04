package com.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Parcel {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY) 	
    private Integer parcelId; 
	
	private String originCountryId;
	
	private String destinationCountryId;
	
	private Float  weight;
	
	private LocalDateTime createdAt;
	
	private String trackingNumber;
	
	private Integer count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Transient
	private Integer customerId;
	
	public Parcel() {
		
	}

	public Parcel(String originCountryId, String destinationCountryId, Float weight, LocalDateTime createdAt,
			Integer customerId, String trackingNumber, Integer count) {
		super();
		this.originCountryId = originCountryId;
		this.destinationCountryId = destinationCountryId;
		this.weight = weight;
		this.createdAt = createdAt;		
		this.trackingNumber = trackingNumber;
		this.count = count;
	}

	public Integer getParcelId() {
		return parcelId;
	}

	public void setParcelId(Integer parcelId) {
		this.parcelId = parcelId;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	
	
}
