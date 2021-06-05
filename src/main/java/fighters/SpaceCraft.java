package fighters;

import bullets.Bullet;
import bullets.StandardBullet;

/**
 * Space craft used to fight against monsters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpaceCraft implements Fighter {

    @Override
    public void fight() {

    }

    @Override
    public Bullet getBullet() {
        return new StandardBullet();
    }
}
