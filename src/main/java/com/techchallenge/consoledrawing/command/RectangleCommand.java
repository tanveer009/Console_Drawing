package com.techchallenge.consoledrawing.command;

import com.techchallenge.consoledrawing.constant.DrawingConstant;
import com.techchallenge.consoledrawing.exception.InvalidCommandException;
import com.techchallenge.consoledrawing.util.CommandUtil;
import com.techchallenge.consoledrawing.util.DrawingUtil;

/**
 * This class is used to create the Rectangle Command.
 * 
 * @author Tanveer Hussain
 *
 */
public class RectangleCommand implements Command {

	private int x1Param;
	private int y1Param;
	private int x2Param;
	private int y2Param;

	/**
	 * Constructor to create the Rectangle Command.
	 * 
	 * @param x1Param
	 * @param y1Param
	 * @param x2Param
	 * @param y2Param
	 * @throws InvalidCommandException
	 */
	 RectangleCommand(int x1Param, int y1Param, int x2Param, int y2Param) throws InvalidCommandException {
		super();
		isValid(x1Param, y1Param, x2Param, y2Param);
		this.x1Param = x1Param;
		this.y1Param = y1Param;
		this.x2Param = x2Param;
		this.y2Param = y2Param;
	}

	public int getX1Param() {
		return x1Param;
	}

	public void setX1Param(int x1Param) {
		this.x1Param = x1Param;
	}

	public int getY1Param() {
		return y1Param;
	}

	public void setY1Param(int y1Param) {
		this.y1Param = y1Param;
	}

	public int getX2Param() {
		return x2Param;
	}

	public void setX2Param(int x2Param) {
		this.x2Param = x2Param;
	}

	public int getY2Param() {
		return y2Param;
	}

	public void setY2Param(int y2Param) {
		this.y2Param = y2Param;
	}

	/**
	 * This method is used to create the Rectangle.
	 * 
	 * @param rectangleCommand
	 */
	@Override
	public String execute() {
		DrawingUtil.createLine(x1Param, y1Param, x1Param, y2Param);
		DrawingUtil.createLine(x1Param, y1Param, x2Param, y1Param);
		DrawingUtil.createLine(x2Param, y1Param, x2Param, y2Param);
		DrawingUtil.createLine(x1Param, y2Param, x2Param, y2Param);
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
		if (DrawingUtil.checkifOutsideCanvas(params[0], params[1])
				|| DrawingUtil.checkifOutsideCanvas(params[2], params[3])) {
			throw new InvalidCommandException(DrawingConstant.OUTSIDE_CANVAS_BOUNDARIES + "\nWidth: "
					+ DrawingConstant.CANVAS_WIDTH + "\nHeight: " + DrawingConstant.CANVAS_HEIGHT);
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x1Param;
		result = prime * result + x2Param;
		result = prime * result + y1Param;
		result = prime * result + y2Param;
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
		RectangleCommand other = (RectangleCommand) obj;
		if (x1Param != other.x1Param)
			return false;
		if (x2Param != other.x2Param)
			return false;
		if (y1Param != other.y1Param)
			return false;
		if (y2Param != other.y2Param)
			return false;
		return true;
	}

}
