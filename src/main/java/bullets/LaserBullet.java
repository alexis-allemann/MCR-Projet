package bullets;

import fighters.SpaceCraft;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Laser bullet
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class LaserBullet implements Bullet  {

    private static Image image;
    private static final Logger LOG = Logger.getLogger(LaserBullet.class.getName());
    private Point shootLocation;
    public LaserBullet() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            image = ImageIO.read(classloader.getResource("laser.svg"));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Laser image has not been found in resources");
        }
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public Point getPosition() {
        return shootLocation;
    }

    @Override
    public void setPosition(Point point) {
        this.shootLocation = point;
    }
}
