package com.qsp.Travellers.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Travellers.entity.Country;
import com.qsp.Travellers.entity.Place;
import com.qsp.Travellers.repository.PlaceRepository;

@Repository
public class PlaceDao {

	@Autowired
	private PlaceRepository placeRepository;
	
	@Autowired
	private CountryDao countryDao;
	
	public Place savePlace(Place place, long id) {
		Country country = countryDao.findCountry(id);
		if(country != null) {
			place.setCountry(country);
			return placeRepository.save(place);
		}
		return null;
	}
}
