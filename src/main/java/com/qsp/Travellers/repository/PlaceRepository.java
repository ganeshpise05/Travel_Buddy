package com.qsp.Travellers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Travellers.entity.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
