package components.bullets;

import java.awt.Point;

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
    public Bomb(Point shootLocation) {
        super(shootLocation, "bomb.png");
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getPower() {
        return 0;
    }
}
