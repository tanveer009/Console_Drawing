package com.techchallenge.consoledrawing;

import java.util.Scanner;

import com.techchallenge.consoledrawing.command.CommandProcessor;
import com.techchallenge.consoledrawing.constant.DrawingConstant;

/**
 * This is the main class to run this application
 * 
 * @author Tanveer Hussain
 *
 */
public class ConsoleDrawingMain {

	/**
	 * Main method to run the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(DrawingConstant.WELCOME_MESSAGE);

			while (true) {
				String inputCommand = scanner.nextLine();
				CommandProcessor.process(inputCommand);
				System.out.println(DrawingConstant.ENTER_COMMAND);
			}
		}
	}

}
