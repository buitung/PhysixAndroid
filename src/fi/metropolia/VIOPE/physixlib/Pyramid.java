package fi.metropolia.VIOPE.physixlib;
/**
 *
 * @author duyb
 */
public class Pyramid {

    private float baseside1, baseside2, baseside3, height;
    private Triangle t;

    /**
     *
     * @param baseside1 base-side
     * @param baseside2 base-side
     * @param baseside3 base-side
     * @param height pyramid
     * Constructor
     */
    public Pyramid(float baseside1, float baseside2,
            float baseside3, float height) {
    	if (baseside1 <=0 || baseside2 <=0  || baseside3 <=0 || height <=0 )
    		throw new IllegalArgumentException("Three base sides and height must be positive");
        this.baseside1 = baseside1;
        this.baseside2 = baseside2;
        this.baseside3 = baseside3;
        this.height = height;
        t = new Triangle(baseside1, baseside2, baseside3);
    }
    
    /**
     *
     * @return the float value of the total area of the 4 planes.
     */
    public float Area() {
    	float s = t.Perimeter()/2;
        float ir = (float)Math.sqrt((s-baseside1)*(s-baseside2)*(s-baseside3)/s);
        float sh = MathUtils.Pythagore2D(height, ir);
        return t.Area() + s*sh;
    }
    
    /**
     *
     * @return the float value of the volume of the Pyramid. 
     */
    public float Volume(){
        return t.Area()*height/3;
    }
}
