package fi.metropolia.VIOPE.physixlib;
/**
 *
 * @author duyb
 */
public class Quad {
    private float width,height;
    /**
     *
     * @param width of Quad
     * @param height of Quad
     * Constructor
     */
    public Quad(float width,float height){
        this.width = width;
        this.height = height;
    }
    
    /**
     *
     * @return the float value of the area of the quad
     */
    public float Area(){
        return width*height;
    }
    
    /**
     *
     * @return the float value of the perimeter of the quad
     */
    public float Perimeter(){
        return 2*(width+height);
    }
}
