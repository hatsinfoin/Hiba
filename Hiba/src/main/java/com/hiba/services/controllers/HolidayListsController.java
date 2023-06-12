package com.hiba.services.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.services.model.HolidayLists;
import com.hiba.services.services.HolidayListsServices;

@RestController
@RequestMapping("/v1/holidayLists")
public class HolidayListsController {

	private final HolidayListsServices holidayListsServices;

	public HolidayListsController(HolidayListsServices holidayListsServices) {
		this.holidayListsServices = holidayListsServices;
	}

	@GetMapping("/getAllNotices")
	public ResponseEntity<List<HolidayLists>> getAllHolidays() {
		return ResponseEntity.ok(holidayListsServices.getAllHolidays());
	}

	@PostMapping("/saveHolidaysList")
	public ResponseEntity<HolidayLists> SaveHolidaysLists(@RequestBody HolidayLists holidayLists) {
		System.out.println("HolidayLists  - "+holidayLists);
		return ResponseEntity.ok(holidayListsServices.SaveHolidaysLists(holidayLists));
	}
	
	@GetMapping("/getholidayByDate/{holidayDate}")
	public ResponseEntity<List<HolidayLists>> getholidayByDate(@PathVariable String holidayDate) {
		System.out.println("Line 39 -->getholidayByDate");
		return ResponseEntity.ok(holidayListsServices.getholidayByDate(holidayDate));
	}

}
