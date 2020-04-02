package com.techchallenge.consoledrawing.exception;

/**
 * This is a exception class to handle Invalid Command.
 * 
 * @author Tanveer Hussain
 *
 */
public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This constructor must be thrown to handle exceptions.
	 * 
	 */
	public InvalidCommandException() {
		super("Invalid Command");
	}
	
	/**
	 * This constructor must be thrown to handle exceptions with custom message.
	 * 
	 */
	public InvalidCommandException(String message) {
		super(message);
	}

}
