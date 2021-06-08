package components.bullets;

import components.fighters.Fighter;
import components.physics.Location;
import components.physics.Speed;

/**
 * Bomb used by monsters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Bomb extends Bullet {

    /**
     * Instantiation of a new bomb
     *
     * @param shootLocation point where the shoot is located
     */
    public Bomb(Location shootLocation) {
        super(shootLocation, "bomb.png");
    }

    @Override
    public Speed getSpeed() {
        return new Speed(1, 1);
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public void hit(Fighter fighter) {
    }
}
