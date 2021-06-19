package model.components.weapon;

import utils.physics.Speed;
import utils.physics.Direction;

/**
 * Standard weapon (by default used by spacecraft)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class StandardWeapon extends Weapon {

    @Override
    public Projectile getBullet(Direction direction) {
        float y = direction == Direction.TOP ? -5f : 5f;
        return new Projectile("bullet.png", new Speed(0, y), getFighter().isMonsterTeam()) {
        };
    }

    @Override
    public int reloadTimeInMilliSeconds() {
        return 1000;
    }

}
