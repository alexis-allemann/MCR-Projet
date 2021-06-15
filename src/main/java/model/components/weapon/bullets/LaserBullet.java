package model.components.weapon.bullets;

import model.components.physics.Vector2D;

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
     * @param direction of the bullet
     * @param isMonsterTeam if bullet is shot by a monster
     */
    public LaserBullet(Vector2D direction, boolean isMonsterTeam) {
        super("laser.png", direction, isMonsterTeam);
    }

    @Override
    public int getBaseSpeed() {
        return 5;
    }

    @Override
    public int getPower() {
        return 100;
    }
}
