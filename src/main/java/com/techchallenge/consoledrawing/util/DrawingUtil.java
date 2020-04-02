package com.techchallenge.consoledrawing.util;

import com.techchallenge.consoledrawing.constant.DrawingConstant;

/**
 * This is a utility class for the Drawing.
 * 
 * @author Tanveer Hussain
 *
 */
public class DrawingUtil {

	/**
	 * This method is used to draw horizontal or vertical Lines.
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public static void createLine(int x1, int y1, int x2, int y2) {
		for (int row = y1; row <= y2; row++) {
			for (int column = x1; column <= x2; column++) {
				DrawingConstant.TEMP_CANVAS[row][column] = DrawingConstant.LINE_CHARACTER;
			}
		}
	}

	/**
	 * This method covert 2D charArray to String
	 * 
	 * @return
	 */
	public static String charArrayToString() {
		StringBuilder builder = new StringBuilder();
		for (int row = 0; row < DrawingConstant.CANVAS_HEIGHT + 2; row++) {
			for (int column = 0; column < DrawingConstant.CANVAS_WIDTH + 2; column++) {
				builder.append(DrawingConstant.TEMP_CANVAS[row][column]);
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	/**
	 * This method checks if Canvas is empty or not.
	 * 
	 * @return true if empty,otherwise false.
	 */
	public static boolean checkifCanvasEmpty() {
		if (DrawingConstant.CANVAS_HEIGHT == 0 || DrawingConstant.CANVAS_WIDTH == 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks if given parameters are outside of the Canvas or not.
	 * 
	 * @param width
	 * @param height
	 * @return true if outside,otherwise false.
	 */
	public static boolean checkifOutsideCanvas(int width, int height) {
		if (height > DrawingConstant.CANVAS_HEIGHT || width > DrawingConstant.CANVAS_WIDTH) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to print the Shape.
	 */
	public static void printShape(String result) {
		System.out.println(result);
	}

	/**
	 * This method is used to set the Temporary Canvas to be used within the
	 * application.
	 * 
	 * @param height
	 * @param width
	 */
	public static void setTempCanvas(int height, int width) {
		DrawingConstant.TEMP_CANVAS = new char[height + 2][width + 2];
		DrawingConstant.CANVAS_HEIGHT = height;
		DrawingConstant.CANVAS_WIDTH = width;
	}
}
