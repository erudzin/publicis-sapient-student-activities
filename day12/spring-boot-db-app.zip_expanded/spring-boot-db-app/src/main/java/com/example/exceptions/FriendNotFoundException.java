package com.example.exceptions;

/*
 * Checked exception must extend Exception class and you must have overloaded constructor
 * that takes message as an argument
 */
@SuppressWarnings("serial")
public class FriendNotFoundException extends Exception {

	public FriendNotFoundException() {
		super();
	}

	public FriendNotFoundException(String message) {
		super(message);
	}	
}
