package com.hiba.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.hiba.services.model.DonarList;

public interface DonarListRepo extends MongoRepository<DonarList,String>{
	
	

}
