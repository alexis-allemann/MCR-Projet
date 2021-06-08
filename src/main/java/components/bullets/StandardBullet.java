package components.bullets;

import components.fighters.Fighter;
import components.physics.Location;
import components.physics.Speed;

/**
 * Standard bullet
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class StandardBullet extends Bullet {

    /**
     * Instantiation of a new standard bullet
     *
     * @param shootLocation point where the shoot is located
     */
    public StandardBullet(Location shootLocation) {
        super(shootLocation, "bullet.png");
    }

    @Override
    public Speed getSpeed() {
        return BASE_SPEED;
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public void hit(Fighter fighter) {

    }
}
