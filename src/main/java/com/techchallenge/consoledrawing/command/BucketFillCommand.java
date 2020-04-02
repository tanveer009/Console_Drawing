package com.techchallenge.consoledrawing.command;

import com.techchallenge.consoledrawing.constant.DrawingConstant;
import com.techchallenge.consoledrawing.exception.InvalidCommandException;
import com.techchallenge.consoledrawing.util.CommandUtil;
import com.techchallenge.consoledrawing.util.DrawingUtil;

/**
 * This class is used to create the Bucket Fill Command.
 * 
 * @author Tanveer Hussain
 *
 */
public class BucketFillCommand implements Command {

	private int xParam;
	private int yParam;
	private char color;

	/**
	 * Constructor to create Bucket Fill Command.
	 * 
	 * @param xParam
	 * @param yParam
	 * @param color
	 * @throws InvalidCommandException
	 */
	BucketFillCommand(int xParam, int yParam, String color) throws InvalidCommandException {
		super();
		isValid(xParam, yParam);
		this.xParam = xParam;
		this.yParam = yParam;
		this.color = color.charAt(0);
	}

	public int getxParam() {
		return xParam;
	}

	public void setxParam(int xParam) {
		this.xParam = xParam;
	}

	public int getyParam() {
		return yParam;
	}

	public void setyParam(int yParam) {
		this.yParam = yParam;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	/**
	 * This method is used for Bucket filling.
	 * 
	 * @param bucketFillCommand
	 */
	@Override
	public String execute() {
		char oldColor = DrawingConstant.TEMP_CANVAS[yParam][xParam];
		fillBucket(xParam, yParam, oldColor, color);
		return DrawingUtil.charArrayToString();
	}

	/**
	 * This method is used to validate the given Parameters.
	 */
	@Override
	public boolean isValid(int... params) throws InvalidCommandException {
		if (DrawingUtil.checkifCanvasEmpty()) {
			throw new InvalidCommandException(DrawingConstant.CANVAS_EMPTY_MESSAGE);
		}
		if (CommandUtil.isNegativeParam(params)) {
			throw new InvalidCommandException(DrawingConstant.NON_POSITIVE_PARAM_MESSAGE);
		}
		if (DrawingUtil.checkifOutsideCanvas(params[0], params[1])) {
			throw new InvalidCommandException(DrawingConstant.OUTSIDE_CANVAS_BOUNDARIES + "\nWidth: "
					+ DrawingConstant.CANVAS_WIDTH + "\nHeight: " + DrawingConstant.CANVAS_HEIGHT);
		}
		return true;
	}

	/**
	 * This method is used to fill color within boundaries.
	 * 
	 * @param x
	 * @param y
	 * @param oldColor
	 * @param newColor
	 */
	private static void fillBucket(int x, int y, char oldColor, char newColor) {
		if (y < 0 || x < 0 || y > DrawingConstant.CANVAS_HEIGHT || x > DrawingConstant.CANVAS_WIDTH) {
			return;
		}
		if (DrawingConstant.TEMP_CANVAS[y][x] != oldColor) {
			return;
		}
		DrawingConstant.TEMP_CANVAS[y][x] = newColor;
		fillBucket(x - 1, y, oldColor, newColor);
		fillBucket(x, y - 1, oldColor, newColor);
		fillBucket(x + 1, y, oldColor, newColor);
		fillBucket(x - 1, y + 1, oldColor, newColor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + color;
		result = prime * result + xParam;
		result = prime * result + yParam;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BucketFillCommand other = (BucketFillCommand) obj;
		if (color != other.color)
			return false;
		if (xParam != other.xParam)
			return false;
		if (yParam != other.yParam)
			return false;
		return true;
	}

}
