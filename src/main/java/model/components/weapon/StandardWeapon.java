package model.components.weapon;

import model.components.fighters.Fighter;
import model.components.physics.Location;
import model.components.physics.Vector2D;
import model.components.weapon.bullets.Bullet;
import model.components.weapon.bullets.StandardBullet;
import controllers.Direction;

/**
 * Standard weapon (by default used by spacecraft)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class StandardWeapon extends Weapon{

    /**
     * Time between reloads for standard weapon
     */
    private final static int RELOAD_TIME_STANDARD = 500;

    @Override
    Bullet getBullet(Direction direction) {
        float y = direction == Direction.TOP ? -1.f : 1.f;
        return new StandardBullet(new Vector2D(0, y));
    }

    @Override
    int reloadTime() {
        return RELOAD_TIME_STANDARD;
    }

}
