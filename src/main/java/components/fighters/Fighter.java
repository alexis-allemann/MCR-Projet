package components.fighters;

import components.GameComponent;
import components.bullets.Bullet;
import components.physics.Speed;
import components.physics.Location;


/**
 * Space invaders fighter
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class Fighter extends GameComponent {

    final private Speed SPEED_BASE = new Speed(1.f, 0.f);
    final int POWER_BASE = 1;
    protected boolean alive = true;
    protected Speed speed;

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
     * Shoot action
     */
    public abstract void shoot();

    /**
     * Move action
     */
    public void move(){
        this.location.translate(speed.getX(), speed.getY());
    }

    /**
     * Get a new bullet
     *
     * @return bullet ready to be shot
     */
    public abstract Bullet getBullet();
}
