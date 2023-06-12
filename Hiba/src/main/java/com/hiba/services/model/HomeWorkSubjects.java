package com.hiba.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "HomeWorkSubjects")
public class HomeWorkSubjects {
	
	@Id
	private String id;
	private String homeWorkSubjectsId;
	private String branchName;
	private String Subjects[];
	private String hwGivenByTeacher;
	private String homeWrokassignedDate;
	private String homeWrokCompletedDate;
	
	
	

}
