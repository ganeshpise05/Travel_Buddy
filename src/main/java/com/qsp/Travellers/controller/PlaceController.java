package com.qsp.Travellers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Travellers.dto.ResponseStructure;
import com.qsp.Travellers.entity.Place;
import com.qsp.Travellers.service.PlaceService;

@RestController
public class PlaceController {

	@Autowired
	private PlaceService service;
	
	@PostMapping("/savePlace/{id}")
	public ResponseEntity<ResponseStructure<Place>> savePlace(@RequestBody Place place, @PathVariable long id){
		return service.savePlace(place, id);
	}
}