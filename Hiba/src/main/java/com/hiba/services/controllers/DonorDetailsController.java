package com.hiba.services.controllers;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.services.model.DonarList;
import com.hiba.services.model.DonorDetails;
import com.hiba.services.services.DonorDetailsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/donorDetails")
public class DonorDetailsController {

    private final DonorDetailsService donorDetailsService;

    public DonorDetailsController(DonorDetailsService donorDetailsService) {
        this.donorDetailsService = donorDetailsService;
    }

    @GetMapping("/getAlldonorDetails")
    public ResponseEntity<List<DonorDetails>> getAllDonorDetails(){
     		return ResponseEntity.ok(donorDetailsService.getAllDonorDetails());
    }
    
    @PostMapping("/saveDonorDetails")
    public ResponseEntity<DonorDetails> saveDonorDetails(@RequestBody  DonorDetails donorDetails ){
    	System.out.println("in saveDonorDetails");	
    	System.out.println(donorDetails);
    	DonorDetails d = donorDetailsService.saveDonorDetails(donorDetails);
    	System.out.println("saved Details are "+d);
    	return ResponseEntity.ok(d);
    }
    
	@GetMapping("/donerUserDetaisByUserID/{donorId}")
	public DonorDetails getdonerUserDetaisByUserID(@PathVariable String donorId) {
		System.out.println("findbyDonerId donorId "+donorId);
		return donorDetailsService.findbyDonerId(donorId);
	}

}
