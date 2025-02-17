package com.qsp.Travellers.exception;

public class DataIntegrityException extends RuntimeException {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Duplicate Data found";
	}
}
