package model.components.fighters;

import model.World;
import model.components.GameComponentWithHitBox;
import model.components.weapon.Weapon;
import model.components.physics.Vector2D;
import model.components.physics.Location;
import controllers.Direction;

/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Fighter extends GameComponentWithHitBox {
    private static final Vector2D SPEED_BASE = new Vector2D(1.f, 0.f);
    protected Vector2D speed;
    private Weapon weapon;
    private int health;

    /**
     * Instantiation of a new fighter
     *
     * @param location where fighter is located
     * @param image    filename of the fighter to display
     */
    public Fighter(Location location, String image) {
        super(location, image);
        speed = SPEED_BASE;
        health = getDefaultHealth();
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
     * Move action
     */
    public void move() {
        location.translate(speed.getX(), speed.getY());
    }

    /**
     * Get the fighter's weapon
     *
     * @return fighter's weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Set the fighter's weapon
     *
     * @param weapon Weapon to set
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Get fighter speed
     *
     * @return vector 2d of the speed
     */
    public Vector2D getSpeed() {
        return speed;
    }

    /**
     * Set the fighter speed vector
     *
     * @param speed vector
     */
    public void setSpeed(Vector2D speed) {
        this.speed = speed;
    }

    /**
     * Get shoot direction
     *
     * @return the shoot direction
     */
    public abstract Direction getDirection();

    /**
     * Get default health
     * @return default health
     */
    public abstract int getDefaultHealth();

    /**
     * Get fighter's health
     *
     * @return fighter's health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Check if fighter is still alive
     *
     * @return true if fighter is alive
     */
    public boolean alive() {
        return getHealth() > 0;
    }

    /**
     * Removing healing points to the fighter's health
     *
     * @param hp healing points to remove
     */
    public void removeHealth(int hp) {
        health -= hp;
    }

    /**
     * shoot with weapon
     */
    public void shoot() {
        if (getWeapon() != null)
            getWeapon().shoot(this);
    }

    /**
     * Death action
     */
    public void die() {
        World.getInstance().removeMonster(this);
    }
}
