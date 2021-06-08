package components.fighters;

import components.bullets.Bullet;
import components.bullets.StandardBullet;
import components.physics.Location;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Space craft used to fight against monsters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpaceCraft extends Fighter {

    /**
     * Instantiation of a new spacecraft
     *
     * @param location where spacecraft is located
     */
    public SpaceCraft(Location location) {
        super(location, "spacecraft.png");
    }

    @Override
    public void shoot() {

    }

    @Override
    public Bullet getBullet() {
        return new StandardBullet(getLocation());
    }

    @Override
    public boolean exist() {
        return true;
    }
}
