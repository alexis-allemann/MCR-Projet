package model.components.physics;

/**
 * Vector 2D on game
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Vector2D {
    private final float X;
    private final float Y;

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
}
