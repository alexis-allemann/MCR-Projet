package components.weapon;

import components.fighters.Fighter;
import components.physics.Location;
import components.physics.Vector2D;
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
        return new LaserBullet(new Vector2D(0, 1));
    }

    @Override
    int reloadTime() {
        return 500;
    }

    @Override
    Location getStartingBulletLocation(Fighter fighter) {
        return new Location(fighter.getLocation().x,fighter.getLocation().y);
    }

}
