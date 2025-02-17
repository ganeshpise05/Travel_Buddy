package com.qsp.Travellers.exception;

public class NoResouceException extends RuntimeException {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "The resource which you want to find is found";
	}
}
