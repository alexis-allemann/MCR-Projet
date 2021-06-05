package fighters;

import bullets.Bullet;

import java.awt.*;

/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Fighter {

    private int health;

    /**
     * Fight action
     */
    public abstract void fight();

    /**
     * Get a new bullet
     *
     * @return bullet ready to be shot
     */
    public abstract Bullet getBullet();

    /**
     * Get fighter image
     *
     * @return fighter image
     */
    public abstract Image getImage();

    /**
     * Get fighter position
     *
     * @return where the fighter is drawn
     */
    public abstract Point getPosition();

    /**
     * Set fighter position
     *
     * @param point where the fighter is drawn
     */
    public abstract void setPosition(Point point);
}
