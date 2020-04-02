package com.techchallenge.consoledrawing.command;

import com.techchallenge.consoledrawing.constant.DrawingConstant;
import com.techchallenge.consoledrawing.exception.InvalidCommandException;
import com.techchallenge.consoledrawing.util.CommandUtil;
import com.techchallenge.consoledrawing.util.DrawingUtil;

/**
 * This class is used to process the input Command.
 * 
 * @author Tanveer Hussain
 *
 */
public class CommandProcessor {

	/**
	 * This method validates the given Command and return Command Type based on the
	 * inputs provided.
	 * 
	 * @param inputCommand
	 */
	public static void process(String inputCommand) {
		try {
			String[] commandParams = inputCommand.trim().isEmpty() ? null
					: inputCommand.trim().split(DrawingConstant.EMPTY_STRING);
			if (commandParams == null)
				throw new InvalidCommandException(DrawingConstant.BLANK_INPUT);
			DrawingUtil
					.printShape(CommandFactory.getCommandType(CommandUtil.filterCommandParam(commandParams)).execute());
		} catch (InvalidCommandException e) {
			System.out.println(e.getMessage());
		}
	}

}
