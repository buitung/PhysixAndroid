package fi.metropolia.VIOPE.physixlib;
/**
 * @author: Tung Trinh
 */
public class Projectile {

    /**
     * Velocity Angle Gravitational acceleration
     */
    private float velocity;
    private float angle;
    private float g = 9.8f;

    /**
     * Initial
     */
    public Projectile() {
        velocity = angle = 0;
    }

    /**
     *
     * @param v velocity
     * @param a angle Constructor
     */
    public Projectile(float v, float a) {
        this.velocity = v;
        this.angle = a;
    }

    /**
     *
     * @return the float value of the duration a projectile would spend in the
     * air providing a float angle and a float velocity.
     */
    public float ProjTime() {
        return 2 * velocity * ((float) Math.sin(angle)) / g;
    }

    /**
     *
     * @return the float value of the distance a projectile would travel
     * providing a float angle and a float velocity.
     */
    public float Distance() {
        float ss;
        if (angle == 0 || angle == MathUtils.Deg2Rad(180)
                || angle == MathUtils.Deg2Rad(90)) {
            ss = 0;
        } else {
            ss = (float) Math.sin(2 * angle);
        }
        return (float) Math.pow(velocity, 2) * ss / g;
    }

    /**
     *
     * @return the float value of the height a projectile would reach providing
     * a float angle and a float velocity.
     */
    public float Height() {
        return (float) Math.pow(velocity, 2)
                * (float) Math.pow((float) Math.sin(angle), 2) / (2 * g);
    }
}
