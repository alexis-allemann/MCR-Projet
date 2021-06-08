package components.fighters;

import components.bullets.Bullet;
import components.bullets.StandardBullet;
import components.physics.Location;

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
    public Bullet getBullet() {
        StandardBullet bullet = new StandardBullet(getLocation());
        bullet.setLocation(new Location(getLocation().x + (getImageWidth() / 2) - (bullet.getImageWidth() / 2), getLocation().y - bullet.getImageHeight()));
        return bullet;
    }

    @Override
    public boolean exist() {
        return true;
    }
}
