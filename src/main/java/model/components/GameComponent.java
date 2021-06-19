package model.components;

import utils.Utils;
import utils.physics.Location;

import java.awt.Image;
import java.awt.Graphics2D;

/**
 * Displayable game component
 *
 * @author Allemann, Balestrieri, Christen, Mottier, Zeller
 * @version 1.0
 */
public abstract class GameComponent implements IGameComponent{
    protected Location location;
    protected final Image image;

    /**
     * Instantiation of a new game component
     *
     * @param location where component is located
     * @param imageName of the image to display
     */
    public GameComponent(Location location, String imageName) {
        this.location = location;
        image = Utils.getInstance().getImageFromResources(imageName);
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

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public int getImageWidth() {
        return getImage().getWidth(null);
    }

    @Override
    public int getImageHeight() {
        return getImage().getHeight(null);
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(getImage(), getLocation().getIntX(), getLocation().getIntY(), null);
    }
}
