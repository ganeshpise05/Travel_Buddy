package com.qsp.Travellers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Travellers.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
