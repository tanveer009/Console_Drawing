package com.techchallenge.consoledrawing.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

public class BucketFillCommandTest {

	@Before
	public void setUp() throws InvalidCommandException {
		String[] commandParams = { "C", "20", "4" };
		CommandFactory.getCommandType(commandParams).execute();
		String[] commandParamsRect = { "R", "14", "1", "18", "3" };
		CommandFactory.getCommandType(commandParamsRect).execute();
	}

	/**
	 * Test execute method
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void testExecute() throws InvalidCommandException {
		String expectedValue = "----------------------\n" + "|             xxxxx  |\n" + "|             xcccx  |\n"
				+ "|             xxxxx  |\n" + "|                    |\n" + "----------------------\n";
		String[] commandParams = { "B", "15", "2", "c" };
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());

	}

	/**
	 * Test execute method with Complex Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void testExecute_ComplexParameters() throws InvalidCommandException {
		String expected = "----------------------\n" + "|kkkkkkkkkkkkkxxxxxkk|\n" + "|kkkkkkkkkkkkkx   xkk|\n"
				+ "|kkkkkkkkkkkkkxxxxxkk|\n" + "|kkkkkkkkkkkkkkkkkkkk|\n" + "----------------------\n";
		String[] commandParams = { "B", "1", "2", "k" };
		assertEquals(expected, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test execute method with Invalid Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testExecute_InvalidParameters() throws InvalidCommandException {
		String expectedValue = "----------------------\n" + "|             xxxxx  |\n" + "|             xcccx  |\n"
				+ "|             xxxxx  |\n" + "|                    |\n" + "----------------------\n";
		String[] commandParams = { "B", "15", "2" };
		assertEquals(expectedValue, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test execute method with Negative Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testExecute_NegativeParameters() throws InvalidCommandException {
		String expected = "----------------------\n" + "|kkkkkkkkkkkkkxxxxxkk|\n" + "|kkkkkkkkkkkkkx   xkk|\n"
				+ "|kkkkkkkkkkkkkxxxxxkk|\n" + "|kkkkkkkkkkkkkkkkkkkk|\n" + "----------------------\n";
		String[] commandParams = { "B", "1", "-2", "k" };
		assertEquals(expected, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test execute method with Outside Canvas Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void testExecute_OutsideCanvas() throws InvalidCommandException {
		String expected = "----------------------\n" + "|kkkkkkkkkkkkkxxxxxkk|\n" + "|kkkkkkkkkkkkkx   xkk|\n"
				+ "|kkkkkkkkkkkkkxxxxxkk|\n" + "|kkkkkkkkkkkkkkkkkkkk|\n" + "----------------------\n";
		String[] commandParams = { "B", "40", "2", "k" };
		assertEquals(expected, CommandFactory.getCommandType(commandParams).execute());
	}

	/**
	 * Test isValid method.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void test_isValid() throws InvalidCommandException {
		String[] command = { "B", "1", "2", "k" };
		int[] parameters = { 1, 2 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

	/**
	 * Test isValid method with Negative Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_isValid_NegativeParameters() throws InvalidCommandException {
		String[] command = { "B", "40", "2", "k" };
		int[] parameters = { 14, -5, };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

	/**
	 * Test isValid method with Outside Parameters.
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_isValid_OutsideCanvas() throws InvalidCommandException {
		String[] command = { "B", "40", "2", "k" };
		int[] parameters = { 25, 5 };
		assertTrue(CommandFactory.getCommandType(command).isValid(parameters));
	}

}
