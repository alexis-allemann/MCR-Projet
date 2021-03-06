package utils.physics;

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
     * Instantiation of a new location
     *
     * @param location location we want to copy
     */
    public Location(Location location) {
        super(location.x, location.y);
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

    /**
     * @return the x coordinate as an int
     */
    public int getIntX() {
        return (int) x;
    }

    /**
     * @return the y coordinate as an int
     */
    public int getIntY() {
        return (int) y;
    }

    /**
     * @return the x coordinate
     */
    public float getFloatX(){
        return x;
    }

    /**
     * @return the y coordinate
     */
    public float getFloatY(){
        return y;
    }
}
