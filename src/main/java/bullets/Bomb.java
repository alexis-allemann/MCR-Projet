package bullets;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Bomb used by monsters
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public class Bomb implements Bullet {

    private static Image image;
    private static final Logger LOG = Logger.getLogger(Bomb.class.getName());
    private Point shootLocation;

    public Bomb() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            image = ImageIO.read(classloader.getResource("bomb.png"));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Bomb image has not been found in resources");
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
