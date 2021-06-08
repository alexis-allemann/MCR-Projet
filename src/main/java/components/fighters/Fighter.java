package components.fighters;

import components.GameComponent;
import components.weapon.Weapon;
import components.physics.Vector2D;
import components.physics.Location;
import controllers.Direction;

/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Fighter extends GameComponent {
    private final Vector2D SPEED_BASE = new Vector2D(1.f, 0.f);
    private final int POWER_BASE = 1;
    protected boolean alive = true;
    protected Vector2D speed;
    private Weapon weapon;

    /**
     * Instantiation of a new fighter
     *
     * @param location where fighter is located
     * @param image    filename of the fighter to display
     */
    public Fighter(Location location, String image) {
        super(location, image);
        speed = SPEED_BASE;
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
}
