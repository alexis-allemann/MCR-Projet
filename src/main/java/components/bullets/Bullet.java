package components.bullets;

import components.GameComponent;

import java.awt.Point;

/**
 * Bullets used on components.fighters.spacecraft shoots
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Bullet extends GameComponent {

    /**
     * Instantiation of a new bullet
     *
     * @param location point where the shoot is located
     * @param image    filename of the bullet image
     */
    public Bullet(Point location, String image) {
        super(location, image);
    }

    /**
     * Get bullet speed
     *
     * @return the speed
     */
    abstract int getSpeed();

    /**
     * Get bullet power
     *
     * @return the power
     */
    abstract int getPower();
}
