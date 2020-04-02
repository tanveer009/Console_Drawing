package com.techchallenge.consoledrawing.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

public class RectangleCommandTest {

	/**
	 * Set Up Simple Canvas
	 * 
	 * @throws InvalidCommandException
	 */
	@Before
	public void setUp() throws InvalidCommandException {
		String[] commandParams = { "C", "20", "4" };
		CommandFactory.getCommandType(commandParams).execute();
	}

	/**
	 * Test draw Rectangle method.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void testExecute() throws InvalidCommandException {
		String[] commandParams = { "R", "14", "1", "18", "3" };
		String expectedValue = "----------------------\n" + "|             xxxxx  |\n" + "|             x   x  |\n"
				+ "|             xxxxx  |\n" + "|                    |\n" + "----------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test draw Rectangle method with Invalid Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testExecute_InvalidParameter() throws InvalidCommandException {
		String[] commandParams = { "R", "4", "6", "4" };
		String expectedValue = "----------------------\n" + "|             xxx    |\\n" + "|             x x    |\n"
				+ "|             x x    |\n" + "|             xxx    |\n" + "----------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test draw Rectangle method with Negative Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testExecute_NegativeParameters() throws InvalidCommandException {
		String[] commandParams = { "R", "4", "6", "10", "-8" };
		String expectedValue = "----------------------\n" + "|             xxx    |\\n" + "|             x x    |\n"
				+ "|             x x    |\n" + "|             xxx    |\n" + "----------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test draw Rectangle method with Outside Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testExecute_OutsideParameters() throws InvalidCommandException {
		String[] commandParams = { "R", "4", "6", "25", "-8" };
		String expectedValue = "----------------------\n" + "|             xxx    |\\n" + "|             x x    |\n"
				+ "|             x x    |\n" + "|             xxx    |\n" + "----------------------\n";
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test isValid method.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void test_isValid() throws InvalidCommandException {
		String[] command = { "R", "14", "1", "19", "4" };
		int[] parameters = { 14, 1, 19, 4 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

	/**
	 * Test isValid method with Negative Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_isValid_NegativeParameters() throws InvalidCommandException {
		String[] command = { "R", "14", "1", "-19", "4" };
		int[] parameters = { 14, 1, -19, 4 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

	/**
	 * Test isValid method with Outside Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_isValid_OutsideCanvas() throws InvalidCommandException {
		String[] command = { "R", "25", "5", "29", "5" };
		int[] parameters = { 25, 5, 29, 5 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

}
