package model.components;

import model.components.physics.Location;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Objects;

/**
 * Displayable game component
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class GameComponent {
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
            image = ImageIO.read(Objects.requireNonNull(classloader.getResource(filename)));
        } catch (IOException e) {
            System.out.println("Component image has not been found in resources");
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

    /**
     * Draw component on given graphics
     *
     * @param graphics2D to paint component into
     */
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(getImage(), getLocation().getIntX(), getLocation().getIntY(), null);
    }
}
