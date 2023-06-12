package com.hiba.services.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.services.model.DonarList;
import com.hiba.services.model.NoticeBoardDetails;
import com.hiba.services.model.Student;
import com.hiba.services.services.DonarListServices;
import com.hiba.services.services.StudentSearchRepositoryImpl;
import com.hiba.services.services.StudentService;

@RestController
@RequestMapping("/v1/donarList")
public class DonarListController {

	
	@Autowired
	private final DonarListServices donarListServices;

	public DonarListController(DonarListServices donarListServices) {
	        
	        this.donarListServices =donarListServices;
	    }

	@GetMapping("/donerListByPincode/{pincode}")
	public List<DonarList> getAllDonerListByPincode(@PathVariable String pincode) {
		return donarListServices.getByPinCode(pincode);
	}
	
	@GetMapping("/getAlldonerLists")
	public List<DonarList> getAllDonerList() {
		return donarListServices.getAllDonarList();
	}
	
	 @PostMapping("/saveDonearList")
	    public ResponseEntity<DonarList> saveNoticeBoard(@RequestBody  DonarList donarList ){
		 System.out.println("in Controler "+donarList);
	    		return ResponseEntity.ok(donarListServices.SaveDonarList(donarList));
	    }

}
