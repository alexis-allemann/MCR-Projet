package components.weapon;

import components.weapon.bullets.Bullet;
import components.weapon.bullets.StandardBullet;

/**
 * Standard weapon (by default used by spacecraft)
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class StandardWeapon extends Weapon{

    @Override
    Bullet getBullet() {
        return new StandardBullet(direction);
    }

    @Override
    int reloadTime() {
        return 500;
    }
}
