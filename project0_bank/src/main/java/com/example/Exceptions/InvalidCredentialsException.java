package com.example.Exceptions;

public class InvalidCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException() {
		super("Sorry, that password does not match. Please try again.");
	}

}
