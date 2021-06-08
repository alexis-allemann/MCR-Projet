package components.physics;

/**
 * Speed vector on game
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Speed {
    private float x;
    private float y;

    /**
     * Instantiation of a new speed vector
     *
     * @param x move on x axis
     * @param y move on y axis
     */
    public Speed(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get move on x axis
     *
     * @return move on x axis
     */
    public float getX() {
        return x;
    }

    /**
     * Get move on y axis
     *
     * @return move on y axis
     */
    public float getY() {
        return y;
    }
}
