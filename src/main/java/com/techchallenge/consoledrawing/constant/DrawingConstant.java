package com.techchallenge.consoledrawing.constant;

/**
 * This class is used to create Constant in order to use them in Application.
 * 
 * @author Tanveer Hussain
 *
 */
public final class DrawingConstant {

	public static final String COMMAND_TYPE_CANVAS = "C";
	public static final String COMMAND_TYPE_RECTANGLE = "R";
	public static final String COMMAND_TYPE_LINE = "L";
	public static final String COMMAND_TYPE_QUIT = "Q";
	public static final String COMMAND_TYPE_BUCKETFILL = "B";
	public static final char HORIZONTAL_LINE_CHAR = '-';
	public static final char VERTICAL_LINE_CHAR = '|';
	public static final char LINE_CHARACTER = 'x';
	public static final char RECTANGLE_CHARACTER = 'x';
	public static final String EMPTY_STRING=" ";
	public static char[][] TEMP_CANVAS;
	public static int CANVAS_HEIGHT;
	public static int CANVAS_WIDTH;
	public static final String WELCOME_MESSAGE = "Welcome to Console Drawing...\n" + DrawingConstant.FORMAT_MESSAGE
			+ "\nPlease Enter command to draw shapes:";
	public static final String FORMAT_MESSAGE = "Command Format:" + "\n1. To Create a Canvas : C width height -> C 20 4"
			+ "\n2. To Create a line : L x1 y1 x2 y2 -> L 1 2 6 2"
			+ "\n3. To Create a Rectangle : R x1 y1 x2 y2 -> R 14 1 18 3" + "\n4. To Fill Bucket : B x y c-> B 10 3 o"
			+ "\n5. To Quit the Console : Q";
	public static final String NON_POSITIVE_PARAM_MESSAGE = "Shape cannot be drawn.Parameters should be greater than zero.";
	public static final String OUTSIDE_CANVAS_BOUNDARIES = "Shape cannot be drawn.Parameters should be within the Canvas Boundaries";
	public static final String CANVAS_EMPTY_MESSAGE = "Canvas is empty.Create Canvas first";
	public static final String DIAGONAL_LINE_MESSAGE = "Diagonal Line not Supported.";
	public static final String BLANK_INPUT = "Blank Input";
	public static final String COLOR_MESSAGE = "Color should be of only one char.";
	public static final String SHAPE_NOT_EXISTS = "No such Shape exists.Kindly check your Command.";
	public static final String ENTER_COMMAND = "Please Enter command to draw shapes: ";
}
