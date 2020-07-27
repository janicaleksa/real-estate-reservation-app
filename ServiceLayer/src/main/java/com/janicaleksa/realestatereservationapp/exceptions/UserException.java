package com.janicaleksa.realestatereservationapp.exceptions;

public class UserException extends RuntimeException {

	public UserException() {
		super();
	}
	
	public UserException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UserException(String message) {
		super(message);
	}
	
}
