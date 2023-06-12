package com.hiba.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hiba.services.model.BranchDetails;

public interface BranchDetailsRepo extends MongoRepository<BranchDetails,String>{
	
	

}
