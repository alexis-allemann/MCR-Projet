package components.weapon;

import components.fighters.Fighter;
import components.physics.Location;
import components.physics.Vector2D;
import components.weapon.bullets.Bullet;
import components.weapon.bullets.LaserBullet;
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
        float y = direction == Direction.TOP ? -1.f : 1.f;
        return new LaserBullet(new Vector2D(0, y));
    }

    @Override
    int reloadTime() {
        return 500;
    }

    @Override
    Location getStartingBulletLocation(Fighter fighter) {
        float x = fighter.getLocation().x + fighter.getImageWidth() / 2.f;
        float y = fighter.getLocation().y + (fighter.getDirection() == Direction.TOP ? -1.f : 1.f);
        return new Location(x,y);
    }

}
