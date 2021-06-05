package fighters;

import bullets.Bomb;
import bullets.Bullet;

/**
 * Monsters used to fight against space craft
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Monster implements Fighter {

    @Override
    public void fight() {

    }

    @Override
    public Bullet getBullet() {
        return new Bomb();
    }
}
