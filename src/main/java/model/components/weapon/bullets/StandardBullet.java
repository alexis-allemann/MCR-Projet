package model.components.weapon.bullets;

import model.components.physics.Vector2D;

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
     * @param direction of the bullet
     * @param isMonsterTeam if bullet is shot by a monster
     */
    public StandardBullet(Vector2D direction, boolean isMonsterTeam) {
        super("bullet.png", direction, isMonsterTeam);
    }
}
