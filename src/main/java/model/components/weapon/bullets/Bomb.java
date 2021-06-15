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
     * @param direction     of the bomb
     * @param isMonsterTeam if bullet is shot by a monster
     */
    public Bomb(Vector2D direction, boolean isMonsterTeam) {
        super("bomb.png", direction, isMonsterTeam);
    }
}
