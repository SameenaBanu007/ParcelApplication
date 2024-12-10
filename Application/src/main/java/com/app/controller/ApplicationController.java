package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TrackData;
import com.app.dto.TrackingDetails;
import com.app.model.Customer;
import com.app.model.Parcel;
import com.app.service.ApplicationService;


@RestController
@RequestMapping("/application")
public class ApplicationController {

	@Autowired
	private ApplicationService service;   

	@GetMapping("/next-tracking-number")
	public ResponseEntity<TrackingDetails> processNextTrackingNumber(@RequestBody  TrackData data) {
		TrackingDetails tractingNumber =  service.processNextTrackingNumber(data);
		return tractingNumber != null ? ResponseEntity.ok(tractingNumber) : ResponseEntity.notFound().build();
	}

	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) { 
		Customer cust = service.createCustomer(customer);
		return cust != null ? ResponseEntity.ok(cust) : ResponseEntity.notFound().build();
	}

	@PostMapping("/createParcel")
	public ResponseEntity<Parcel> createParcel(@RequestBody Parcel parcel) { 
		Parcel parc = service.createParcel(parcel);    
		return parc != null ? ResponseEntity.ok(parc) : ResponseEntity.notFound().build();
	}

}
