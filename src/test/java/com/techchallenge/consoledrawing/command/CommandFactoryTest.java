package com.techchallenge.consoledrawing.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

/**
 * Test class for Command Factory
 * 
 * @author Tanveer Hussain
 *
 */
public class CommandFactoryTest {

	@Before
	public void setUp() throws InvalidCommandException {
		String[] commandParams = { "C", "20", "4" };
		CommandFactory.getCommandType(commandParams).execute();
	}

	@Test
	public void testGetCommandType_Canvas() throws InvalidCommandException {
		String[] inputParams = { "C", "80", "16" };
		CanvasCommand canvasCommand = new CanvasCommand(80, 16);
		assertEquals(canvasCommand, CommandFactory.getCommandType(inputParams));
	}

	@Test
	public void testGetCommandType_Line() throws InvalidCommandException {
		String[] inputParams = { "L", "1", "2", "6", "2" };
		LineCommand lineCommand = new LineCommand(1, 2, 6, 2);
		assertEquals(lineCommand, CommandFactory.getCommandType(inputParams));
	}

	@Test
	public void testGetCommandType_Rectangle() throws InvalidCommandException {
		String[] inputParams = { "R", "14", "1", "18", "4" };
		RectangleCommand rectangleCommand = new RectangleCommand(14, 1, 18, 4);
		assertEquals(rectangleCommand, CommandFactory.getCommandType(inputParams));
	}

	@Test
	public void testGetCommandType_BucketFill() throws InvalidCommandException {
		String[] inputParams = { "B", "3", "4", "j" };
		BucketFillCommand bucketFillCommand = new BucketFillCommand(3, 4, "j");
		assertEquals(bucketFillCommand, CommandFactory.getCommandType(inputParams));
	}

	@Test(expected = InvalidCommandException.class)
	public void testGetCommandType_InvalidCOmmand() throws InvalidCommandException {
		String[] inputParams = { "B", "8", "1" };
		BucketFillCommand bucketFillCommand = new BucketFillCommand(8, 1, "j");
		assertEquals(bucketFillCommand, CommandFactory.getCommandType(inputParams));
	}

}
