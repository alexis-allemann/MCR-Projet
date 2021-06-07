package components;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Displayable game component
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class GameComponent {
    private static final Logger LOG = Logger.getLogger(GameComponent.class.getName());
    private Point location;
    private Image image;

    /**
     * Instantiation of a new game component
     *
     * @param location where component is located
     * @param filename of the image to display
     */
    public GameComponent(Point location, String filename) {
        this.location = location;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            image = ImageIO.read(classloader.getResource(filename));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Component image has not been found in resources");
        }
    }

    /**
     * Instantiation of a new game component
     *
     * @param location where component is located
     * @param image    image to display
     */
    public GameComponent(Point location, Image image) {
        this.location = location;
        this.image = image;
    }

    /**
     * Get component image
     *
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Get location
     *
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Set position
     *
     * @param point where the bullet is
     */
    public void setLocation(Point point) {
        this.location = point;
    }

    /**
     * Get the next location point
     * @return the next location
     */
    public abstract boolean nextLocation();
}
