package com.hiba.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hiba.services.model.NoticeBoardDetails;


public interface NoticeBoardRepo extends MongoRepository<NoticeBoardDetails,String>
{


}



