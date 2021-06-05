package fighters;

import bullets.Bullet;

/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface Fighter {

    /**
     * Fight action
     */
    void fight();

    /**
     * Get a new bullet
     * @return bullet ready to be shot
     */
    Bullet getBullet();
}
