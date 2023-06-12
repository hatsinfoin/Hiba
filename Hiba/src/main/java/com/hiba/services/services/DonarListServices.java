package com.hiba.services.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiba.services.model.DonarList;
import com.hiba.services.repository.DonarListRepo;

@Service
public class DonarListServices {

	@Autowired
	DonarListRepo donarListRepo;

	public Optional<DonarList> getByPinCode(String pinCode) {
		return donarListRepo.findById(pinCode);
	}
	
	public List<DonarList> getAllDonarList() {
		return donarListRepo.findAll();
	}

	public DonarList SaveDonarList(DonarList donarList) {
		System.out.println("DonarListServices line 22 "+donarList);

		return donarListRepo.save(donarList);
	}

}
