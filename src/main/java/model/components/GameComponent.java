package components;

import components.physics.Location;

import javax.imageio.ImageIO;
import java.awt.Image;
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
    protected Location location;
    protected Image image;

    /**
     * Instantiation of a new game component
     *
     * @param location where component is located
     * @param filename of the image to display
     */
    public GameComponent(Location location, String filename) {
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
    public GameComponent(Location location, Image image) {
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
     * Get image width of the fighter
     *
     * @return width of the image
     */
    public int getImageWidth() {
        return getImage().getWidth(null);
    }

    /**
     * Get image height of the fighter
     *
     * @return height of the image
     */
    public int getImageHeight() {
        return getImage().getHeight(null);
    }

    /**
     * Get location
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set position
     *
     * @param location where the bullet is
     */
    public void setLocation(Location location) {
        this.location = location;
    }



}
