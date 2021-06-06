package components.fighters;

import components.GameComponent;
import components.bullets.Bullet;

import java.awt.Point;

/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Fighter extends GameComponent {

    /**
     * Instantiation of a new fighter
     *
     * @param location where fighter is located
     * @param image    filename of the fighter to display
     */
    public Fighter(Point location, String image) {
        super(location, image);
    }

    /**
     * Instantiation of a new fighter
     *
     * @param fighter to encompass
     */
    public Fighter(Fighter fighter) {
        super(fighter.getLocation(), fighter.getImage());
    }

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
}
