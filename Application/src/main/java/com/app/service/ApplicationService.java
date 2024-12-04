package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dto.TrackData;
import com.app.dto.TrackingDetails;
import com.app.model.Customer;
import com.app.model.Parcel;
import com.app.model.Tracking;
import com.app.repository.CustomerRepository;
import com.app.repository.ParcelRepository;
import com.app.repository.TrackingRepository;

import jakarta.transaction.Transactional;


@Service
public class ApplicationService {   
    
    @Autowired
    private CustomerRepository customerRepository; 
    
    @Autowired
    private ParcelRepository parcelRepository;   
    
    @Autowired
    private TrackingRepository  trackingRepository;

    
    public Customer createCustomer(Customer customer) {    	
    	return customerRepository.save(customer);    
    	
    }

    @Transactional
	public Parcel createParcel(Parcel parcel) {	
    	LocalDateTime date = LocalDateTime.now();
    	
    	Customer cust = customerRepository.findById(parcel.getCustomerId()).get();
    	
		parcel.setCreatedAt(date);	
		parcel.setCount(1);
		parcel.setCustomer(cust);
		Parcel parc = parcelRepository.save(parcel);
		
		String trackingNumber = getTrackingStr(parc,1);		
		parc.setTrackingNumber(trackingNumber);
		
		Tracking tracking = new Tracking(trackingNumber, parcel);
		trackingRepository.save(tracking);
		
		return parcelRepository.save(parc);	
		
		
	}

    @Transactional
	public TrackingDetails processNextTrackingNumber(TrackData data) {
    	
		TrackingDetails trackingDetails = null;
		
		Customer cust = customerRepository.findById(data.getCustomerId()).get();
		
		List<Parcel> parcels = 
				parcelRepository.findByCustomerAndOriginCountryIdAndDestinationCountryIdAndWeight
		        (cust,data.getOriginCountryId(),data.getDestinationCountryId(),data.getWeight());
		
		for(Parcel parcel : parcels) {
			if(parcel.getCustomer().getCustomerId().equals(cust.getCustomerId())) {
				int count = parcel.getCount()+1;
				parcel.setCount(count);	
				
				String trackingNumber = getTrackingStr(parcel,count);	
				parcel.setTrackingNumber(trackingNumber);	
				
				LocalDateTime trackingDate  = LocalDateTime.now();
				parcel.setCreatedAt(trackingDate);
				parcelRepository.save(parcel);
				
				Tracking tracking = new Tracking(trackingNumber, parcel);
				trackingRepository.save(tracking);
				
				trackingDetails = new  TrackingDetails( trackingDate.toString(),  trackingNumber);
				
				break;
			}
		}	
		    
		   

		return trackingDetails;
		
	}

	 
	public String getTrackingStr(Parcel parcel,Integer count) {		
	
		Customer customer = parcel.getCustomer();
		
		StringJoiner sj = new StringJoiner("-");
		sj.add(customer.getCustomerId().toString());
		sj.add(customer.getCustomerName());
		sj.add(customer.getCustomerSlug());
		sj.add(parcel.getParcelId().toString());
		sj.add(parcel.getOriginCountryId());
		sj.add(parcel.getDestinationCountryId());
		sj.add(parcel.getWeight().toString());
		sj.add(parcel.getCreatedAt().toString());	
		sj.add(count.toString());
		
		String trackingNumber = sj.toString();
		
		return trackingNumber;
		
	}
	
}
