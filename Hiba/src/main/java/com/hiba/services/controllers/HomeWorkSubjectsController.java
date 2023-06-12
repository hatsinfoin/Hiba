package com.hiba.services.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.services.model.HomeWorkSubjects;
import com.hiba.services.services.HomeWorkSubjectsService;

@RestController
@RequestMapping("/v1/homeworkSubjects")
public class HomeWorkSubjectsController {

	private final HomeWorkSubjectsService homeWorkSubjectsService;

	public HomeWorkSubjectsController(HomeWorkSubjectsService homeWorkSubjectsService) {
		this.homeWorkSubjectsService = homeWorkSubjectsService;
	}

	@GetMapping("/getAllhomeworkSubjects")
	public ResponseEntity<List<HomeWorkSubjects>> gethomeWorkSubjects() {
		return ResponseEntity.ok(homeWorkSubjectsService.gethomeWorkSubjects());
	}

	@PostMapping("/savehomeworkSubjects")
	public ResponseEntity<HomeWorkSubjects> saveHomeWorkSubjects(@RequestBody HomeWorkSubjects homeWorkSubjects) {
		System.out.println("HolidayLists  - "+homeWorkSubjects);
		return ResponseEntity.ok(homeWorkSubjectsService.Save(homeWorkSubjects));
	}
	
	@GetMapping("/getholidayByDate/{homeWrokassignedDate}")
	public ResponseEntity<List<HomeWorkSubjects>> gethomeWrokassignedDate(@PathVariable String homeWrokassignedDate) {
		System.out.println("Line 39 -->getholidayByDate");
		return ResponseEntity.ok(homeWorkSubjectsService.gethomeWrokassignedDate(homeWrokassignedDate));
	}

}
