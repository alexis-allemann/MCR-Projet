package model.components.weapon;

import utils.physics.Vector2D;
import model.components.weapon.bullets.Bullet;
import controllers.Direction;

/**
 * Standard weapon (by default used by spacecraft)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class StandardWeapon extends Weapon{

    @Override
    Bullet getBullet(Direction direction) {
        float y = direction == Direction.TOP ? -1.f : 1.f;
        return new Bullet("bullet.png", new Vector2D(0, y), getFighter().isMonsterTeam()) {
            @Override
            public int getBaseSpeed() {
                return super.getBaseSpeed();
            }

            @Override
            public int getPower() {
                return super.getPower();
            }
        };
    }

    @Override
    int reloadTimeInMilliSeconds() {
        return 1000;
    }

}
