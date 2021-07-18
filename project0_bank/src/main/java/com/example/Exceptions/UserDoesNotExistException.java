package com.example.Exceptions;

public class UserDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserDoesNotExistException() {
		super("Sorry, we couldn't find your username. Please try again.");
	}

}
