package model.components.weapon;

import utils.physics.Vector2D;
import model.components.weapon.bullets.Bullet;
import controllers.Direction;

/**
 * Laser weapon
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserWeapon extends Weapon{
    @Override
    Bullet getBullet(Direction direction) {
        float y = direction == Direction.TOP ? -2.5f : 2.5f;
        return new Bullet("laser.png", new Vector2D(0, y), getFighter().isMonsterTeam()) {
            @Override
            public int getBaseSpeed() {
                return 5;
            }

            @Override
            public int getPower() {
                return 100;
            }
        };
    }

    @Override
    int reloadTimeInMilliSeconds() {
        return 500;
    }
}
