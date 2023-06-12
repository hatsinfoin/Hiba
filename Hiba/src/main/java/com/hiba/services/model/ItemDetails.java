package com.hiba.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ItemDetails {
	
	@Id
	private String id;
	private String itemid;
	private String itemPictures [];
	private String itemTitle;
	private String description;
	private String status;
	private String itemExpire;
	private String interestedCandidates [];
	
	
	

}
