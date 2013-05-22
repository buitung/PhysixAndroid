package fi.metropolia.VIOPE.physixlib;
/**
 *
 * @author duyb
 */
public class Circle {

    private float radius;

    /**
     *
     * @param r radius of circle
     */
    public Circle(float r) {
        this.radius = r;
    }
    
    /**
     *
     * @return the float value of the area of the circle using PI 
     */
    public float Area(){
        return MathUtils.PI * radius * radius;
    }
    
    /**
     *
     * @return the float value of the circumference of the circle
     */
    public float Circumference(){
        return 2 * MathUtils.PI * radius;
    }
}
