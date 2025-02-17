package com.qsp.Travellers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Travellers.dto.ResponseStructure;
import com.qsp.Travellers.entity.Traveller;
import com.qsp.Travellers.service.TravellerService;

@RestController
public class TravellerController {
	
	@Autowired
	private TravellerService service;

	@PostMapping("/reg")
	public ResponseEntity<ResponseStructure<Traveller>> saveTraveller(@RequestBody Traveller traveller){
		return service.saveTraveller(traveller);
	}
	
	@GetMapping("/login/{name}/{password}")
	public  ResponseEntity<ResponseStructure<Traveller>> travellerLogin(@PathVariable String name, @PathVariable String password){
		return service.loginTraveller(name, password);
	}
	
	@PutMapping("/saveTravellerWithCountry/{cid}/{tid}")
	public ResponseEntity<ResponseStructure<Traveller>> saveTravellerWithCountry(@PathVariable long cid, @PathVariable long tid){
		return service.saveTravellerWithCountry(cid, tid);	
	}
	
	
	
	
	
	
	
	
	
	
}
