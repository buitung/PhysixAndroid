package fi.metropolia.VIOPE.physixlib;

import fi.metropolia.VIOPE.exception.NegativeException;

/**
 * 
 * @author duyb
 */
public class Circle {

	private float radius;

	/**
	 * 
	 * @param r
	 *            radius of circle
	 * @throws NegativeException 
	 */
	public Circle(float r) throws NegativeException {
		if (r <= 0)
			throw new NegativeException("Radius must be positive");
		this.radius = r;
	}

	/**
	 * 
	 * @return the float value of the area of the circle using PI
	 */
	public float Area() {
		return MathUtils.PI * radius * radius;
	}

	/**
	 * 
	 * @return the float value of the circumference of the circle
	 */
	public float Circumference() {
		return 2 * MathUtils.PI * radius;
	}
}
