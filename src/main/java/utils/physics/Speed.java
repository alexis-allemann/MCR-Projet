package utils.physics;

/**
 * Vector 2D on game
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Vector2D {
    private float X;
    private float Y;

    /**
     * Instantiation of a new 2D vector
     *
     * @param x value on x axis
     * @param y value on y axis
     */
    public Vector2D(float x, float y) {
        this.X = x;
        this.Y = y;
    }

    /**
     * Instantiation of a new 2D vector with zeros as values for x and y axis
     *
     */
    public Vector2D() {
        this(0, 0);
    }

    /**
     * Get value on x axis
     *
     * @return move on x axis
     */
    public float getX() {
        return X;
    }

    /**
     * Get value on y axis
     *
     * @return value on y axis
     */
    public float getY() {
        return Y;
    }

    /**
     * Set value on x axis
     *
     * @param x move on x axis
     */
    public void setX(float x) {
        X = x;
    }

    /**
     * Set value on y axis
     *
     * @param y move on y axis
     */
    public void setY(float y) {
        Y = y;
    }

}
