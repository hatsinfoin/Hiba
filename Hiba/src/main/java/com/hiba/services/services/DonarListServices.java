package com.hiba.services.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.hiba.services.model.DonarList;
import com.hiba.services.model.DonarUsers;
import com.hiba.services.model.DonorDetails;
import com.hiba.services.model.ItemDetails;
import com.hiba.services.repository.DonarListRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class DonarListServices {

	@Autowired
	DonarListRepo donarListRepo;

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	
	public List<DonarList> addNewItemUnderUser(String donorUserID, String pinCode,ItemDetails itemDetails) {

		 List<DonarList> userdonationList = getByPinCode(pinCode);

		for (DonarList userdonationDetails : userdonationList) {
			System.out.println("---- " + userdonationDetails.getPinCodeId());

			if (userdonationDetails.getPinCodeId().equals(pinCode)) {
				List<DonarUsers> donarUsersList = userdonationDetails.getDonarUsers();

				for (DonarUsers donarUser : donarUsersList) {
					if (!donarUser.getDonarUserId().equals(donorUserID)) {
						donarUsersList.remove(donarUser);
						System.out.println("found donorId");
					}else {
						System.out.println("found User adding "+itemDetails);
						donarUser.getItemDetails().add(itemDetails);
					}
				}
				
				

			}

		}
		
		System.out.println("Saving the added user item details");
		SaveDonarList(userdonationList.get(0));
		System.out.println("after Save");
		System.out.println("userdonationList "+userdonationList);
		return userdonationList;
	}
	
	
	public List<DonarList> getUserDonationsByPincode(String donorUserID, String pinCode) {

		 List<DonarList> userdonationList = getByPinCode(pinCode);

		for (DonarList userdonationDetails : userdonationList) {
			System.out.println("---- " + userdonationDetails.getPinCodeId());

			if (userdonationDetails.getPinCodeId().equals(pinCode)) {
				List<DonarUsers> donarUsersList = userdonationDetails.getDonarUsers();

				for (DonarUsers donarUser : donarUsersList) {
					if (!donarUser.getDonarUserId().equals(donorUserID)) {
						donarUsersList.remove(donarUser);
						System.out.println("found donorId");
					}
				}

			}

		}
		
		System.out.println("userdonationList "+userdonationList);
		return userdonationList;
	}

	public List<DonarList> getByPinCode(String pinCode) {

		System.out.println("rollNo = " + pinCode);
		final List<DonarList> donarList = new ArrayList<>();

		MongoDatabase database = client.getDatabase("Hiba");
		MongoCollection<Document> collection = database.getCollection("DonarList");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
				new Document("text",
						// Search5657
						new Document("query", pinCode).append("path", Arrays.asList("pinCodeId"))))));
		System.out.println("after AggregateIterable ");

		result.forEach(doc -> donarList.add(converter.read(DonarList.class, doc)));
		System.out.println("student " + donarList);
		return donarList;

//		Arrays.asList(new Document("$search", 
//			    new Document("text", 
//			    new Document("query", "524002")
//			                .append("path", "pinCodeId"))))

		// return donarListRepo.findById(pinCode);
	}

	public List<DonarList> getAllDonarList() {
		List<DonarList> l = donarListRepo.findAll();
		System.out.println(" Data fetch by repo " + l);

		return l;
	}

	public DonarList SaveDonarList(DonarList donarList) {
		System.out.println("DonarListServices line 22 " + donarList);

		return donarListRepo.save(donarList);
	}

}
