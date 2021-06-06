package components.bullets;

import java.awt.Point;

/**
 * Standard bullet
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class StandardBullet extends Bullet {

    /**
     * Instantiation of a new standard bullet
     *
     * @param shootLocation point where the shoot is located
     */
    public StandardBullet(Point shootLocation) {
        super(shootLocation, "bullet.png");
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
