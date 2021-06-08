package components.weapon;

import components.fighters.Fighter;
import components.physics.Location;
import components.physics.Vector2D;
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
        return new StandardBullet(new Vector2D(0, -1));
    }

    @Override
    int reloadTime() {
        return 500;
    }

    @Override
    Location getStartingBulletLocation(Fighter fighter) {
        float x = fighter.getLocation().x + fighter.getImageWidth() / 2.f;
        float y = fighter.getLocation().y;
        return new Location(x,y);
    }
}
