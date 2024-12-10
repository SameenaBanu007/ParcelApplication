package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tracking {

	@Id	  
	private String trackingNumber; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parcel_id")
	private Parcel parcel;

	public Tracking(){

	}

	public Tracking(String trackingNumber, Parcel parcel) {
		super();
		this.trackingNumber = trackingNumber;
		this.parcel = parcel;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}




}
