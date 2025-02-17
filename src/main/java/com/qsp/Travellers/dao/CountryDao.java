package com.qsp.Travellers.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Travellers.entity.Country;
import com.qsp.Travellers.entity.Place;
import com.qsp.Travellers.repository.CountryRepository;

@Repository
public class CountryDao {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public Country saveCountry(Country country) {
		if(country.getPlaces() != null) {
			for(Place place : country.getPlaces()) place.setCountry(country);
		}
		return countryRepository.save(country);
	}
	
	public Country findCountry(long id) {
		Optional<Country> op = countryRepository.findById(id);
		if(op.isPresent()) return op.get();
		return null;
	}

}
