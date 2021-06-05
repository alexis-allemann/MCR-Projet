package fighters;

import bullets.Bullet;
import bullets.StandardBullet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Space craft used to fight against monsters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class SpaceCraft implements Fighter {
    private static final Logger LOG = Logger.getLogger(SpaceCraft.class.getName());
    private static Image image;
    private Point point;

    /**
     * Instantiation of a new SpaceCraft
     */
    public SpaceCraft() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            image = ImageIO.read(classloader.getResource("spacecraft.png"));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Spacecraft image has not been found in resources");
        }
    }

    @Override
    public void fight() {

    }

    @Override
    public Bullet getBullet() {
        return new StandardBullet();
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
