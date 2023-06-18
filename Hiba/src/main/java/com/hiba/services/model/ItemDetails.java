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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String[] getItemPictures() {
		return itemPictures;
	}
	public void setItemPictures(String[] itemPictures) {
		this.itemPictures = itemPictures;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItemExpire() {
		return itemExpire;
	}
	public void setItemExpire(String itemExpire) {
		this.itemExpire = itemExpire;
	}
	public String[] getInterestedCandidates() {
		return interestedCandidates;
	}
	public void setInterestedCandidates(String[] interestedCandidates) {
		this.interestedCandidates = interestedCandidates;
	}
	
	
	

}
