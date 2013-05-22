package fi.metropolia.VIOPE.physixlib;

import fi.metropolia.VIOPE.exception.NegativeException;

/**
 * 
 * @author duyb
 */
public class Brick {
	private float width, height, len;

	/**
	 * 
	 * @param width
	 *            of Brick
	 * @param height
	 *            of Brick
	 * @param len
	 *            of Brick
	 * @throws NegativeException 
	 */
	public Brick(float width, float height, float len) throws NegativeException {
		if (width <= 0 || height <= 0 || len <= 0)
			throw new NegativeException("Width, height and length must be positive");
		this.width = width;
		this.height = height;
		this.len = len;
	}

	/**
	 * 
	 * @return the float value of the area of the quad.
	 */
	public float Area() {
		return 2 * width * height + 2 * width * len + 2 * height * len;
	}

	/**
	 * 
	 * @return the float value of the volume of the quad.
	 */
	public float Volume() {
		return width * height * len;
	}
}
