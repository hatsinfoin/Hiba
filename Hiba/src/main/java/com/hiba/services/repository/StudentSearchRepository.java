package com.hiba.services.repository;

import java.util.List;

import com.hiba.services.model.Student;

public interface StudentSearchRepository {
	
	List<Student> findByRollNo(String rollNo);

}
