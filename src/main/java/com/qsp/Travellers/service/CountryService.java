
package com.qsp.Travellers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Travellers.dao.CountryDao;
import com.qsp.Travellers.dto.ResponseStructure;
import com.qsp.Travellers.entity.Country;
import com.qsp.Travellers.entity.Place;

@Service
public class CountryService {

	@Autowired
	private CountryDao dao;
	
	public ResponseEntity<ResponseStructure<Country>> saveCountry(Country country){
		Country returnedCountry = dao.saveCountry(country);
		ResponseStructure<Country> res = new ResponseStructure<Country>();
		res.setStatusCode(HttpStatus.CREATED.value());
		res.setMessage("Resorce created successfully");
		res.setData(returnedCountry);
		return new ResponseEntity<ResponseStructure<Country>>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Country>> findCountryById(long id){
		Country returnedCountry = dao.findCountry(id);
		ResponseStructure<Country> res = new ResponseStructure<Country>();
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Resorce retrived successfully");
		res.setData(returnedCountry);
		return new ResponseEntity<ResponseStructure<Country>>(res, HttpStatus.OK);
	}
}
