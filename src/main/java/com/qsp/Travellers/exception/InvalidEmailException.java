package com.qsp.Travellers.exception;

public class InvalidEmailException extends RuntimeException{

	@Override
	public String getMessage() {
		return "Email is not valid";
	}
}
