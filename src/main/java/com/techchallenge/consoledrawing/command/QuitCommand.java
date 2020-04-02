package com.techchallenge.consoledrawing.command;

/**
 * This class is used to create the Quit Command.
 * 
 * @author Tanveer Hussain
 *
 */
public class QuitCommand implements Command {

	/**
	 * Constructor to create the Quit Command.
	 */
	QuitCommand() {
		isValid();
	}

	/**
	 * This method is used to quit the application.
	 * 
	 * @param quitCommand
	 */
	@Override
	public String execute() {
		System.out.println("Exiting Console...");
		System.exit(0);
		return null;
	}

	/**
	 * This method is used to validate the given Parameters.
	 */
	@Override
	public boolean isValid(int... params) {
		return true;
	}

}
