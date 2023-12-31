package com.hiba.services.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.services.model.Student;
import com.hiba.services.services.StudentSearchRepositoryImpl;
import com.hiba.services.services.StudentService;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

	private final StudentService studentService;

	private final StudentSearchRepositoryImpl searchRepository;

	public StudentController(StudentService studentService, StudentSearchRepositoryImpl searchRepository) {
	        this.studentService = studentService;
	        this.searchRepository =searchRepository;
	    }

	@GetMapping("/findStudent/{Id}")
	public Optional<Student> getAllNotices(@PathVariable String Id) {
		return studentService.getByStudentId(Id);
	}

	// posts/java
	@GetMapping("/searchByStudentRoleNo/{text}")
	@ResponseBody
	public List<Student> search(@PathVariable String text) {
		System.out.println("findByRollNo text = "+text);
		return searchRepository.findByRollNo(text);
	}

	
	  @PostMapping("/save") public Student saveStudent(@RequestBody Student
	  student) {
	  
	 return studentService.SaveStudentDetails(student);
	  
	  }
	 

}
