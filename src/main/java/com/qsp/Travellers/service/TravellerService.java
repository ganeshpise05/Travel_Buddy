package com.qsp.Travellers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.qsp.Travellers.dao.TravellerDao;
import com.qsp.Travellers.dto.ResponseStructure;
import com.qsp.Travellers.entity.Traveller;
import com.qsp.Travellers.exception.InvalidEmailException;
import com.qsp.Travellers.exception.NullDataException;

@Service
public class TravellerService {

	@Autowired
	private TravellerDao travellerDao;
	
	public ResponseEntity<ResponseStructure<Traveller>> saveTraveller(Traveller traveller){
		
		if(EmailValidator.isValidEmail(traveller.getEmail())) {
			Traveller retunredTraveller = travellerDao.saveTraveller(traveller);
			ResponseStructure<Traveller> res = new ResponseStructure<Traveller>();
			res.setStatusCode(HttpStatus.CREATED.value());
			res.setMessage("Resource created successfully");
			res.setData(retunredTraveller);
			return new ResponseEntity<ResponseStructure<Traveller>> (res, HttpStatus.CREATED);
		}
		throw new InvalidEmailException();
	}
	
	public ResponseEntity<ResponseStructure<Traveller>> loginTraveller(String name, String password){
		Traveller retunredTraveller = travellerDao.loginTraveller(name,password);
		if(retunredTraveller != null) {
			ResponseStructure<Traveller> res = new ResponseStructure<Traveller>();
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Resource Retrieved successfully");
			res.setData(retunredTraveller);
			return new ResponseEntity<ResponseStructure<Traveller>> (res, HttpStatus.OK);
		}
		throw new NullDataException();
	}
	
	public ResponseEntity<ResponseStructure<Traveller>> saveTravellerWithCountry(long cid, long tid){
		Traveller retunredTraveller = travellerDao.saveTravellerWithCountry(cid, tid);
		if(retunredTraveller != null) {
			ResponseStructure<Traveller> res = new ResponseStructure<Traveller>();
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Resource Updated successfully");
			res.setData(retunredTraveller);
			return new ResponseEntity<ResponseStructure<Traveller>> (res, HttpStatus.OK);
		}
		throw new NullDataException();
	}
}
