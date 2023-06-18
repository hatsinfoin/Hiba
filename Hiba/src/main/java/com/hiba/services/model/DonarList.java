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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPinCodeId() {
		return pinCodeId;
	}

	public void setPinCodeId(String pinCodeId) {
		this.pinCodeId = pinCodeId;
	}

	public List<DonarUsers> getDonarUsers() {
		return donarUsers;
	}

	public void setDonarUsers(List<DonarUsers> donarUsers) {
		this.donarUsers = donarUsers;
	}
	 
	
	
	

}
