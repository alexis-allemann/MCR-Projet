package model.components.fighters;

import model.World;
import model.components.GameComponentWithHitbox;
import model.components.weapon.Weapon;
import model.components.physics.Vector2D;
import model.components.physics.Location;
import controllers.Direction;
import controllers.gameplay.FighterManager;

/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Fighter extends GameComponentWithHitbox {
    private final Vector2D SPEED_BASE = new Vector2D(1.f, 0.f);
    private final int POWER_BASE = 1;
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
        health = 1;
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
     * Get shoot direction
     *
     * @return the shoot direction
     */
    public abstract Direction getDirection();

    /**
     * Get fighter's health
     * @return fighter's health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Check if fighter is still alive
     * @return true if fighter is alive
     */
    public boolean alive(){
        return getHealth() > 0;
    }

    /**
     * Removing healing points to the fighter's health
     * @param hp healing points to remove
     */
    public void removeHealth(int hp){
        health -= hp;
    }

    /**
     * shoot with weapon
     */
    public void shoot(){
        if(getWeapon() != null)
        getWeapon().shoot(this);
    }

    /**
     * Death action
     */
    public void die(){
       World.getInstance().removeMonster(this);
    }
}
