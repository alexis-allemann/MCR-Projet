package components.weapon;

import components.weapon.bullets.Bullet;
import components.weapon.bullets.LaserBullet;

/**
 * Laser weapon
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserWeapon extends Weapon{
    @Override
    Bullet getBullet() {
        return new LaserBullet();
    }

    @Override
    int reloadTime() {
        return 500;
    }
}
