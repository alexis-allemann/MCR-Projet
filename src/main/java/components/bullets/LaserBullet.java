package components.bullets;

import components.fighters.Fighter;
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
        super(shootLocation, "laser.png");
    }

    @Override
    public Speed getSpeed() {
        return BASE_SPEED;
    }

    @Override
    public int getPower() {
        return BASE_POWER;
    }

    @Override
    public void hit(Fighter fighter) {
    }

    @Override
    public void move() {
    }
}
