package com.app.dto;

public class TrackingDetails {

	private String createdAt;

	private String trackingNumber;

	public TrackingDetails(String createdAt, String trackingNumber) {
		super();
		this.createdAt = createdAt;
		this.trackingNumber = trackingNumber;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}



}
