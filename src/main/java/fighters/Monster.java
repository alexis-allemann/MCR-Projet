package fighters;

import bullets.Bomb;
import bullets.Bullet;

import java.awt.*;

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

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void setPosition(Point point) {

    }
}
