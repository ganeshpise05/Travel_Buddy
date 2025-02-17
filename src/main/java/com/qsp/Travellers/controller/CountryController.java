package com.qsp.Travellers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Travellers.dto.ResponseStructure;
import com.qsp.Travellers.entity.Country;
import com.qsp.Travellers.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService service;
	
	@PostMapping("/saveCountry")
	public ResponseEntity<ResponseStructure<Country>> saveCountry(@RequestBody Country country){
		return service.saveCountry(country);
	}
	
	@GetMapping("/findCountry/{id}")
	public ResponseEntity<ResponseStructure<Country>> findCountry(@PathVariable long id){
		return service.findCountryById(id);
	}
	
}