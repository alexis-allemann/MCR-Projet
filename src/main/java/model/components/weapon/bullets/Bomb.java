package model.components.weapon.bullets;

import model.components.physics.Vector2D;

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
     * @param direction of the bomb
     */
    public Bomb(Vector2D direction) {
        super("bomb.png", direction);
    }
}
