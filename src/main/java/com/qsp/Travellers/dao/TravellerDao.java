package com.qsp.Travellers.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Travellers.entity.Country;
import com.qsp.Travellers.entity.Passport;
import com.qsp.Travellers.entity.Place;
import com.qsp.Travellers.entity.Traveller;
import com.qsp.Travellers.repository.CountryRepository;
import com.qsp.Travellers.repository.PassportRepository;
import com.qsp.Travellers.repository.PlaceRepository;
import com.qsp.Travellers.repository.TravellerRepository;
import com.qsp.Travellers.service.EmailValidator;
import com.qsp.Travellers.service.MailSenderService;

@Repository
public class TravellerDao {

	@Autowired
	private TravellerRepository travellerRepository;
	
	@Autowired
	private PassportRepository passportRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private PlaceRepository placeRepository;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	
	public Traveller saveTraveller(Traveller traveller) {
//		Passport passport = traveller.getPassport();
//		passportRepository.save(passport);
		List<Country> countries = traveller.getCountries();
		if(countries != null) {
			for(Country c : countries) {
//				List<Place> places = c.getPlaces();
//				for(Place p : places) placeRepository.save(p);
				countryDao.saveCountry(c);
			}
		}
		
		
		Traveller returnedTraveller =  travellerRepository.save(traveller);
		String subject = "Welcome to traveller app";
		String body = String.format("Dear %s, \n\n Thank you for registering with us.\n\nBest regards \nTraveller app team.", returnedTraveller.getName());
		
		mailSenderService.sendEmail(returnedTraveller.getEmail(), subject, body);
		return returnedTraveller;
	}
	
	public Traveller loginTraveller(String name, String password) {
		Traveller traveller = travellerRepository.findByNameAndPassword(name, password);
		if( traveller != null) return traveller;
		return null;
	}
	
	
	public Traveller saveTravellerWithCountry(long cid, long tid) {
		Country country = countryDao.findCountry(cid);
		Optional<Traveller> op = travellerRepository.findById(tid);
		
		if(country != null && op.isPresent()) {
			Traveller traveller = op.get(); 
			List<Country> countries = traveller.getCountries();
			countries.add(country);
			traveller.setCountries(countries);
			return travellerRepository.save(traveller);
		}
		return null;
	}
	
}
