package com.techchallenge.consoledrawing.command;

import com.techchallenge.consoledrawing.constant.DrawingConstant;
import com.techchallenge.consoledrawing.exception.InvalidCommandException;
import com.techchallenge.consoledrawing.util.CommandUtil;
import com.techchallenge.consoledrawing.util.DrawingUtil;

/**
 * This class is used to create the Canvas Command.
 * 
 * @author Tanveer Hussain
 *
 */
public class CanvasCommand implements Command {

	private int width;
	private int height;

	/**
	 * Constructor to create the Canvas Command.
	 * 
	 * @param width
	 * @param height
	 * @throws InvalidCommandException
	 */
	CanvasCommand(int width, int height) throws InvalidCommandException {
		super();
		this.width = width;
		this.height = height;
		isValid(width, height);
		DrawingUtil.setTempCanvas(height, width);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * This method is used to create the Canvas.
	 * 
	 * @param canvasCommand
	 */
	@Override
	public String execute() {
		for (int row = 0; row < height + 2; row++) {
			for (int column = 0; column < width + 2; column++) {
				if (row == 0 || row == height + 2 - 1) {
					DrawingConstant.TEMP_CANVAS[row][column] = DrawingConstant.HORIZONTAL_LINE_CHAR;
				} else if (column == 0 || column == width + 2 - 1) {
					DrawingConstant.TEMP_CANVAS[row][column] = DrawingConstant.VERTICAL_LINE_CHAR;
				} else {
					DrawingConstant.TEMP_CANVAS[row][column] = ' ';
				}
			}
		}
		return DrawingUtil.charArrayToString();
	}

	/**
	 * This method is used to validate the given Parameters.
	 */
	@Override
	public boolean isValid(int... params) throws InvalidCommandException {
		if (CommandUtil.isNegativeParam(params))
			throw new InvalidCommandException(DrawingConstant.NON_POSITIVE_PARAM_MESSAGE);
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
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
		CanvasCommand other = (CanvasCommand) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

}
