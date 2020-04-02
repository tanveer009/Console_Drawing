package com.techchallenge.consoledrawing.command;

import com.techchallenge.consoledrawing.constant.DrawingConstant;
import com.techchallenge.consoledrawing.exception.InvalidCommandException;
import com.techchallenge.consoledrawing.util.CommandUtil;

/**
 * 
 * This factory class is used to get the Command.
 * 
 * @author Tanveer Hussain
 *
 */
public class CommandFactory {

	private CommandFactory() {
	}

	/**
	 * This method is used to get the Command Type..
	 * 
	 * @param inputCommand
	 * @return Command
	 */
	public static Command getCommandType(String... command) throws InvalidCommandException {

		int[] dimensions;
		switch (command[0]) {
		case DrawingConstant.COMMAND_TYPE_QUIT:
			CommandUtil.validCount(1, command);
			return new QuitCommand();

		case DrawingConstant.COMMAND_TYPE_CANVAS:
			CommandUtil.validCount(3, command);
			dimensions = CommandUtil.parser(command[1], command[2]);
			return new CanvasCommand(dimensions[0], dimensions[1]);

		case DrawingConstant.COMMAND_TYPE_LINE:
			CommandUtil.validCount(5, command);
			dimensions = CommandUtil.parser(command[1], command[2], command[3], command[4]);
			return new LineCommand(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);

		case DrawingConstant.COMMAND_TYPE_RECTANGLE:
			CommandUtil.validCount(5, command);
			dimensions = CommandUtil.parser(command[1], command[2], command[3], command[4]);
			return new RectangleCommand(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);

		case DrawingConstant.COMMAND_TYPE_BUCKETFILL:
			CommandUtil.validCount(4, command);
			dimensions = CommandUtil.parser(command[1], command[2]);
			if (command[3].length() != 1) {
				throw new InvalidCommandException(DrawingConstant.COLOR_MESSAGE);
			}
			return new BucketFillCommand(dimensions[0], dimensions[1], command[3]);

		default:
			throw new InvalidCommandException(DrawingConstant.SHAPE_NOT_EXISTS);
		}

	}

}
