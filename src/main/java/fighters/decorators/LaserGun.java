package fighters.decorators;

import bullets.Bullet;
import bullets.LaserBullet;
import fighters.Fighter;

/**
 * Laser gun to shoot laser bullets
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserGun extends FighterDecorator {

    /**
     * Instantiation of a new laser gun
     *
     * @param fighter to decorate
     */
    public LaserGun(Fighter fighter) {
        super(fighter);
    }

    @Override
    public Bullet getBullet() {
        return new LaserBullet();
    }
}
