package com.techchallenge.consoledrawing.command;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

/**
 * 
 * This interface should be implemented by all type of Command.
 * 
 * @author Tanveer Hussain
 *
 */
public interface Command {

	/**
	 * To execute the Command.
	 * 
	 * @return
	 */
	String execute();

	/**
	 * To validate the Command.
	 * 
	 * @param params
	 * @return
	 * @throws InvalidCommandException
	 */
	boolean isValid(int... params) throws InvalidCommandException;

}
