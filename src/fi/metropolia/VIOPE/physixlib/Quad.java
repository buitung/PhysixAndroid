package fi.metropolia.VIOPE.physixlib;

import fi.metropolia.VIOPE.exception.NegativeException;

/**
 * 
 * @author duyb
 */
public class Quad {
	private float width, height;

	/**
	 * 
	 * @param width
	 *            of Quad
	 * @param height
	 *            of Quad Constructor
	 * @throws NegativeException 
	 */
	public Quad(float width, float height) throws NegativeException {
		if (width <= 0 || height <= 0)
			throw new NegativeException(
					"Width and Height must be positive");
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 * @return the float value of the area of the quad
	 */
	public float Area() {
		return width * height;
	}

	/**
	 * 
	 * @return the float value of the perimeter of the quad
	 */
	public float Perimeter() {
		return 2 * (width + height);
	}
}
