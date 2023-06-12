package com.hiba.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hiba.services.model.Student;

public interface StudentRepo extends MongoRepository<Student, String> {
	
	Student findByRollNo(String rollNo);

}
