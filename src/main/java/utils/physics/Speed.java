package utils.physics;

/**
 * Vector 2D on game
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Speed {
    private float x;
    private float y;

    /**
     * Instantiation of a new 2D vector
     *
     * @param x value on x axis
     * @param y value on y axis
     */
    public Speed(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Instantiation of a new 2D vector with zeros as values for x and y axis
     */
    public Speed() {
        this(0, 0);
    }

    /**
     * Get value on x axis
     *
     * @return move on x axis
     */
    public float getX() {
        return x;
    }

    /**
     * Get value on y axis
     *
     * @return value on y axis
     */
    public float getY() {
        return y;
    }

    /**
     * Set value on x axis
     *
     * @param x move on x axis
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Set value on y axis
     *
     * @param y move on y axis
     */
    public void setY(float y) {
        this.y = y;
    }

}
