package com.hiba.services.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.services.model.DonarList;
import com.hiba.services.model.ItemDetails;
import com.hiba.services.model.NoticeBoardDetails;
import com.hiba.services.model.Student;
import com.hiba.services.services.DonarListServices;
import com.hiba.services.services.StudentSearchRepositoryImpl;
import com.hiba.services.services.StudentService;
@CrossOrigin("*")
@RestController
@RequestMapping("/v1/donarList")
public class DonarListController {

	@Autowired
	private final DonarListServices donarListServices;

	public DonarListController(DonarListServices donarListServices) {

		this.donarListServices = donarListServices;
	}

	@GetMapping("/donerListByPincode/{pincode}")
	public List<DonarList> getAllDonerListByPincode(@PathVariable String pincode) {
		return donarListServices.getByPinCode(pincode);
	}

	@GetMapping("/getUserDonationsByPincode/{pincode}/{donorUserID}")
	public List<DonarList> getUserDonationsByPincode(@PathVariable String pincode ,@PathVariable String donorUserID) {
		System.out.println("in getUserDonationsByPincode "+donorUserID +"   "+pincode);
		return donarListServices.getByPinCode(pincode);
	}
	
	@GetMapping("/getAlldonerLists")
	public List<DonarList> getAllDonerList() {
		System.out.println(" in getAlldonerLists");

		return donarListServices.getAllDonarList();
	}

	@PostMapping("/saveDonearList")
	public ResponseEntity<DonarList> saveNoticeBoard(@RequestBody DonarList donarList) {
		System.out.println("in Controler " + donarList);
		return ResponseEntity.ok(donarListServices.SaveDonarList(donarList));
	}

	@PostMapping("/updateDonearList/{pincode}")
	public ResponseEntity<DonarList> updateNoticeBoard(@PathVariable String pincode) {
		List<DonarList> donarList = donarListServices.getByPinCode(pincode);
		DonarList d = donarList.get(0);
		d.getDonarUsers().get(0).getItemDetails().get(0).setItemTitle("Java Updated Value ");
		return ResponseEntity.ok(donarListServices.SaveDonarList(d));
	}
	
	@PostMapping("/addInterestedCandidate/{pincode}/{donorUserID}/{itemid}/{interestedUserId}")
	public ResponseEntity<DonarList> addNewItemUnderUser(@PathVariable String pincode,@PathVariable String donorUserID,@PathVariable String itemid,@PathVariable String interestedUserId) {
		System.out.println("In Controler addNewItemUnderUser donorUserID "+donorUserID);
		System.out.println("In Controler addNewItemUnderUser pincode "+pincode);
		System.out.println("In Controler addNewItemUnderUser itemid "+itemid);
		System.out.println("In Controler addNewItemUnderUser InterestedUserId "+interestedUserId);
		
		List<DonarList> donarList = donarListServices.addInterestedCandidate(pincode,donorUserID,itemid,interestedUserId);
		DonarList d = donarList.get(0);
		d.getDonarUsers().get(0).getItemDetails().get(0).setItemTitle("Java Updated Value ");
		return ResponseEntity.ok(donarListServices.SaveDonarList(d));
	}
	
	@PostMapping("/addNewItemUnderUser/{pincode}/{donorUserID}")
	public ResponseEntity<DonarList> addNewItemUnderUser(@PathVariable String pincode,@PathVariable String donorUserID,@RequestBody ItemDetails itemDetails) {
		System.out.println("In Controler addNewItemUnderUser donorUserID "+donorUserID);
		System.out.println("In Controler addNewItemUnderUser pincode "+pincode);
		System.out.println("In Controler addNewItemUnderUser itemDetails "+itemDetails);
		
		List<DonarList> donarList = donarListServices.addNewItemUnderUser(pincode,donorUserID,itemDetails);
		DonarList d = donarList.get(0);
		d.getDonarUsers().get(0).getItemDetails().get(0).setItemTitle("Java Updated Value ");
		return ResponseEntity.ok(donarListServices.SaveDonarList(d));
	}
	
}
