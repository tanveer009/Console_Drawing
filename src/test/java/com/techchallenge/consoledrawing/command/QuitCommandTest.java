package com.techchallenge.consoledrawing.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

public class QuitCommandTest {

	/**
	 * Set up Simple Canvas
	 * 
	 * @throws InvalidCommandException
	 */
	@Before
	public void setUp() throws InvalidCommandException {
		String[] commandParams = { "C", "20", "4" };
		CommandFactory.getCommandType(commandParams).execute();
	}

	/**
	 * Test Quit Command with Invalid Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testQuitCommand_InvalidParameters() throws InvalidCommandException {
		String[] commandParams = { "q" };
		String expectedValue = "Console Exit...";
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

}
