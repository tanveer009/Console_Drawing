package com.techchallenge.consoledrawing.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

public class CommandUtilTest {

	/**
	 * Test valid Count with Correct Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void test_validCount() throws InvalidCommandException {
		assertEquals(true, CommandUtil.validCount(3, "1", "2", "3"));
	}

	/**
	 * Test valid Count with Incorrect Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_validCount_IncorrectParams() throws InvalidCommandException {
		assertEquals(false, CommandUtil.validCount(4, "1", "2", "3"));
	}

	/**
	 * Test parser with Correct Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test
	public void test_parser_CorrectParams() throws InvalidCommandException {
		String[] inputParams = { "1", "2", "3" };
		int[] expected = { 1, 2, 3 };
		assertArrayEquals(expected, CommandUtil.parser(inputParams));
	}

	/**
	 * Test parser with Incorrect Parameters
	 * 
	 * @throws InvalidCommandException
	 */
	@Test(expected = InvalidCommandException.class)
	public void test_parser_IncorrectParams() throws InvalidCommandException {
		String[] inputParams = { "1", "A", "3" };
		int[] expected = { 1, 2, 3 };
		assertEquals(expected, CommandUtil.parser(inputParams));
	}

	/**
	 * Test isNegativeParam method with Positive parameters
	 */
	@Test
	public void test_isNegativeParam_PositiveParameters() {
		int[] inputParams = { 2, 3, 4, 5 };
		assertEquals(false, CommandUtil.isNegativeParam(inputParams));
	}

	/**
	 * Test isNegativeParam method with Negative parameters
	 */
	@Test
	public void test_isNegativeParam_NegativeParameters() {
		int[] inputParams = { -2, 3, -4, 5 };
		assertEquals(true, CommandUtil.isNegativeParam(inputParams));
	}

	/**
	 * Test isNegativeParam method with 0 parameter
	 */
	@Test
	public void test_isNegativeParam_ZeroParameter() {
		int[] inputParams = { 2, 0, 4, 5 };
		assertEquals(true, CommandUtil.isNegativeParam(inputParams));
	}

	/**
	 * Test filterCommandParam method.
	 */
	@Test
	public void test_filterCommandParam() {
		String[] expected = { "B", "1", "2", "f" };
		assertArrayEquals(expected, CommandUtil.filterCommandParam("B", "", null, "1", "2", "f"));
	}

}
