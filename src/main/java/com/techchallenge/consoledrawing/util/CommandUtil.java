package com.techchallenge.consoledrawing.util;

import java.util.Arrays;

import com.techchallenge.consoledrawing.exception.InvalidCommandException;

/**
 * This is the utility class for the Commands.
 * 
 * @author Tanveer Hussain
 *
 */
public class CommandUtil {

	/**
	 * 
	 * This method checks the given argument count
	 * 
	 * @param expectedCount
	 * @param args
	 * @return
	 * @throws InvalidCommandException
	 */
	public static boolean validCount(int expectedCount, String... args) throws InvalidCommandException {
		if (args.length != expectedCount)
			throw new InvalidCommandException("No. of Parameters must be " + expectedCount + ".");
		return true;
	}

	/**
	 * This method parse the given String argument to int array.
	 * 
	 * @param args
	 * @return
	 * @throws InvalidCommandException
	 */
	public static int[] parser(String... args) throws InvalidCommandException {
		int[] parsedArr = new int[args.length];
		try {
			for (int i = 0; i < args.length; i++) {
				parsedArr[i] = Integer.parseInt(args[i]);
			}
		} catch (NumberFormatException e) {
			throw new InvalidCommandException("Provided dimensions are incorrect. Kindly check them");
		}

		return parsedArr;
	}

	/**
	 * This method checks if the given parameters are less than or equal to zero.
	 * 
	 * @param params
	 * @return true if zero/negative,otherwise false.
	 */
	public static boolean isNegativeParam(int... params) {
		return Arrays.stream(params).anyMatch(p -> p <= 0);
	}

	/**
	 * Method to remove empty or null values.
	 * 
	 * @param commandParams
	 * @return
	 */
	public static String[] filterCommandParam(String... commandParams) {
		return Arrays.stream(commandParams).filter(value -> value != null && value.length() > 0)
				.toArray(size -> new String[size]);
	}

}
