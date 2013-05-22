package fi.metropolia.VIOPE.physixlib;

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
	 */
	public Sphere(float r) {
		if (radius <= 0)
			throw new IllegalArgumentException("Radius must be positive");
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
