package com.hiba.services.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "DonarList")
public class DonarList {
	
	@Id
	private String id;
	
	private String pinCodeId;
	
	private List<DonarUsers> donarUsers;
	 
	
	
	

}
