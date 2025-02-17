package com.qsp.Travellers.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long passPortNumber;
	private String nationality;
	private String gender;
	
	private LocalDate dateOfIssue; //yyyy-mm-dd
	private LocalDate dateOfExpiry;
	
	@JsonIgnore
	@OneToOne(mappedBy = "passport")
	private Traveller traveller;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPassPortNumber() {
		return passPortNumber;
	}

	public void setPassPortNumber(long passPortNumber) {
		this.passPortNumber = passPortNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public LocalDate getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(LocalDate dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}
	
	
}
