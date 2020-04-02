package com.techchallenge.consoledrawing.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

public class LineCommandTest {

	/**
	 * Setup simple Canvas
	 * 
	 * @throws InvalidCommandException
	 */
	@Before
	public void setUp() throws InvalidCommandException {
		String[] commandParams = { "C", "20", "4" };
		CommandFactory.getCommandType(commandParams).execute();
	}

	/**
	 * Test Vertical Line Creation
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void testExecute_Vertical() throws InvalidCommandException {
		String[] commandParams = { "L", "1", "4", "6", "4" };
		String expectedValue = "----------------------\n" + "|                    |\n" + "|                    |\n"
				+ "|                    |\n" + "|xxxxxx              |\n" + "----------------------\n";

		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test Horizontal Line Creation
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void testExecute_Horizontal() throws InvalidCommandException {
		String[] commandParams = { "L", "3", "1", "3", "4" };
		String expectedValue = "----------------------\n" + "|  x                 |\n" + "|  x                 |\n"
				+ "|  x                 |\n" + "|  x                 |\n" + "----------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test Horizontal Line Creation with Invalid Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testExecute_InvalidParameters() throws InvalidCommandException {
		String[] commandParams = { "L", "0", "1", "0" };
		String expectedValue = "----------------------\n" + "|  x                 |\n" + "|  x                 |\n"
				+ "|  x                 |\n" + "|  x                 |\n" + "----------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	@Test
	public void testExecute_Diagonal() throws InvalidCommandException {
		String[] commandParams = { "L", "1", "1", "3", "3" };
		String expectedValue = "Diagonal Line not Supported.";
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test isValid method.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void test_isValid() throws InvalidCommandException {
		String[] command = { "L", "3", "1", "3", "4" };
		int[] parameters = { 3, 1, 3, 4 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

	/**
	 * Test isValid method with Negative Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_isValid_NegativeParameters() throws InvalidCommandException {
		String[] command = { "L", "3", "1", "-3", "4" };
		int[] parameters = { 3, 1, -3, 4 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

	/**
	 * Test isValid method with Outside Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_isValid_OutsideCanvas() throws InvalidCommandException {
		String[] command = { "L", "25", "5", "29", "5" };
		int[] parameters = { 25, 5, 29, 5 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}
}
