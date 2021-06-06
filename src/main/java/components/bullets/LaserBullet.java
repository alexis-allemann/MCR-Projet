package components.bullets;

import java.awt.Point;

/**
 * Laser bullet
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserBullet extends Bullet {

    /**
     * Instantiation of a laser bullet
     *
     * @param shootLocation point where the shoot is located
     */
    public LaserBullet(Point shootLocation) {
        super(shootLocation, "laser.svg");
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getPower() {
        return 0;
    }
}
