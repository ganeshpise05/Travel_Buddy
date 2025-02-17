package com.qsp.Travellers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Travellers.dao.PlaceDao;
import com.qsp.Travellers.dto.ResponseStructure;
import com.qsp.Travellers.entity.Place;

@Service
public class PlaceService {
	@Autowired
	private PlaceDao dao;
	
	public ResponseEntity<ResponseStructure<Place>> savePlace(Place place, long id){
		Place returnedPlace = dao.savePlace(place, id);
		ResponseStructure<Place> res = new ResponseStructure<Place>();
		res.setStatusCode(HttpStatus.CREATED.value());
		res.setMessage("Resorce created successfully");
		res.setData(returnedPlace);
		return new ResponseEntity<ResponseStructure<Place>>(res, HttpStatus.CREATED);
	}

}
