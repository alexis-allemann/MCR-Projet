package model.components.weapon.bullets;

import model.components.physics.Vector2D;

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
     * @param direction of the bullet
     */
    public LaserBullet(Vector2D direction) {
        super("laser.png", direction);
    }

    @Override
    public int getBaseSpeed() {
        return 5;
    }
}
