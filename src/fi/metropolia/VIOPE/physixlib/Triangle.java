package fi.metropolia.VIOPE.physixlib;
/**
 *
 * @author duyb
 */
public class Triangle {
    private float a,b,c;
    
    /**
     *
     * @param a side of triangle
     * @param b side of triangle
     * @param c side of triangle
     * Constructor
     */
    public Triangle(float a,float b,float c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /**
     *
     * @return the float value of the perimeter of the triangle
     */
    public float Perimeter(){
        return a+b+c;
    }
    
    /**
     *
     * @return the float value of the area of the triangle
     */
    public float Area(){
        float p = Perimeter()/2;
        return (float)Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
