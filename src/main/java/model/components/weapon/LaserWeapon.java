package model.components.weapon;

import model.components.fighters.Fighter;
import model.components.physics.Location;
import model.components.physics.Vector2D;
import model.components.weapon.bullets.Bullet;
import model.components.weapon.bullets.LaserBullet;
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
        float y = direction == Direction.TOP ? -5.f : 5.f;
        return new LaserBullet(new Vector2D(0, y));
    }

    @Override
    int reloadTime() {
        return 500;
    }


}
