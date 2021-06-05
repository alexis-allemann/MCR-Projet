package fighters;

import bullets.Bomb;
import bullets.Bullet;

import java.awt.*;
import java.util.logging.Logger;

/**
 * Monsters used to fight against space craft
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Monster extends Fighter {
    private static final Logger LOG = Logger.getLogger(SpaceCraft.class.getName());
    private static Image image;
    private Point point;
    @Override
    public void fight() {

    }

    @Override
    public Bullet getBullet() {
        return new Bomb();
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Point getPosition() {
        return point;
    }

    @Override
    public void setPosition(Point point) {
        this.point = point;
    }
}
