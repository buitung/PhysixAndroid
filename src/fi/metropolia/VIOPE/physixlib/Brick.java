package fi.metropolia.VIOPE.physixlib;

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
	 */
	public Brick(float width, float height, float len) {
		if (width <= 0 || height <= 0 || len <= 0)
			throw new IllegalArgumentException("Width, height and length must be positive");
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
