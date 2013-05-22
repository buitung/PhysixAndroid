package fi.metropolia.VIOPE.physixlib;

import fi.metropolia.VIOPE.exception.NegativeException;

/**
 * 
 * @author duyb
 */
public class Sphere {

	private float radius;

	/**
	 * 
	 * @param r
	 *            radius of sphere Constructor
	 * @throws NegativeException 
	 */
	public Sphere(float r) throws NegativeException {
		if (r <= 0)
			throw new NegativeException("Radius must be positive");
		radius = r;
	}

	/**
	 * 
	 * @return the float value of the area of the sphere
	 */
	public float Area() {
		return 4 * MathUtils.PI * radius * radius;
	}

	/**
	 * 
	 * @return the float value of the volume of the sphere
	 */
	public float Volume() {
		return 4 / 3 * MathUtils.PI * radius * radius * radius;
	}
}
