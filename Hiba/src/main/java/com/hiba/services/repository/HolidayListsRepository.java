package com.hiba.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hiba.services.model.HolidayLists;

public interface HolidayListsRepository extends MongoRepository<HolidayLists, String> {

}
