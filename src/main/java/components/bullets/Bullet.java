package components.bullets;

import components.GameComponent;
import components.fighters.Fighter;
import levels.Level;

import java.awt.Point;

/**
 * Bullets used on components.fighters.spacecraft shoots
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Bullet extends GameComponent {

    final int SPEED_BASE = 1;
    final int POWER_BASE = 1;
    private Level level;
    /**
     * Instantiation of a new bullet
     *
     * @param location point where the shoot is located
     * @param image    filename of the bullet image
     */
    public Bullet(Point location, String image, Level level) {
        super(location, image);
        this.level = level;
    }

    /**
     * Get bullet speed
     *
     * @return the speed
     */
    abstract int getSpeed();

    /**
     * Get bullet level
     *
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Get bullet power
     *
     * @return the power
     */
    abstract int getPower();

    /**
     * Remove health to the fighter equal to the power of the bullet
     *
     * @param fighter fighter to remove health
     */
    public abstract void hit(Fighter fighter);

    /**
     * Move bullet with as speed base added with speed of the bullet
     */
    public abstract void move();

    /**
     * Check if fighter has the position where the bullet will be
     * @param fighter Fighter Fighter to check position
     * @return True if there's a fighter to next location
     */
    public boolean checkNextLocation(Fighter fighter){
        return fighter.getLocation().equals(new Point(getLocation().x, getLocation().y + getSpeed()));
    }
}
