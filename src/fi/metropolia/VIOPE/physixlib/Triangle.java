package fi.metropolia.VIOPE.physixlib;

import fi.metropolia.VIOPE.exception.NegativeException;

/**
 * 
 * @author duyb
 */
public class Triangle {
	private float a, b, c;

	/**
	 * 
	 * @param a
	 *            side of triangle
	 * @param b
	 *            side of triangle
	 * @param c
	 *            side of triangle Constructor
	 * @throws NegativeException 
	 */
	public Triangle(float a, float b, float c) throws NegativeException {
		if (a <= 0 || b <= 0 || c <= 0)
			throw new NegativeException("Three sides must be positive");
		if (a + b <= c || a + c <= b || b + c <= a)
			throw new IllegalArgumentException(
					"These are not three sides of a triangle");
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * 
	 * @return the float value of the perimeter of the triangle
	 */
	public float Perimeter() {
		return a + b + c;
	}

	/**
	 * 
	 * @return the float value of the area of the triangle
	 */
	public float Area() {
		float p = Perimeter() / 2;
		return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
}
