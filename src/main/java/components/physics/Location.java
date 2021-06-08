package components.physics;

import java.awt.geom.Point2D;

/**
 * Location on game board
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Location extends Point2D.Float {

    /**
     * Instantiation of a new location
     *
     * @param x value on x axis
     * @param y value on y axis
     */
    public Location(float x, float y) {
        super(x, y);
    }

    /**
     * Move location according to given deltas
     *
     * @param dx move delta on x axis
     * @param dy move delta on y axis
     */
    public void translate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }
}
