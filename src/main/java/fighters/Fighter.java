package fighters;

import bullets.Bullet;

import java.awt.*;

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
     *
     * @return bullet ready to be shot
     */
    Bullet getBullet();

    /**
     * Get fighter image
     *
     * @return fighter image
     */
    Image getImage();

    /**
     * Get fighter position
     *
     * @return where the fighter is drawn
     */
    Point getPosition();

    /**
     * Set fighter position
     *
     * @param point where the fighter is drawn
     */
    void setPosition(Point point);
}
