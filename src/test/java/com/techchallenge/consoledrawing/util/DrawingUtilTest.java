package com.techchallenge.consoledrawing.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.techchallenge.consoledrawing.command.CommandFactory;
import com.techchallenge.consoledrawing.exception.InvalidCommandException;

/**
 * Test Drawing Util class
 * 
 * @author Tanveer Hussain
 *
 */
public class DrawingUtilTest {

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
	 * Test Create Line method
	 */
	@Test
	public void test_createLine() {
		DrawingUtil.createLine(6, 3, 6, 4);
		String expected = "----------------------\n" + "|                    |\n" + "|                    |\n"
				+ "|     x              |\n" + "|     x              |\n" + "----------------------\n";
		assertEquals(expected, DrawingUtil.charArrayToString());
	}

	/**
	 * Test checkifCanvasEmpty method
	 */
	@Test
	public void test_ifCanvasEmpty() {
		assertEquals(false, DrawingUtil.checkifCanvasEmpty());
	}

	/**
	 * Check if ifOutsideCanvas method with outside parameters
	 */
	@Test
	public void test_ifOutsideCanvas_Outside() {
		assertEquals(true, DrawingUtil.checkifOutsideCanvas(22, 5));
	}

	/**
	 * Test if ifOutsideCanvas method with inside parameters
	 */
	@Test
	public void test_ifOutsideCanvas_Inside() {
		assertEquals(false, DrawingUtil.checkifOutsideCanvas(2, 3));
	}

}
