package com.hiba.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "DonorDetails")
public class DonorDetails {

	@Id
	private String id;
	private String donorId;
	private String donorName;
	private String donorAddress1;
	private String donorAddress2;
	private String donorPincode;
	private String donorPhonenumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDonorId() {
		return donorId;
	}
	public void setDonorId(String donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorAddress1() {
		return donorAddress1;
	}
	public void setDonorAddress1(String donorAddress1) {
		this.donorAddress1 = donorAddress1;
	}
	public String getDonorAddress2() {
		return donorAddress2;
	}
	public void setDonorAddress2(String donorAddress2) {
		this.donorAddress2 = donorAddress2;
	}
	public String getDonorPincode() {
		return donorPincode;
	}
	public void setDonorPincode(String donorPincode) {
		this.donorPincode = donorPincode;
	}
	public String getDonorPhonenumber() {
		return donorPhonenumber;
	}
	public void setDonorPhonenumber(String donorPhonenumber) {
		this.donorPhonenumber = donorPhonenumber;
	}
	@Override
	public String toString() {
		return "DonorDetails [id=" + id + ", donorId=" + donorId + ", donorName=" + donorName + ", donorAddress1="
				+ donorAddress1 + ", donorAddress2=" + donorAddress2 + ", donorPincode=" + donorPincode
				+ ", donorPhonenumber=" + donorPhonenumber + "]";
	}
	
	
	
 	
}
