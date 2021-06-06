package components.fighters;

import components.bullets.Bullet;

import java.awt.*;

/**
 * Monsters used to fight against space craft
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Monster extends Fighter {

    /**
     * Instantiation of a new monster
     *
     * @param location where monster is located
     */
    public Monster(Point location) {
        super(location, "monster-green.png");
    }

    @Override
    public void fight() {

    }

    @Override
    public Bullet getBullet() {
        return null;
    }
}
