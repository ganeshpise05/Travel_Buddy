package com.qsp.Travellers.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.qsp.Travellers.dto.ResponseStructure;

@RestControllerAdvice
public class TravellerExceptionHander {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ResponseStructure<String>> dupliacteData(DataIntegrityViolationException e){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatusCode(HttpStatus.BAD_REQUEST.value());
		res.setMessage("Duplicate data not allowed");
		res.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullDataException.class)
	public ResponseEntity<ResponseStructure<String>> nullData(NullDataException e){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatusCode(HttpStatus.BAD_REQUEST.value());
		res.setMessage("Resource is null");
		res.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noResourceFound(NoResourceFoundException e){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage("Resource not found");
		res.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ResponseStructure<String>> methodNotAllowed(HttpRequestMethodNotSupportedException e){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
		res.setMessage("Method is not allowed");
		res.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ResponseStructure<String>> emailValidator(InvalidEmailException e){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatusCode(HttpStatus.BAD_REQUEST.value());
		res.setMessage("Email formate missmatch");
		res.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.BAD_REQUEST);
	}
	
}
