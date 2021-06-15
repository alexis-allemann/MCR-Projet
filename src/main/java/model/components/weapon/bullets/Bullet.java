package model.components.weapon.bullets;

import model.components.GameComponentWithHitBox;
import model.components.fighters.Fighter;
import model.components.physics.Vector2D;
import model.components.physics.Location;

/**
 * Bullets used on model.components.fighters.spacecraft shoots
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Bullet extends GameComponentWithHitBox {
    static final int BASE_SPEED = 10;
    final int BASE_POWER = 1;
    protected Vector2D speed;

    /**
     * Instantiation of a new bullet
     *
     * @param image filename of the bullet image
     * @param direction of the bullet
     */
    public Bullet(String image, Vector2D direction) {
        super(new Location(0, 0), image);
        this.speed = new Vector2D(direction.getX() * getBaseSpeed(), direction.getY() * getBaseSpeed());
    }

    /**
     * Get default bullet speed
     *
     * @return the speed
     */
    public int getBaseSpeed() {
        return BASE_SPEED;
    }

    /**
     * Get bullet power
     *
     * @return the power
     */
    public int getPower() {
        return BASE_POWER;
    }

    /**
     * Remove health to the fighter equal to the power of the bullet
     *
     * @param fighter fighter to remove health
     */
    public void hit(Fighter fighter) {
        fighter.removeHealth(getPower());
    }

    /**
     * Move bullet with as speed base added with speed of the bullet
     */
    public void move() {
        this.location.translate(speed.getX(), speed.getY());
    }

    /**
     * Check if fighter has the position where the bullet will be
     *
     * @param fighter Fighter Fighter to check position
     * @return True if there's a fighter to next location
     */
    public boolean checkNextLocation(Fighter fighter) {
        return checkHitBox(speed, fighter);
    }
}
