package com.hiba.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.hiba.services.model.HomeWorkSubjects;
import com.hiba.services.repository.HomeWorkSubjectsRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Service
public class HomeWorkSubjectsService {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;
	
	@Autowired
	HomeWorkSubjectsRepo homeWorkSubjectsRepo;

	public List<HomeWorkSubjects> gethomeWorkSubjects() {
		return homeWorkSubjectsRepo.findAll();
	}

	public HomeWorkSubjects Save(HomeWorkSubjects homeWorkSubjects) {
		return homeWorkSubjectsRepo.save(homeWorkSubjects);
	}
	
	public List<HomeWorkSubjects> saveAllhomeWorkSubjects(List<HomeWorkSubjects> holidayLists) {
		return homeWorkSubjectsRepo.saveAll(holidayLists);
	}

	public  List<HomeWorkSubjects> gethomeWrokassignedDate(String homeWrokassignedDate) {
		System.out.println("Line -->46  class HomeWorkSubjectsService -->  gethomeWrokassignedDate()" );


		System.out.println("holidayDate = " + homeWrokassignedDate);
		final List<HomeWorkSubjects> student = new ArrayList<>();

		MongoDatabase database = client.getDatabase("schoolcluster");
		MongoCollection<Document> collection = database.getCollection("HomeWorkSubjects");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    		// Search5657
			    new Document("query",homeWrokassignedDate)
			                .append("path",  Arrays.asList("homeWrokassignedDate"))))));
		System.out.println("after AggregateIterable ");
	
		
		
		result.forEach(doc -> student.add(converter.read(HomeWorkSubjects.class, doc)));
		System.out.println("student " + student);
		return student;
		 
	
	}
	
	
	

}
