package model.components.weapon;

import utils.physics.Direction;
import utils.Utils;
import utils.physics.Speed;

/**
 * Bomb weapon
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class BombWeapon extends Weapon {
    @Override
    public Projectile getBullet(Direction direction) {
        float y = direction == Direction.TOP ? -4f : 4f;
        return new Projectile("bomb.png", new Speed(Utils.getInstance().randomFloat(-1, 1), y), getFighter().isMonsterTeam()) {
        };
    }

    @Override
    public int reloadTimeInMilliSeconds() {
        return 5000;
    }
}
