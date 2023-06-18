package com.hiba.services.services;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiba.services.model.DonorDetails;
import com.hiba.services.repository.DonorDetailsRepo;

@Service
public class DonorDetailsService {

	@Autowired
	DonorDetailsRepo donorDetailsRepo;

	public List<DonorDetails> getAllDonorDetails() {
		return donorDetailsRepo.findAll();
	}

	public DonorDetails saveDonorDetails(DonorDetails donorDetails) {
		donorDetailsRepo.save(donorDetails);
		return findbyDonerId(donorDetails.getDonorId());
	}

	public DonorDetails findbyDonerId(String donorId) {

		System.out.println("Service findbyDonerId " + donorId);
		ListIterator<DonorDetails> it = donorDetailsRepo.findAll().listIterator();

		for (DonorDetails s : donorDetailsRepo.findAll()) {
			System.out.println("---- " + s.getDonorId());
			if (s.getDonorId().equals(donorId)) {
				System.out.println("found donorId");
				return s;
			}
		}

		return null;
	}

}
