package com.qsp.Travellers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Travellers.entity.Traveller;

public interface TravellerRepository extends JpaRepository<Traveller, Long> {

	Traveller findByNameAndPassword(String name, String passrd);
}
