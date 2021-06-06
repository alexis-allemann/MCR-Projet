package components.bullets;

import components.fighters.Fighter;

import java.awt.Point;

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
    public LaserBullet(Point shootLocation) {
        super(shootLocation, "laser.svg");
    }

    @Override
    public int getSpeed() {
        return SPEED_BASE + getLevel().getMonstersSpeed();
    }

    @Override
    public int getPower() {
        return POWER_BASE;
    }

    @Override
    public void hit(Fighter fighter) {

    }

    @Override
    public void move() {

    }
}
