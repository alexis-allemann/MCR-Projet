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
    public Bullet getBullet(Direction direction) {
        float y = direction == Direction.TOP ? -10f : 10f;
        return new Bullet("laser.png", new Vector2D(0, y), getFighter().isMonsterTeam()) {
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
