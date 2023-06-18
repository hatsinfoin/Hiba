package com.hiba.services.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DonarUsers {	
	private String donarUserId;
	
	private List<ItemDetails> itemDetails;

	public String getDonarUserId() {
		return donarUserId;
	}

	public void setDonarUserId(String donarUserId) {
		this.donarUserId = donarUserId;
	}

	public List<ItemDetails> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	} 
	
	
	

}
