package model.components.weapon;

import utils.physics.Vector2D;
import controllers.Direction;

/**
 * Laser weapon
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserWeapon extends Weapon{
    @Override
    public Projectile getBullet(Direction direction) {
        float y = direction == Direction.TOP ? -10f : 10f;
        return new Projectile("laser.png", new Vector2D(0, y), getFighter().isMonsterTeam()) {
            @Override
            public int getPower() {
                return 100;
            }
        };
    }

    @Override
    public int reloadTimeInMilliSeconds() {
        return 5000;
    }
}
