package components.bullets;

import components.fighters.GameComponent;
import components.physics.Location;
import components.physics.Speed;

/**
 * Laser bullet
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserBullet extends Bullet {

    /**
     * Instantiation of a laser bullet
     *
     * @param shootLocation point where the shoot is located
     */
    public LaserBullet(Location shootLocation) {
        super(shootLocation, "laser.svg");
    }

    @Override
    public Speed getSpeed() {
        return SPEED_BASE;
    }

    @Override
    public int getPower() {
        return POWER_BASE;
    }

    @Override
    public void hit(GameComponent fighter) {

    }

    @Override
    public void move() {

    }
}
