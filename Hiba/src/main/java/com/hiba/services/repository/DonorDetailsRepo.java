package com.hiba.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hiba.services.model.DonorDetails;
 
public interface DonorDetailsRepo extends MongoRepository<DonorDetails, String> {
	
 
}
