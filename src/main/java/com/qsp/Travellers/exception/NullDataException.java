package com.qsp.Travellers.exception;

public class NullDataException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Data is null";
	}

}
