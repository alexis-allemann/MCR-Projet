package components.fighters;

import components.bullets.Bullet;
import components.physics.Location;

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
    public Monster(Location location) {
        super(location, "monster-green.png");
    }

    @Override
    public void shoot() {
        // crée une nouvelle balle

        // l'ajoute dans le vector du gameplay
    }

    @Override
    public void move() {

    }

    @Override
    public Bullet getBullet() {
        return null;
    }

    @Override
    public boolean exist(){
        return alive;
    }

}
