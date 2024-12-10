package com.app.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TrackData {

	private UUID customerId;

	private String customerName;	

	private String customerSlug;

	private String originCountryId;

	private String destinationCountryId;

	private Float  weight;

	private OffsetDateTime createdAt;

	public TrackData() {

	}

	public TrackData(UUID customerId, String customerName, String customerSlug, String browserVersion,
			String originCountryId, String destinationCountryId, Float weight, OffsetDateTime createdAt) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSlug = customerSlug;
		this.originCountryId = originCountryId;
		this.destinationCountryId = destinationCountryId;
		this.weight = weight;
		this.createdAt = createdAt;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
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

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}




}
