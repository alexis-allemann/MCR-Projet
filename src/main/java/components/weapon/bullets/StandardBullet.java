package components.weapon.bullets;

import components.physics.Vector2D;

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
     * @param direction of the bullet
     */
    public StandardBullet(Vector2D direction) {
        super("bullet.png", direction);
    }
}
