package model.components;

import utils.physics.Location;
import utils.physics.Vector2D;

import java.awt.Image;
import java.awt.Graphics2D;

/**
 * Game component interface
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public interface IGameComponent {

    /**
     * Get component image
     *
     * @return the image
     */
    Image getImage();

    /**
     * Get image width of the fighter
     *
     * @return width of the image
     */
    int getImageWidth();

    /**
     * Get image height of the fighter
     *
     * @return height of the image
     */
    int getImageHeight();

    /**
     * Get location
     *
     * @return the location
     */
    Location getLocation();

    /**
     * Set position
     *
     * @param location where the bullet is
     */
    void setLocation(Location location);

    /**
     * Draw component on given graphics
     *
     * @param graphics2D to paint component into
     */
    void draw(Graphics2D graphics2D);

}
