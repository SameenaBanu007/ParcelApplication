package com.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.model.Customer;
import com.app.model.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Integer> {
		
	public List<Parcel> findByCustomerAndOriginCountryIdAndDestinationCountryIdAndWeight
	(Customer customer,String originCountryId, String destinationCountryId, Float weight);
	

}