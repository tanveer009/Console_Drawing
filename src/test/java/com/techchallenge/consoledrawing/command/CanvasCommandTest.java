package com.techchallenge.consoledrawing.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

/**
 * Test Class for CanvasCommand.
 * 
 * @author Tanveer Hussain
 *
 */
public class CanvasCommandTest {

	/**
	 * Test execute method.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void testExecute() throws InvalidCommandException {
		String[] command = { "C", "20", "4" };
		String expectedValue = "----------------------\n" + "|                    |\n" + "|                    |\n"
				+ "|                    |\n" + "|                    |\n" + "----------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(command).execute());
	}

	/**
	 * Test execute method with Large Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void testExecute_LargeParameters() throws InvalidCommandException {
		String[] command = { "C", "40", "8" };
		String expectedValue = "------------------------------------------\n"
				+ "|                                        |\n" + "|                                        |\n"
				+ "|                                        |\n" + "|                                        |\n"
				+ "|                                        |\n" + "|                                        |\n"
				+ "|                                        |\n" + "|                                        |\n"
				+ "------------------------------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(command).execute());
	}

	/**
	 * Test execute method with Negative Width.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testValidateParams_NegativeWidth() throws InvalidCommandException {
		String[] command = { "C", "-40", "8" };
		String expectedValue = "------------------------------------------\n"
				+ "|                                        |\n" + "|                                        |\n"
				+ "|                                        |\n" + "|                                        |\n"
				+ "|                                        |\n" + "|                                        |\n"
				+ "|                                        |\n" + "|                                        |\n"
				+ "------------------------------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(command).execute());
	}

	/**
	 * Test execute method with Negative Height.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testValidateParams_NegativeHeight() throws InvalidCommandException {
		String[] command = { "C", "40", "-8" };
		String expectedValue = "Shape cannot be drawn.Parameters should be greater than zero.";
		assertEquals(expectedValue, CommandFactory.getCommandType(command).execute());
	}

	/**
	 * Test isValid method.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void test_isValid() throws InvalidCommandException {
		String[] command = { "C", "40", "8" };
		int[] parameters = { 40, 8 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

	/**
	 * Test isValid method with Incorrect parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_isValid_IncorrectParameters() throws InvalidCommandException {
		String[] command = { "C", "40", "-8" };
		int[] parameters = { 40, -8 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}
}
